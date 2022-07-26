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
 * 频道相关接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface ChannelAPI {
    /**
     * 获取频道列表
     */
    API CHANNEL_LIST = new API(API.Method.GET, "channel/list");
    /**
     * 获取频道详情
     */
    API CHANNEL_VIEW = new API(API.Method.GET, "channel/view");
    /**
     * 创建频道
     */
    API CHANNEL_CREATE = new API(API.Method.POST, "channel/create");
    /**
     * 编辑频道
     */
    API CHANNEL_UPDATE = new API(API.Method.POST, "channel/update");
    /**
     * 删除频道
     */
    API CHANNEL_DELETE = new API(API.Method.POST, "channel/delete");
    /**
     * 语音频道之间移动用户
     */
    API CHANNEL_MOVE_USER = new API(API.Method.POST, "channel/move-user");
    /**
     * 获取频道角色权限详情
     */
    API CHANNEL_ROLE_INDEX = new API(API.Method.GET, "channel-role/index");
    /**
     * 创建频道角色权限
     */
    API CHANNEL_ROLE_CREATE = new API(API.Method.POST, "channel-role/create");
    /**
     * 更新频道角色权限
     */
    API CHANNEL_ROLE_UPDATE = new API(API.Method.POST, "channel-role/update");
    /**
     * 删除频道角色权限
     */
    API CHANNEL_ROLE_DELETE = new API(API.Method.POST, "channel-role/delete");
}
