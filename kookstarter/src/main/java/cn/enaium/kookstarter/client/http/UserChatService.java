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
public interface UserChatService {
    /**
     * 获取私信聊天会话列表
     *
     * @since 0.3.0
     */
    @GetExchange("user-chat/list")
    Mono<String> getUserChatList(Object... params);


    /**
     * 获取私信聊天会话详情
     *
     * @since 0.3.0
     */
    @GetExchange("user-chat/view")
    Mono<String> getUserChatView(Object... params);


    /**
     * 创建私信聊天会话
     *
     * @since 0.3.0
     */
    @PostExchange("user-chat/create")
    Mono<String> postUserChatCreate(Object... params);


    /**
     * 删除私信聊天会话
     *
     * @since 0.3.0
     */
    @PostExchange("user-chat/delete")
    Mono<String> postUserChatDelete(Object... params);
}
