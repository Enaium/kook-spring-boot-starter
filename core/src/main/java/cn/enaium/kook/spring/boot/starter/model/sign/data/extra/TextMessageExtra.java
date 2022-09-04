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

package cn.enaium.kook.spring.boot.starter.model.sign.data.extra;

import cn.enaium.kook.spring.boot.starter.model.object.UserObject;

/**
 * @author Enaium
 * @since 0.1.0
 */
public class TextMessageExtra {
    /**
     * 1:文字消息, 2:图片消息，3:视频消息，4:文件消息， 8:音频消息，9:KMarkdown，10:card 消息，12:动作消息 255:系统消息, 其它的暂未开放
     */
    public int type;

    public String code;

    /**
     * 服务器 id
     */
    public String guild_id;

    /**
     * 频道名
     */
    public String channel_name;

    /**
     * 提及到的用户 id 的列表
     */
    public Object[] mention;

    /**
     * 是否 mention 所有用户
     */
    public boolean mention_all;

    /**
     * mention 用户角色的数组
     */
    public Object[] mention_roles;

    /**
     * 是否 mention 在线用户
     */
    public boolean mention_here;

    /**
     * 用户信息
     */
    public UserObject author;
}
