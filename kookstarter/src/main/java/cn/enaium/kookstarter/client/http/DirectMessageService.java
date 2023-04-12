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

import java.util.Map;

/**
 * @author Enaium
 * @since 0.3.0
 */
public interface DirectMessageService {
    /**
     * 获取私信聊天消息列表
     *
     * @since 0.3.0
     */
    @GetExchange("direct-message/list")
    Mono<String> getDirectMessageList(Object... params);


    /**
     * 发送私信聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("direct-message/create")
    Mono<String> postDirectMessageCreate(Object... params);


    /**
     * 更新私信聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("direct-message/update")
    Mono<String> postDirectMessageUpdate(Object... params);


    /**
     * 删除私信聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("direct-message/delete")
    Mono<String> postDirectMessageDelete(Object... params);


    /**
     * 获取频道消息某个回应的用户列表
     *
     * @since 0.3.0
     */
    @GetExchange("direct-message/reaction-list")
    Mono<String> getDirectMessageReactionList(Object... params);


    /**
     * 给某个消息添加回应
     *
     * @since 0.3.0
     */
    @PostExchange("direct-message/add-reaction")
    Mono<String> postDirectMessageAddReaction(Object... params);


    /**
     * 删除消息的某个回应
     *
     * @since 0.3.0
     */
    @PostExchange("direct-message/delete-reaction")
    Mono<String> postDirectMessageDeleteReaction(Object... params);
}
