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

package cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.role;

import cn.enaium.kook.spring.boot.starter.annotation.event.Listener;
import cn.enaium.kook.spring.boot.starter.model.object.RoleObject;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.SystemMessageExtra;

/**
 * 服务器角色删除
 *
 * @author Enaium
 * @since 0.1.0
 */
@Listener
public class DeletedRole extends SystemMessageExtra<RoleObject> {
    public static final String TYPE = "deleted_role";
}
