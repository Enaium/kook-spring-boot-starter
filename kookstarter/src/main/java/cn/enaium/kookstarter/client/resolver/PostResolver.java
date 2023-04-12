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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ReactiveAdapter;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.util.Assert;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.invoker.HttpRequestValues;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

import java.util.Map;

/**
 * @author Enaium
 * @since 0.3.0
 */
public class PostResolver implements HttpServiceArgumentResolver {
    @Override
    public boolean resolve(Object argument, MethodParameter parameter, HttpRequestValues.Builder requestValues) {
        final var postExchange = parameter.getMethodAnnotation(PostExchange.class);

        if (postExchange == null) {
            return false;
        }

        if (((Object[]) argument).length == 0) {
            argument = null;
        } else {
            argument = ((Object[]) argument)[0];
        }

        ReactiveAdapter reactiveAdapter = ReactiveAdapterRegistry.getSharedInstance().getAdapter(Map.class);
        if (reactiveAdapter == null) {
            requestValues.setBodyValue(argument);
        } else {
            MethodParameter nestedParameter = parameter.nested();

            String message = "Async type for @RequestBody should produce value(s)";
            Assert.isTrue(!reactiveAdapter.isNoValue(), message);
            Assert.isTrue(nestedParameter.getNestedParameterType() != Void.class, message);

            requestValues.setBody(
                    reactiveAdapter.toPublisher(argument),
                    ParameterizedTypeReference.forType(nestedParameter.getNestedGenericParameterType()));
        }

        return true;
    }
}
