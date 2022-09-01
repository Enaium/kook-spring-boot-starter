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
 * 频道消息相关接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface MessageAPI {
    /**
     * 获取频道聊天消息列表
     */
    API MESSAGE_LIST = new API(API.Method.GET, "message/list");
    /**
     * 获取频道聊天消息详情
     */
    API MESSAGE_VIEW = new API(API.Method.GET, "message/view");
    /**
     * 发送频道聊天消息
     */
    API MESSAGE_CREATE = new API(API.Method.POST, "message/create");
    /**
     * 更新频道聊天消息
     */
    API MESSAGE_UPDATE = new API(API.Method.POST, "message/update");
    /**
     * 删除频道聊天消息
     */
    API MESSAGE_DELETE = new API(API.Method.POST, "message/delete");
    /**
     * 获取频道消息某回应的用户列表
     */
    API MESSAGE_REACTION_LIST = new API(API.Method.GET, "message/reaction-list");
    /**
     * 给某个消息添加回应
     */
    API MESSAGE_ADD_REACTION = new API(API.Method.POST, "message/add-reaction");
    /**
     * 删除消息的某个回应
     */
    API MESSAGE_DELETE_REACTION = new API(API.Method.POST, "message/delete-reaction");

}
