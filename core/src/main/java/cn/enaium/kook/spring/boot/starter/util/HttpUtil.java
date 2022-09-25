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
import kong.unirest.HttpRequestWithBody;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

    /**
     * 创建请求
     *
     * @param api api
     * @return 请求体
     */
    public HttpRequestWithBody request(API api) {
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
        return Unirest.request(method.name(), PREFIX + path).header("Authorization", "Bot " + kookConfiguration.getToken());
    }

    /**
     * 发送请求
     *
     * @param api api
     * @return 返回的字符串
     */
    public String send(API api) {
        return request(api).header("Content-Type", "application/json").asString().getBody();
    }

    /**
     * 发送请求
     *
     * @param api   api
     * @param klass 返回类型
     * @param <T>   返回类型
     * @return 根据类型将返回值序列化
     */
    public <T> Result<T> send(API api, Class<T> klass) {
        try {
            return JsonUtil.mapper().readValue(send(api), TypeFactory.defaultInstance().constructParametricType(Result.class, klass));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
