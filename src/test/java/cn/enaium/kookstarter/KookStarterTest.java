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

import cn.enaium.kookstarter.client.http.DirectMessageService;
import cn.enaium.kookstarter.model.event.MessageEvent;
import cn.enaium.kookstarter.model.request.DirectMessageCreateBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

/**
 * @author Enaium
 */
@SpringBootApplication
public class KookStarterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(KookStarterTest.class);


    public static void main(String[] args) {
        SpringApplication.run(KookStarterTest.class, args);
    }

    public KookStarterTest(DirectMessageService directMessageService) {
        this.directMessageService = directMessageService;
    }

    private final DirectMessageService directMessageService;

    @EventListener
    public void message(MessageEvent.Message9 message9) {
        LOGGER.info("{} 说了: {}", message9.d().extra().author().nickname(), message9.d().extra().kmarkdown().rawContent());

        directMessageService.directMessageCreate(new DirectMessageCreateBody(null, message9.d().extra().author().id(), null, "你好", null, null));
    }

    @EventListener
    public void message(CustomEvents.KMarkdown kMarkdown) {
        LOGGER.info("{} 是否为机器人 {}", kMarkdown.d().extra().author().nickname(), kMarkdown.d().extra().author().bot());
    }
}
