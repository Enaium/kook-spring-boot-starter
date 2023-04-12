/*
 * Copyright 2023 Enaium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.enaium.kookstarter.client.socket;

import cn.enaium.kookstarter.configuration.KookConfiguration;
import cn.enaium.kookstarter.event.Event;
import cn.enaium.kookstarter.event.Events;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.annotation.NonNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import static cn.enaium.kookstarter.KookStarter.LOGGER;

/**
 * @author Enaium
 * @since 0.3.0
 */
@Component
public class DefaultHandler implements WebSocketHandler {

    private final KookConfiguration configuration;
    private final ApplicationEventPublisher publisher;

    public AtomicInteger sn = new AtomicInteger();

    public DefaultHandler(KookConfiguration configuration, ApplicationEventPublisher publisher) {
        this.configuration = configuration;
        this.publisher = publisher;
    }

    @NonNull
    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.receive().map(WebSocketMessage::getPayloadAsText).publishOn(Schedulers.boundedElastic()).doOnNext(message -> {
            if (configuration.isShowSign()) {
                LOGGER.info(message);
            }

            JsonNode jsonNode;
            try {
                jsonNode = new ObjectMapper().readValue(message, JsonNode.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            if (jsonNode.has("sn")) {
                sn.set(jsonNode.get("sn").intValue());
            }


            switch (jsonNode.get("s").intValue()) {
                case 1 -> {//握手成功
                    session.send(ping(session)).subscribe();
                    LOGGER.info("连接建立成功");
                }
                case 3 -> {//收到pong
                    session.send(ping(session)).subscribe();
                }
                case 5 -> {//要求客户端断开当前连接重新连接
                    sn.set(0);
                }
                case 0 -> {//事件
                    final var data = jsonNode.get("d");
                    final var extra = data.get("extra");
                    final var type = extra.get("type").asText();
                    final Class<? extends Event> event;
                    //除消息事件之外，其余都是系统事件
                    if (data.get("type").intValue() == 255) {//系统事件
                        event = Events.EVENTS.get(type);
                    } else {//消息事件
                        event = Events.EVENTS.get("message_" + type);
                    }

                    if (event == null) {
                        LOGGER.info("未知事件:{}", type);
                        return;
                    }

                    try {
                        publisher.publishEvent(event.getConstructor(Object.class, Object.class).newInstance(this, message));
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).then();
    }

    //创建ping
    private Mono<WebSocketMessage> ping(WebSocketSession session) {
        return Mono.just(session.pingMessage(factory -> factory.wrap(("{\"s\":2,\"sn\":" + sn.get() + "}").getBytes(StandardCharsets.UTF_8))));
    }


    //解压zlib
    private byte[] decompress(DataBuffer dataBuffer) throws IOException, DataFormatException {
        Inflater inflater = new Inflater();
        final var compressedData = dataBuffer.asInputStream().readAllBytes();
        inflater.setInput(compressedData);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressedData.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();

        return outputStream.toByteArray();
    }
}
