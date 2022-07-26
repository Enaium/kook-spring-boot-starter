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
 * 服务器相关接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface GuildAPI {
    /**
     * 获取当前用户加入的服务器列表
     */
    API GUILD_LIST = new API(API.Method.GET, "guild/list");
    /**
     * 获取服务器详情
     */
    API GUILD_VIEW = new API(API.Method.GET, "guild/view");
    /**
     * 获取服务器中的用户列表
     */
    API GUILD_USER_LIST = new API(API.Method.GET, "guild/user-list");
    /**
     * 修改服务器中用户的昵称
     */
    API GUILD_NICKNAME = new API(API.Method.POST, "guild/nickname");
    /**
     * 离开服务器
     */
    API GUILD_LEAVE = new API(API.Method.POST, "guild/leave");
    /**
     * 踢出服务器
     */
    API GUILD_KICKOUT = new API(API.Method.POST, "guild/kickout");
    /**
     * 服务器静音闭麦列表
     */
    API GUILD_MUTE_LIST = new API(API.Method.GET, "guild-mute/list");
    /**
     * 添加服务器静音或闭麦
     */
    API GUILD_MUTE_CREATE = new API(API.Method.POST, "guild-mute/create");
    /**
     * 删除服务器静音或闭麦
     */
    API GUILD_MUTE_DELETE = new API(API.Method.POST, "guild-mute/delete");

}
