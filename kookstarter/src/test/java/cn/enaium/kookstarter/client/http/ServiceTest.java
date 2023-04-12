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

package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.client.resolver.GetResolver;
import cn.enaium.kookstarter.client.resolver.PostResolver;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.Map;

/**
 * @author Enaium
 */
class ServiceTest {
    @Test
    public void test() {
        final var client = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder().baseUrl("http://localhost:8080").build()))
                .customArgumentResolver(new GetResolver())
                .customArgumentResolver(new PostResolver())
                .build();

        System.out.println(client.createClient(GatewayService.class).getGatewayIndex().block());
        System.out.println(client.createClient(MessageService.class).postMessageCreate(Map.of("name", "enaium")).block());
    }
}