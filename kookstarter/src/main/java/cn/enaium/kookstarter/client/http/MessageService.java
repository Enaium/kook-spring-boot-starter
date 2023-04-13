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

package cn.enaium.kookstarter.client.http;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

/**
 * @author Enaium
 * @since 0.3.0
 */
public interface MessageService {
    /**
     * 获取频道聊天消息列表
     *
     * @since 0.3.0
     */
    @GetExchange("message/list")
    Mono<String> getMessageList(Object... params);


    /**
     * 获取频道聊天消息详情
     *
     * @since 0.3.0
     */
    @GetExchange("message/view")
    Mono<String> getMessageView(Object... params);


    /**
     * 发送频道聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("message/create")
    Mono<String> postMessageCreate(Object... params);


    /**
     * 更新频道聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("message/update")
    Mono<String> postMessageUpdate(Object... params);


    /**
     * 删除频道聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("message/delete")
    Mono<String> postMessageDelete(Object... params);


    /**
     * 获取频道消息某个回应的用户列表
     *
     * @since 0.3.0
     */
    @GetExchange("message/reaction-list")
    Mono<String> getMessageReactionList(Object... params);


    /**
     * 给某个消息添加回应
     *
     * @since 0.3.0
     */
    @PostExchange("message/add-reaction")
    Mono<String> postMessageAddReaction(Object... params);


    /**
     * 删除消息的某个回应
     *
     * @since 0.3.0
     */
    @PostExchange("message/delete-reaction")
    Mono<String> postMessageDeleteReaction(Object... params);
}
