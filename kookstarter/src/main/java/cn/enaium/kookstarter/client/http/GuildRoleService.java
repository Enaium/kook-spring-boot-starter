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
public interface GuildRoleService {
    /**
     * 获取服务器角色列表
     *
     * @since 0.3.0
     */
    @GetExchange("guild-role/list")
    Mono<Map<String, Object>> getGuildRoleList(Object... params);


    /**
     * 创建服务器角色
     *
     * @since 0.3.0
     */
    @PostExchange("guild-role/create")
    Mono<Map<String, Object>> postGuildRoleCreate(Object... params);


    /**
     * 更新服务器角色
     *
     * @since 0.3.0
     */
    @PostExchange("guild-role/update")
    Mono<Map<String, Object>> postGuildRoleUpdate(Object... params);


    /**
     * 删除服务器角色
     *
     * @since 0.3.0
     */
    @PostExchange("guild-role/delete")
    Mono<Map<String, Object>> postGuildRoleDelete(Object... params);


    /**
     * 赋予用户角色
     *
     * @since 0.3.0
     */
    @PostExchange("guild-role/grant")
    Mono<Map<String, Object>> postGuildRoleGrant(Object... params);


    /**
     * 删除用户角色
     *
     * @since 0.3.0
     */
    @PostExchange("guild-role/revoke")
    Mono<Map<String, Object>> postGuildRoleRevoke(Object... params);
}
