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
 * 服务器表情相关接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface GuildEmojiAPI {
    /**
     * 获取服务器表情列表
     */
    API GUILD_EMOJI_LIST = new API(API.Method.GET, "guild-emoji/list");
    /**
     * 创建服务器表情
     */
    API GUILD_EMOJI_CREATE = new API(API.Method.POST, "guild-emoji/create");
    /**
     * 更新服务器表情
     */
    API GUILD_EMOJI_UPDATE = new API(API.Method.POST, "guild-emoji/update");
    /**
     * 删除服务器表情
     */
    API GUILD_EMOJI_DELETE = new API(API.Method.POST, "guild-emoji/delete");
}
