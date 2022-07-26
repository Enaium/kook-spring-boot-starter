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

package cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.server;

import cn.enaium.kook.spring.boot.starter.annotation.event.Listener;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.SystemMessageExtra;

import java.util.Map;

/**
 * 服务器信息更新
 *
 * @author Enaium
 * @since 0.1.0
 */
@Listener
public class UpdatedGuildServer extends SystemMessageExtra<Map<Object, Object>> {

    public static final String TYPE = "updated_guild";

    /**
     * 服务器 id
     */
    public String id;

    /**
     * 服务器名称
     */
    public String name;

    /**
     * 服务器主 id
     */
    public String user_id;

    /**
     * 服务器 logo 图片地址
     */
    public String icon;
    /**
     * 通知类型 1接受所有通知 2仅接收被提及消息 3不接收通知
     */
    public int notify_type;
    /**
     * 服务器所在区域
     */
    public String region;
    /**
     * 是否为公开服务器, 1 or 0
     */
    public int enable_open;
    /**
     * 公开服务器 id
     */
    public int open_id;
    /**
     * 默认文字频道 id
     */
    public String default_channel_id;
    /**
     * 欢迎频道 id
     */
    public String welcome_channel_id;
}
