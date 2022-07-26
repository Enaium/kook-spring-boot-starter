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

package cn.enaium.kook.spring.boot.starter.api;

/**
 * 私信聊天会话接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface UserChatAPI {
    /**
     * 获取私信聊天会话列表
     */
    API USER_CHAT_LIST = new API(API.Method.GET, "user-chat/list");
    /**
     * 获取私信聊天会话详情
     */
    API USER_CHAT_VIEW = new API(API.Method.GET, "user-chat/view");
    /**
     * 创建私信聊天会话
     */
    API USER_CHAT_CREATE = new API(API.Method.POST, "user-chat/create");
    /**
     * 删除私信聊天会话
     */
    API USER_CHAT_DELETE = new API(API.Method.POST, "user-chat/delete");
}
