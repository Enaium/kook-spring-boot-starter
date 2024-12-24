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

import cn.enaium.kookstarter.client.http.GatewayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.URI;

/**
 * @author Enaium
 */
@Component
public class DefaultClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultClient.class);

    private final GatewayService gatewayService;
    private final DefaultHandler defaultHandler;

    public DefaultClient(GatewayService gatewayService, @Lazy DefaultHandler defaultHandler) {
        this.gatewayService = gatewayService;
        this.defaultHandler = defaultHandler;
    }

    public Mono<Void> connect() {
        return Mono.fromCallable(() -> gatewayService.gatewayIndex(0))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(gatewayIndexResponse -> {
                    if (gatewayIndexResponse.code() == 0) {
                        LOGGER.info("获取网关地址成功: {}", gatewayIndexResponse.data().url());
                        return new ReactorNettyWebSocketClient().execute(URI.create(gatewayIndexResponse.data().url()), defaultHandler);
                    } else {
                        LOGGER.error("获取网关地址失败: {}", gatewayIndexResponse.message());
                        return connect();
                    }
                });
    }
}
