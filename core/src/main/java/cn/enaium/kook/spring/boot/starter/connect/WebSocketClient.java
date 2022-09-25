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

package cn.enaium.kook.spring.boot.starter.connect;

import cn.enaium.kook.spring.boot.starter.api.GatewayAPI;
import cn.enaium.kook.spring.boot.starter.configuration.KookConfiguration;
import cn.enaium.kook.spring.boot.starter.event.EventManager;
import cn.enaium.kook.spring.boot.starter.model.result.GatewayResult;
import cn.enaium.kook.spring.boot.starter.model.sign.Sign;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.ReconnectData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.SystemMessageExtra;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.TextMessageExtra;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import cn.enaium.kook.spring.boot.starter.util.JsonUtil;
import cn.enaium.kook.spring.boot.starter.util.TimeUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;

/**
 * WebSocket客户端
 *
 * @author Enaium
 * @since 0.1.0
 */
@Component
@Scope("prototype")
public class WebSocketClient {
    private final Logger logger = LogManager.getLogger(WebSocketClient.class);

    public WebSocketConnectionManager connectionManager;

    public final KookConfiguration kookConfiguration;

    public final HttpUtil httpUtil;

    public final EventManager eventManager;


    public WebSocketClient(KookConfiguration kookConfiguration, HttpUtil httpUtil, EventManager eventManager) {
        this.kookConfiguration = kookConfiguration;
        this.httpUtil = httpUtil;
        this.eventManager = eventManager;
    }

    public int sn = 0;

    public void start() {

        String url = httpUtil.send(GatewayAPI.GATEWAY_INDEX, GatewayResult.class).data.url;


        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
        connectionManager = new WebSocketConnectionManager(webSocketClient, new BinaryWebSocketHandler() {
            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                logger.info("连接已经建立");
                ping(session);
            }

            @Override
            public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
                String json = new String(decompress(message.getPayload().array()), StandardCharsets.UTF_8);
                Sign<?> sign = JsonUtil.readValue(json, Sign.class);
                if (sign.s == 0) {
                    Sign<EventData> eventDataSign = JsonUtil.readSign(json, EventData.class);
                    if (eventDataSign.d.type == 255) {
                        SystemMessageExtra<?> extra = JsonUtil.mapper().readValue(json, new TypeReference<Sign<EventData<SystemMessageExtra<?>>>>() {
                        }).d.extra;
                        String type = extra.type;
                        Class<?> event = eventManager.listener.get(type);
                        eventManager.publish(JsonUtil.readData(JsonUtil.writeValueAsString(sign.d), event), event);
                    } else {
                        TextMessageExtra extra = JsonUtil.mapper().readValue(json, new TypeReference<Sign<EventData<TextMessageExtra>>>() {
                        }).d.extra;
                        String type = String.valueOf(extra.type);
                        //TODO 此功能目前治标不治本, 但是可以解决问题
                        if ("0".equals(type)) {
                            type = String.valueOf(eventDataSign.d.type);
                        }
                        Class<?> event = eventManager.listener.get(type);
                        eventManager.publish(JsonUtil.readData(JsonUtil.writeValueAsString(sign.d), event), event);
                    }
                } else if (sign.s == 5) {//服务端通知客户端, 代表该连接已失效, 请重新连接。客户端收到后应该主动断开当前连接。
                    Sign<ReconnectData> reconnectDataSign = JsonUtil.readSign(json, ReconnectData.class);
                    logger.info("err:{}", reconnectDataSign.d.err);
                    switch (reconnectDataSign.d.code) {
                        case 40106:
                            logger.info("resume 失败, 缺少参数");
                            break;
                        case 40107:
                            logger.info("当前 session 已过期 (resume 失败, PING 的 sn 无效)");
                            break;
                        case 40108:
                            logger.info("无效的 sn , 或 sn 已经不存在 (resume 失败, PING 的 sn 无效)");
                            break;
                    }
                    connectionManager.stop();
                }
                sn = sign.sn;
            }

            final TimeUtil pong = new TimeUtil();

            @Override
            public void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {

                sn = JsonUtil.readValue(new String(message.getPayload().array(), StandardCharsets.UTF_8), Sign.class).sn;
                TimeUtil.time(TimeUnit.SECONDS, 30 + new Random().nextInt(-5, 5), () -> ping(session));
                TimeUtil.time(TimeUnit.SECONDS, 1, () -> {
                    if (pong.delay(10000L)) {
                        logger.error("10秒内没收到Pong,连接超时");
                    }
                });
            }

            public void ping(WebSocketSession session) {
                try {
                    session.sendMessage(new PingMessage(ByteBuffer.wrap(JsonUtil.writeValueAsString(new HashMap<String, Integer>() {{
                        put("s", 2);
                        put("sn", sn);
                    }}).getBytes(StandardCharsets.UTF_8))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pong.reset();
            }

            @Override
            public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
                logger.info("连接已经关闭");
            }

            @Override
            public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
                logger.error(exception);
            }
        }, url);
        connectionManager.start();
    }

    private byte[] decompress(byte[] data) {
        byte[] output;

        Inflater decompresses = new Inflater();
        decompresses.reset();
        decompresses.setInput(data);

        ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!decompresses.finished()) {
                int i = decompresses.inflate(buf);
                o.write(buf, 0, i);
            }
            output = o.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        decompresses.end();
        return output;
    }
}
