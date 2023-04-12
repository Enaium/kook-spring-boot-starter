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
import reactor.core.publisher.Mono;

/**
 * @author Enaium
 * @since 0.3.0
 */
public interface BadgeService {
    /**
     * 获取服务器Badge
     *
     * @since 0.3.0
     */
    @GetExchange("badge/guild")
    Mono<String> getBadgeGuild(Object... params);
}
