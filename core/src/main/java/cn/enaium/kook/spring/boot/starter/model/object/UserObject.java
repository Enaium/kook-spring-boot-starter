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
 * 用户
 *
 * @author Enaium
 * @since 0.1.0
 */
public class UserObject {
    /**
     * 用户的id
     */
    public String id;
    /**
     * 用户的名称
     */
    public String username;
    /**
     * 用户在当前服务器的昵称
     */
    public String nickname;
    /**
     * 用户名的认证数字，用户名正常为：user_name#identify_num
     */
    public String identify_num;
    /**
     * 当前是否在线
     */
    public boolean online;
    /**
     * 是否为机器人
     */
    public boolean bot;
    /**
     * 用户的状态,0和1代表正常，10代表被封禁
     */
    public int status;
    /**
     * 用户的头像的url地址
     */
    public String avatar;
    /**
     * vip用户的头像的url地址，可能为gif动图
     */
    public String vip_avatar;
    /**
     * 是否手机号已验证
     */
    public boolean mobile_verified;
    /**
     * 用户在当前服务器中的角色id组成的列表
     */
    public Object[] roles;
}
