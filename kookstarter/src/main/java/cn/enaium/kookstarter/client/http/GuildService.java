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
    Mono<String> getGuildList(Object... params);


    /**
     * 获取服务器详情
     *
     * @since 0.3.0
     */
    @GetExchange("guild/view")
    Mono<String> getGuildView(Object... params);


    /**
     * 获取服务器中的用户列表
     *
     * @since 0.3.0
     */
    @GetExchange("guild/user-list")
    Mono<String> getGuildUserList(Object... params);


    /**
     * 修改服务器中用户的昵称
     *
     * @since 0.3.0
     */
    @PostExchange("guild/nickname")
    Mono<String> postGuildNickname(Object... params);


    /**
     * 离开服务器
     *
     * @since 0.3.0
     */
    @PostExchange("guild/leave")
    Mono<String> postGuildLeave(Object... params);


    /**
     * 踢出服务器
     *
     * @since 0.3.0
     */
    @PostExchange("guild/kickout")
    Mono<String> postGuildKickout(Object... params);


    /**
     * 服务器静音闭麦列表
     *
     * @since 0.3.0
     */
    @GetExchange("guild-mute/list")
    Mono<String> getGuildMuteList(Object... params);


    /**
     * 添加服务器静音或闭麦
     *
     * @since 0.3.0
     */
    @PostExchange("guild-mute/create")
    Mono<String> postGuildMuteCreate(Object... params);


    /**
     * 删除服务器静音或闭麦
     *
     * @since 0.3.0
     */
    @PostExchange("guild-mute/delete")
    Mono<String> postGuildMuteDelete(Object... params);


    /**
     * 查询服务器的助力包历史
     *
     * @since 0.3.0
     */
    @GetExchange("guild-boost/history")
    Mono<String> getGuildBoostHistory(Object... params);
}
