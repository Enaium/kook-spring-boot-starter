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

package cn.enaium.kook.spring.boot.starter.util;

import cn.enaium.kook.spring.boot.starter.api.API;
import cn.enaium.kook.spring.boot.starter.configuration.KookConfiguration;
import cn.enaium.kook.spring.boot.starter.model.result.Result;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

/**
 * @author Enaium
 * @since 0.1.0
 */
@Component
public class HttpUtil {
    public static final String PREFIX = "https://www.kookapp.cn/api/v3/";

    private final KookConfiguration kookConfiguration;

    public HttpUtil(KookConfiguration kookConfiguration) {
        this.kookConfiguration = kookConfiguration;
    }

    public String send(API api) {
        API.Method method = api.getMethod();
        String path = api.getPath();
        Map<Object, Object> body = api.getBody();

        if (method.equals(API.Method.GET)) {
            //当Method为Get时,需要将参数拼接在url上
            if (null != body && !body.isEmpty()) {
                path += "?";
                StringBuilder sb = new StringBuilder();
                body.forEach((k, v) -> {
                    sb.append("&").append(k.toString()).append("=").append(v.toString());
                });
                path += sb.substring(1);
            }
        }

        HttpRequest.Builder builder = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_1_1).uri(URI.create(PREFIX + path)).timeout(Duration.ofMillis(5000));

        if (body != null) {
            builder.header("Content-Type", "application/json");
        }

        builder.header("Authorization", "Bot " + kookConfiguration.getToken());

        try {
            HttpRequest request = builder.method(method.name(), body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(JsonUtil.mapper().writeValueAsString(body))).build();
            return HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> Result<T> send(API api, Class<T> klass) {
        try {
            return JsonUtil.mapper().readValue(send(api), TypeFactory.defaultInstance().constructParametricType(Result.class, klass));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
