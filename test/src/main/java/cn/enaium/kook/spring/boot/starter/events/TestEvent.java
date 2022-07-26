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

package cn.enaium.kook.spring.boot.starter.events;

import cn.enaium.kook.spring.boot.starter.annotation.event.Event;
import cn.enaium.kook.spring.boot.starter.annotation.event.Register;
import cn.enaium.kook.spring.boot.starter.api.DirectMessageAPI;
import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.api.UserChatAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.KMarkdownMessage;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 一个例子,不管对方说什么只会说Hello
 *
 * @author Enaium
 */
@Register
public class TestEvent {

    private final Logger logger = LogManager.getLogger(TestEvent.class);

    @Autowired
    public HttpUtil httpUtil;

    @Event(KMarkdownMessage.class)
    public void event(EventData<KMarkdownMessage> kMarkdownMessageEventData) {
        //判断是不是机器人,如果不判断机器人发出的消息话,也会进入这个事件,从而导致死循环
        if (kMarkdownMessageEventData.extra.author.bot) {
            return;
        }

        Map<Object, Object> kmarkdown = kMarkdownMessageEventData.extra.kmarkdown;
        Object raw_content = kmarkdown.get("raw_content");
        logger.info("对方说了:{}", raw_content);
        if (kMarkdownMessageEventData.channel_type.equals("PERSON")) {
            logger.info("说了Hello 返回:{}", httpUtil.send(DirectMessageAPI.DIRECT_MESSAGE_CREATE.setBody(
                    Map.of(
                            "type", 9,
                            "target_id", kMarkdownMessageEventData.author_id,
                            "content", "Hello"
                    )
            )));
        } else if (kMarkdownMessageEventData.channel_type.equals("GROUP")) {
            logger.info("说了Hello 返回:{}", httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                    Map.of(
                            "type", 9,
                            "target_id", kMarkdownMessageEventData.target_id,
                            "content", "Hello"
                    )
            )));
        }
    }
}
