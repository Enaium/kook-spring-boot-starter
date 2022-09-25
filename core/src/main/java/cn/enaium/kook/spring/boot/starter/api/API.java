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

package cn.enaium.kook.spring.boot.starter.api;

import java.util.Map;

/**
 * @author Enaium
 */
public class API {
    private final Method method;
    private final String path;

    private Map<Object, Object> body;

    public API(Method method, String path) {
        this.method = method;
        this.path = path;
    }

    public Method getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Map<Object, Object> getBody() {
        return body;
    }

    public API setBody(Map<Object, Object> body) {
        this.body = body;
        return this;
    }

    public enum Method {
        GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE
    }
}
