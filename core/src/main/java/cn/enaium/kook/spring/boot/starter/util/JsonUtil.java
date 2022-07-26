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

import cn.enaium.kook.spring.boot.starter.model.sign.Sign;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * @author Enaium
 */
public class JsonUtil {

    public static <T> T readValue(String string, Class<T> klass) {
        try {
            return mapper().readValue(string, klass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Sign<T> readSign(String string, Class<T> klass) {
        try {
            return mapper().readValue(string, TypeFactory.defaultInstance().constructParametricType(Sign.class, klass));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> EventData<T> readData(String string, Class<T> klass) {
        try {
            return mapper().readValue(string, TypeFactory.defaultInstance().constructParametricType(EventData.class, klass));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static String writeValueAsString(Object o) {
        try {
            return mapper().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public static ObjectMapper mapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
