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

package cn.enaium.kookstarter.sample;

import cn.enaium.kookstarter.client.http.DirectMessageService;
import cn.enaium.kookstarter.client.http.MessageService;
import cn.enaium.kookstarter.event.KMarkdownEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Mono;

import java.util.Map;

import static cn.enaium.kookstarter.KookStarter.LOGGER;

/**
 * @author Enaium
 * @since 0.3.0
 */
@SpringBootApplication
public class SampleApplication {

    private final MessageService messageService;
    private final DirectMessageService directMessageService;

    public SampleApplication(MessageService messageService, DirectMessageService directMessageService) {
        this.messageService = messageService;
        this.directMessageService = directMessageService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }


    @EventListener
    public void event(KMarkdownEvent event) throws JsonProcessingException {
        final var jsonNode = new ObjectMapper().readValue(event.getMetadata().toString(), JsonNode.class);
        final var data = jsonNode.get("d");
        final var type = data.get("channel_type").textValue();
        final var content = data.get("extra").get("kmarkdown").get("raw_content").textValue();
        final var bot = data.get("extra").get("author").get("bot").booleanValue();

        if (bot) {//对方是否为机器人
            return;
        }

        LOGGER.info("对方说了{}", content);
        if (type.equals("PERSON")) {
            messageService.postMessageCreate(
                    Map.of(
                            "type", 9,
                            "target_id", data.get("author_id"),
                            "content", "**Hello**"
                    )
            ).doOnSuccess(result -> {
                LOGGER.info("请求成功:{}", result);
            }).doOnError(throwable -> {
                LOGGER.error("请求错误");
                throwable.printStackTrace();
            }).subscribe();


        } else if (type.equals("GROUP")) {
            messageService.postMessageCreate(
                    Map.of(
                            "type", 9,
                            "target_id", data.get("target_id"),
                            "content", "**Hello**"
                    )
            ).doOnSuccess(result -> {
                LOGGER.info("请求成功:{}", result);
            }).doOnError(throwable -> {
                LOGGER.error("请求错误");
                throwable.printStackTrace();
            }).block();
        }
    }
}
