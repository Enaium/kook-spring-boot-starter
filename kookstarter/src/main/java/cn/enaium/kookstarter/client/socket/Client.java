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

import cn.enaium.kookstarter.client.http.GatewayService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import reactor.core.scheduler.Schedulers;

import java.net.URI;
import java.util.Map;

import static cn.enaium.kookstarter.KookStarter.LOGGER;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author Enaium
 * @since 0.1.0
 */
@Component
@Scope(SCOPE_PROTOTYPE)
public class Client {

    private final DefaultHandler defaultHandler;

    private final GatewayService gatewayService;

    public Client(DefaultHandler defaultHandler, GatewayService gatewayService) {
        this.defaultHandler = defaultHandler;
        this.gatewayService = gatewayService;
    }

    public void start() {
        gatewayService.getGatewayIndex(Map.of("compress", 0))//不进行zlib压缩
                .publishOn(Schedulers.boundedElastic())
                .doOnSuccess(gateway -> {
                    JsonNode result;
                    try {
                        result = new ObjectMapper().readValue(gateway, ObjectNode.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }

                    final var client = new ReactorNettyWebSocketClient();
                    client.execute(URI.create(result.get("data").get("url").asText()), defaultHandler).doOnError(throwable -> {
                        LOGGER.info("连接出现异常");
                        throwable.printStackTrace();
                    }).subscribe();
                })
                .doOnError(throwable -> {
                    LOGGER.error("获取网关连接地址失败");
                    throwable.printStackTrace();
                }).subscribe();
    }
}
