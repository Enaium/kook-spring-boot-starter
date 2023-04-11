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
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author Enaium
 * @since 0.3.0
 */
public interface ChannelService {
    /**
     * 获取频道列表
     *
     * @since 0.3.0
     */
    @GetExchange("channel/list")
    Mono<Map<String, Object>> getChannelList(@RequestParam Map<String, Object> params);


    /**
     * 获取频道详情
     *
     * @since 0.3.0
     */
    @GetExchange("channel/view")
    Mono<Map<String, Object>> getChannelView(@RequestParam Map<String, Object> params);


    /**
     * 创建频道
     *
     * @since 0.3.0
     */
    @GetExchange("channel/create")
    Mono<Map<String, Object>> postChannelCreate(@RequestBody Map<String, Object> params);


    /**
     * 编辑频道
     *
     * @since 0.3.0
     */
    @GetExchange("channel/update")
    Mono<Map<String, Object>> postChannelUpdate(@RequestBody Map<String, Object> params);


    /**
     * 删除频道
     *
     * @since 0.3.0
     */
    @GetExchange("channel/delete")
    Mono<Map<String, Object>> postChannelDelete(@RequestBody Map<String, Object> params);


    /**
     * 语音频道用户列表
     *
     * @since 0.3.0
     */
    @GetExchange("channel/user-list")
    Mono<Map<String, Object>> getChannelUserList(@RequestParam Map<String, Object> params);


    /**
     * 语音频道之间移动用户
     *
     * @since 0.3.0
     */
    @GetExchange("channel/move-user")
    Mono<Map<String, Object>> postChannelMoveUser(@RequestBody Map<String, Object> params);


    /**
     * 获取频道角色权限详情
     *
     * @since 0.3.0
     */
    @GetExchange("channel-role/index")
    Mono<Map<String, Object>> getChannelRoleIndex(@RequestParam Map<String, Object> params);


    /**
     * 创建频道角色权限
     *
     * @since 0.3.0
     */
    @GetExchange("channel-role/create")
    Mono<Map<String, Object>> postChannelRoleCreate(@RequestBody Map<String, Object> params);


    /**
     * 更新频道角色权限
     *
     * @since 0.3.0
     */
    @GetExchange("channel-role/update")
    Mono<Map<String, Object>> postChannelRoleUpdate(@RequestBody Map<String, Object> params);


    /**
     * 同步频道角色权限
     *
     * @since 0.3.0
     */
    @GetExchange("channel-role/sync")
    Mono<Map<String, Object>> postChannelRoleSync(@RequestBody Map<String, Object> params);


    /**
     * 删除频道角色权限
     *
     * @since 0.3.0
     */
    @GetExchange("channel-role/delete")
    Mono<Map<String, Object>> postChannelRoleDelete(@RequestBody Map<String, Object> params);
}
