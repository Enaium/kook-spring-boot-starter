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
 * 服务器角色权限相关接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface GuildRoleAPI {
    /**
     * 获取服务器角色列表
     */
    API GUILD_ROLE_LIST = new API(API.Method.GET, "guild-role/list");
    /**
     * 创建服务器角色
     */
    API GUILD_ROLE_CREATE = new API(API.Method.POST, "guild-role/create");
    /**
     * 更新服务器角色
     */
    API GUILD_ROLE_UPDATE = new API(API.Method.POST, "guild-role/update");
    /**
     * 删除服务器角色
     */
    API GUILD_ROLE_DELETE = new API(API.Method.POST, "guild-role/delete");
    /**
     * 赋予用户角色
     */
    API GUILD_ROLE_GRANT = new API(API.Method.POST, "guild-role/grant");
    /**
     * 删除用户角色
     */
    API GUILD_ROLE_REVOKE = new API(API.Method.POST, "guild-role/revoke");
}
