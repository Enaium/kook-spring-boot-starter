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
 * 邀请相关接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface InviteAPI {
    /**
     * 获取邀请列表
     */
    API INVITE_LIST = new API(API.Method.GET, "invite/list");
    /**
     * 创建邀请链接
     */
    API INVITE_CREATE = new API(API.Method.POST, "invite/create");
    /**
     * 删除邀请链接
     */
    API INVITE_DELETE = new API(API.Method.POST, "invite/delete");
}
