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

package cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.channel;

import cn.enaium.kook.spring.boot.starter.annotation.event.Listener;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.SystemMessageExtra;

import java.util.Map;

/**
 * 频道消息更新
 *
 * @author Enaium
 * @since 0.1.0
 */
@Listener
public class UpdateMessageChannel extends SystemMessageExtra<Map<Object, Object>> {

    public static final String TYPE = "updated_message";

    /**
     * 被更新的消息的 id
     */
    public String msg_id;
    /**
     * 更新后的文本
     */
    public String content;
    /**
     * 频道 id
     */
    public String channel_id;
    /**
     * 提及的用户 id 组成的列表
     */
    public Object[] mention;
    /**
     * 是否提及全体成员
     */
    public boolean mention_all;
    /**
     * 是否提及在线成员
     */
    public boolean mention_here;
    /**
     * 提及的角色 id 组成的列表
     */
    public Object[] mention_roles;
    /**
     * 更新时间戳(毫秒)
     */
    public int updated_at;
}
