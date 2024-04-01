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

package cn.enaium.kookstarter;

import cn.enaium.kookstarter.model.event.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 自定义事件
 *
 * @author Enaium
 */
@Component
public class CustomEvents {
    @Bean
    public Event kMarkdown() {
        return new Event(KMarkdown.class, "9");
    }

    public record KMarkdown(D d) {
        public record D(Extra extra) {
            public record Extra(Author author, KMarkdown kMarkdown) {
                public record Author(String nickname, Boolean bot) {
                }
            }
        }
    }
}
