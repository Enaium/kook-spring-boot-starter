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
 * 频道用户相关接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface ChannelUserAPI {
    /**
     * 根据用户id和服务器id获取用户所在语音频道
     */
    API CHANNEL_USER_GET_JOINED_CHANNEL = new API(API.Method.GET, "channel-user/get-joined-channel");
}
