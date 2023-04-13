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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import java.util.Map;
import java.util.Objects;

/**
 * @author Enaium
 */
class ServiceTest {

    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(WebClient.builder().baseUrl("http://localhost:8888").build()))
            .customArgumentResolver(new GetResolver())
            .customArgumentResolver(new PostResolver())
            .build();


    @BeforeAll
    public static void server() {
        HttpServer.create().host("localhost").port(8888).route(routes -> {
            routes
                    .get("/**", ((httpServerRequest, httpServerResponse) -> httpServerResponse.sendString(Mono.just(httpServerRequest.uri()).map(uri -> {
                        if (uri.contains("?")) {
                            return uri.split("\\?")[1];
                        } else {
                            return "";
                        }
                    }))))
                    .post("/**", (httpServerRequest, httpServerResponse) -> httpServerResponse.sendString(httpServerRequest.receive().asString()));
        }).bind().block();
    }

    @Test
    public void getNoParam() {
        Assertions.assertNull(factory.createClient(GatewayService.class).getGatewayIndex().block());
    }

    @Test
    public void getMapParam() {
        final var block = factory.createClient(GatewayService.class).getGatewayIndex(Map.of("key1", "value1", "key2", "value2")).block();
        Assertions.assertTrue(Objects.equals(block, "key1=value1&key2=value2") || Objects.equals(block, "key2=value2&key1=value1"));
    }

    @Test
    public void getOParam() {
        Assertions.assertEquals(
                factory.createClient(GatewayService.class).getGatewayIndex(new O("value1", "value2")).block(),
                "key1=value1&key2=value2"
        );
    }

    @Test
    public void postNoBody() {
        Assertions.assertNull(
                factory.createClient(MessageService.class).postMessageCreate().block()
        );
    }

    @Test
    public void postMapBody() {
        final var block = factory.createClient(MessageService.class).postMessageCreate(Map.of("key1", "value1", "key2", "value2")).block();
        Assertions.assertTrue(Objects.equals(block, "{\"key1\":\"value1\",\"key2\":\"value2\"}") || Objects.equals(block, "{\"key2\":\"value2\",\"key1\":\"value1\"}"));
    }

    @Test
    public void postOBody() {
        final var block = factory.createClient(MessageService.class).postMessageCreate(new O("value1", "value2")).block();
        Assertions.assertTrue(Objects.equals(block, "{\"key1\":\"value1\",\"key2\":\"value2\"}") || Objects.equals(block, "{\"key2\":\"value2\",\"key1\":\"value1\"}"));
    }

    private record O(String key1, String key2) {

    }
}