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
public interface GuildService {
    /**
     * 获取当前用户加入的服务器列表
     *
     * @since 0.3.0
     */
    @GetExchange("guild/list")
    Mono<Map<String, Object>> getGuildList(@RequestParam Map<String, Object> params);


    /**
     * 获取服务器详情
     *
     * @since 0.3.0
     */
    @GetExchange("guild/view")
    Mono<Map<String, Object>> getGuildView(@RequestParam Map<String, Object> params);


    /**
     * 获取服务器中的用户列表
     *
     * @since 0.3.0
     */
    @GetExchange("guild/user-list")
    Mono<Map<String, Object>> getGuildUserList(@RequestParam Map<String, Object> params);


    /**
     * 修改服务器中用户的昵称
     *
     * @since 0.3.0
     */
    @PostExchange("guild/nickname")
    Mono<Map<String, Object>> postGuildNickname(@RequestBody Map<String, Object> params);


    /**
     * 离开服务器
     *
     * @since 0.3.0
     */
    @PostExchange("guild/leave")
    Mono<Map<String, Object>> postGuildLeave(@RequestBody Map<String, Object> params);


    /**
     * 踢出服务器
     *
     * @since 0.3.0
     */
    @PostExchange("guild/kickout")
    Mono<Map<String, Object>> postGuildKickout(@RequestBody Map<String, Object> params);


    /**
     * 服务器静音闭麦列表
     *
     * @since 0.3.0
     */
    @GetExchange("guild-mute/list")
    Mono<Map<String, Object>> getGuildMuteList(@RequestParam Map<String, Object> params);


    /**
     * 添加服务器静音或闭麦
     *
     * @since 0.3.0
     */
    @PostExchange("guild-mute/create")
    Mono<Map<String, Object>> postGuildMuteCreate(@RequestBody Map<String, Object> params);


    /**
     * 删除服务器静音或闭麦
     *
     * @since 0.3.0
     */
    @PostExchange("guild-mute/delete")
    Mono<Map<String, Object>> postGuildMuteDelete(@RequestBody Map<String, Object> params);


    /**
     * 查询服务器的助力包历史
     *
     * @since 0.3.0
     */
    @GetExchange("guild-boost/history")
    Mono<Map<String, Object>> getGuildBoostHistory(@RequestParam Map<String, Object> params);
}
