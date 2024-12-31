/*
 * Copyright 2022 Enaium
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

import cn.enaium.kookstarter.model.event.Event;
import cn.enaium.kookstarter.model.event.Events;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Enaium
 */
@Component
public class DefaultHandler implements WebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHandler.class);

    private final ObjectMapper objectMapper;
    private final ApplicationEventPublisher publisher;
    private final DefaultClient defaultClient;

    private final List<Event> events = new ArrayList<>();

    public AtomicInteger sn = new AtomicInteger();

    private long lastPong = System.currentTimeMillis();

    public DefaultHandler(ObjectMapper objectMapper, ApplicationEventPublisher publisher, DefaultClient defaultClient, ApplicationContext applicationContext) {
        this.objectMapper = objectMapper;
        this.publisher = publisher;
        this.defaultClient = defaultClient;
        events.addAll(Events.EVENTS);
        events.addAll(applicationContext.getBeansOfType(Event.class).values());
    }

    @Override
    public @NotNull Mono<Void> handle(@NotNull WebSocketSession session) {
        Flux<WebSocketMessage> ping = Flux.interval(Duration.ofSeconds(30)).map(i -> session.textMessage("{\"s\":2,\"sn\":" + sn.get() + "}"));

        final var input = session.receive().map(WebSocketMessage::getPayloadAsText).publishOn(Schedulers.boundedElastic()).doOnNext(message -> {
            LOGGER.debug(message);

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
                case 1 -> //握手成功
                        LOGGER.info("连接建立成功");
                case 3 -> {//收到pong，延迟1分钟检查服务器是否响应
                    lastPong = System.currentTimeMillis();
                    Mono.delay(Duration.ofMinutes(1)).subscribe(delay -> {
                        if (System.currentTimeMillis() - lastPong > 30000) {
                            LOGGER.error("服务器未响应");
                            defaultClient.connect().doOnSuccess(it -> LOGGER.info("服务器未响应，重新连接")).subscribe();
                        }
                    });
                }
                case 5 -> {//要求客户端断开当前连接重新连接
                    LOGGER.info("服务器要求客户端断开当前连接重新连接");
                    sn.set(0);
                    session.close().block();
                    defaultClient.connect().subscribe();
                }
                case 0 -> {//事件
                    final var data = jsonNode.get("d");
                    if (data.has("extra")) {
                        final var extra = data.get("extra");
                        final var type = extra.get("type").asText();

                        final List<Event> list = events.stream().filter(it -> it.type().equals(type)).toList();
                        if (list.isEmpty()) {
                            LOGGER.warn("未知事件:{}", type);
                        } else {
                            list.forEach(it -> {
                                try {
                                    final Object event = objectMapper.readValue(message, it.klass());
                                    publisher.publishEvent(event);
                                } catch (JsonProcessingException e) {
                                    LOGGER.error("事件处理失败", e);
                                }
                            });
                        }
                    } else {
                        LOGGER.error("事件获取extra失败:{}", jsonNode);
                    }

                }
            }
        }).then();
        return session.send(ping).and(input);
    }
}
