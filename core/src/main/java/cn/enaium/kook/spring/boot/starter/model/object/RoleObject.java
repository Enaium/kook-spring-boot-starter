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
 * 角色
 *
 * @author Enaium
 * @since 0.1.0
 */
public class RoleObject {
    /**
     * 角色id
     */
    public int role_id;
    /**
     * 角色名称
     */
    public String name;
    /**
     * 颜色色值
     */
    public int color;
    /**
     * 顺序位置
     */
    public int position;
    /**
     * 是否为角色设定(与普通成员分开显示)
     */
    public int hoist;
    /**
     * 是否允许任何人@提及此角色
     */
    public int mentionable;
    /**
     * 权限码
     */
    public int permissions;
}
