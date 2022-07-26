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
 * 频道
 *
 * @author Enaium
 * @since 0.1.0
 */
public class ChannelObject {
    /**
     * 频道id
     */
    public String id;
    /**
     * 频道名称
     */
    public String name;
    /**
     * 创建者id
     */
    public String user_id;
    /**
     * 服务器id
     */
    public String guild_id;
    /**
     * 频道简介
     */
    public String topic;
    /**
     * 是否为分组，事件中为int格式
     */
    public boolean is_category;
    /**
     * 上级分组的id
     */
    public String parent_id;
    /**
     * 排序level
     */
    public int level;
    /**
     * 慢速模式下限制发言的最短时间间隔,单位为秒(s)
     */
    public int slow_mode;
    /**
     * 频道类型:`1`文字频道,`2`语音频道
     */
    public int type;
    /**
     * 针对角色在该频道的权限覆写规则组成的列表
     */
    public Object[] permission_overwrites;
    /**
     * 针对用户在该频道的权限覆写规则组成的列表
     */
    public Object[] permission_users;
    /**
     * 权限设置是否与分组同步,`1`or`0`
     */
    public int permission_sync;
    /**
     * 是否有密码
     */
    public boolean has_password;
}
