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
 * 用户私聊消息接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface DirectMessageAPI {
    /**
     * 获取私信聊天消息列表
     */
    API DIRECT_MESSAGE_LIST = new API(API.Method.GET,"direct-message/list");
    /**
     * 发送私信聊天消息
     */
    API DIRECT_MESSAGE_CREATE = new API(API.Method.POST,"direct-message/create");
    /**
     * 更新私信聊天消息
     */
    API DIRECT_MESSAGE_UPDATE = new API(API.Method.POST,"direct-message/update");
    /**
     * 删除私信聊天消息
     */
    API DIRECT_MESSAGE_DELETE = new API(API.Method.POST,"direct-message/delete");
    /**
     * 获取频道消息某回应的用户列表
     */
    API DIRECT_MESSAGE_REACTION_LIST = new API(API.Method.GET,"direct-message/reaction-list");
    /**
     * 给某个消息添加回应
     */
    API DIRECT_MESSAGE_ADD_REACTION = new API(API.Method.POST,"direct-message/add-reaction");
    /**
     * 删除消息的某个回应
     */
    API DIRECT_MESSAGE_DELETE_REACTION = new API(API.Method.POST,"direct-message/delete-reaction");
}
