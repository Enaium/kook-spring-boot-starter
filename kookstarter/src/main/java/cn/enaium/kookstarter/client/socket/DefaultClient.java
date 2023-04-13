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
import cn.enaium.kookstarter.configuration.KookConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import reactor.core.scheduler.Schedulers;

import java.net.URI;
import java.util.Map;

import static cn.enaium.kookstarter.KookStarter.LOGGER;

/**
 * @author Enaium
 * @since 0.1.0
 */
@Component
public class DefaultClient {

    private final GatewayService gatewayService;
    private final KookConfiguration configuration;
    private final ApplicationEventPublisher publisher;

    public DefaultClient(GatewayService gatewayService, KookConfiguration configuration, ApplicationEventPublisher publisher) {
        this.gatewayService = gatewayService;
        this.configuration = configuration;
        this.publisher = publisher;
    }

    public void connect() {
        gatewayService.getGatewayIndex(Map.of("compress", 0))//不进行zlib压缩
                .publishOn(Schedulers.boundedElastic())
                .doOnSuccess(gateway -> {
                    JsonNode result;
                    try {
                        result = new ObjectMapper().readValue(gateway, ObjectNode.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }

                    new ReactorNettyWebSocketClient()
                            .execute(URI.create(result.get("data").get("url").asText()), new DefaultHandler(configuration, publisher, this))
                            .doOnError(throwable -> {
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
