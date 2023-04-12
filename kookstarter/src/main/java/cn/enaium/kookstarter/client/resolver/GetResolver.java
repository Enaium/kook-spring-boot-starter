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

package cn.enaium.kookstarter.client.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.invoker.HttpRequestValues;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

import java.util.Map;

/**
 * @author Enaium
 * @since 0.3.0
 */
public class GetResolver implements HttpServiceArgumentResolver {
    @Override
    public boolean resolve(Object argument, MethodParameter parameter, HttpRequestValues.Builder requestValues) {
        final var getExchange = parameter.getMethodAnnotation(GetExchange.class);
        if (getExchange == null) {
            return false;
        }

        if (!argument.getClass().isArray()) {
            return false;
        }

        if (((Object[]) argument).length == 0) {
            argument = Map.of();
        } else {
            argument = ((Object[]) argument)[0];
        }


        for (Map.Entry<String, ?> entry : ((Map<String, ?>) argument).entrySet()) {
            requestValues.addRequestParameter(entry.getKey(), entry.getValue().toString());
        }

        return true;
    }
}
