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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.invoker.HttpRequestValues;
import org.springframework.web.service.invoker.HttpServiceArgumentResolver;

import java.util.Map;

import static cn.enaium.kookstarter.KookStarter.LOGGER;

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

        if (((Object[]) argument).length == 0) {//长度为0说明无参数
            argument = Map.of();//无参数时用空map代替
        } else {
            argument = ((Object[]) argument)[0];//有参数时只取第一个参数值
        }


        if (Map.class.isAssignableFrom(argument.getClass())) {//如果是map,就将每个键值对添加到参数中
            for (Map.Entry<String, ?> entry : ((Map<String, ?>) argument).entrySet()) {
                requestValues.addRequestParameter(entry.getKey(), entry.getValue().toString());
            }
        } else {//如果是其他对象,就将对象的所有字段添加到参数中
            try {
                final var objectMapper = new ObjectMapper();
                final var string = objectMapper.writeValueAsString(argument);
                final var fields = objectMapper.readTree(string).fields();
                while (fields.hasNext()) {
                    final var next = fields.next();
                    requestValues.addRequestParameter(next.getKey(), next.getValue().textValue());
                }
            } catch (JsonProcessingException e) {
                LOGGER.error("参数处理错误");
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
