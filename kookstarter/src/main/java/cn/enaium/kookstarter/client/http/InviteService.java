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
public interface InviteService {
    /**
     * 获取邀请列表
     *
     * @since 0.3.0
     */
    @GetExchange("invite/list")
    Mono<String> getInviteList(Object... params);


    /**
     * 创建邀请链接
     *
     * @since 0.3.0
     */
    @PostExchange("invite/create")
    Mono<String> postInviteCreate(Object... params);


    /**
     * 删除邀请链接
     *
     * @since 0.3.0
     */
    @PostExchange("invite/delete")
    Mono<String> postInviteDelete(Object... params);
}
