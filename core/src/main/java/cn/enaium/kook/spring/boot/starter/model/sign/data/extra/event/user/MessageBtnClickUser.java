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
import cn.enaium.kook.spring.boot.starter.model.object.UserObject;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.SystemMessageExtra;

import java.util.Map;

/**
 * @author Enaium
 */
@Listener
public class MessageBtnClickUser extends SystemMessageExtra<Map<Object, Object>> {
    public static final String TYPE = "message_btn_click";
    /**
     * 用户点击的消息 id
     */
    public String msg_id;
    /**
     * 点击的用户
     */
    public String user_id;
    /**
     * return-val 的值
     */
    public String value;
    /**
     * 消息发送的目标 id,频道消息为频道
     */
    public String target_id;
    /**
     * 用户信息，同 User Object
     */
    public UserObject user_info;
}
