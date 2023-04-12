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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

import java.util.Map;

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
    Mono<Map<String, Object>> getMessageList(@RequestParam Map<String, Object> params);


    /**
     * 获取频道聊天消息详情
     *
     * @since 0.3.0
     */
    @GetExchange("message/view")
    Mono<Map<String, Object>> getMessageView(@RequestParam Map<String, Object> params);


    /**
     * 发送频道聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("message/create")
    Mono<Map<String, Object>> postMessageCreate(@RequestBody Map<String, Object> params);


    /**
     * 更新频道聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("message/update")
    Mono<Map<String, Object>> postMessageUpdate(@RequestBody Map<String, Object> params);


    /**
     * 删除频道聊天消息
     *
     * @since 0.3.0
     */
    @PostExchange("message/delete")
    Mono<Map<String, Object>> postMessageDelete(@RequestBody Map<String, Object> params);


    /**
     * 获取频道消息某个回应的用户列表
     *
     * @since 0.3.0
     */
    @GetExchange("message/reaction-list")
    Mono<Map<String, Object>> getMessageReactionList(@RequestParam Map<String, Object> params);


    /**
     * 给某个消息添加回应
     *
     * @since 0.3.0
     */
    @PostExchange("message/add-reaction")
    Mono<Map<String, Object>> postMessageAddReaction(@RequestBody Map<String, Object> params);


    /**
     * 删除消息的某个回应
     *
     * @since 0.3.0
     */
    @PostExchange("message/delete-reaction")
    Mono<Map<String, Object>> postMessageDeleteReaction(@RequestBody Map<String, Object> params);
}
