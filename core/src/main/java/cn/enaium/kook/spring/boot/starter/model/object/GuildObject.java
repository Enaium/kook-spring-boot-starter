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

package cn.enaium.kook.spring.boot.starter.model.object;

/**
 * 服务器
 *
 * @author Enaium
 * @since 0.1.0
 */
public class GuildObject {
    /**
     * 服务器id
     */
    public String id;
    /**
     * 服务器名称
     */
    public String name;
    /**
     * 服务器主题
     */
    public String topic;
    /**
     * 服务器主的id
     */
    public String master_id;
    /**
     * 服务器icon的地址
     */
    public String icon;
    /**
     * 通知类型,`0`代表默认使用服务器通知设置，`1`代表接收所有通知,`2`代表仅@被提及，`3`代表不接收通知
     */
    public int notify_type;
    /**
     * 服务器默认使用语音区域
     */
    public String region;
    /**
     * 是否为公开服务器
     */
    public boolean enable_open;
    /**
     * 公开服务器id
     */
    public String open_id;
    /**
     * 默认频道id
     */
    public String default_channel_id;
    /**
     * 欢迎频道id
     */
    public String welcome_channel_id;
    /**
     * 角色列表
     */
    public Object[] roles;
    /**
     * 频道列表
     */
    public Object[] channels;
}
