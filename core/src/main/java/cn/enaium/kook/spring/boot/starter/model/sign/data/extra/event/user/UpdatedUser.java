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

package cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.user;

import cn.enaium.kook.spring.boot.starter.annotation.event.Listener;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.SystemMessageExtra;

import java.util.Map;

/**
 * 用户信息更新
 * <p>
 * 该事件与服务器无关, 遵循以下条件
 * <p>
 * 1.仅当用户的 用户名 或 头像 变更时;
 *
 * 2仅通知与该用户存在关联的用户或 Bot: a. 存在聊天会话 b. 双方好友关系
 *
 * @author Enaium
 * @since 0.1.0
 */
@Listener
public class UpdatedUser extends SystemMessageExtra<Map<Object, Object>> {
    public static final String TYPE = "user_updated";
    /**
     * 用户 id
     */
    public String user_id;
    /**
     * 用户名
     */
    public String username;
    /**
     * 头像图片地址
     */
    public String avatar;
}
