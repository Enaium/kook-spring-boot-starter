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

package cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.server;

import cn.enaium.kook.spring.boot.starter.annotation.event.Listener;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.SystemMessageExtra;

import java.util.Map;

/**
 * 服务器封禁用户
 *
 * @author Enaium
 * @since 0.1.0
 */
@Listener
public class AddedBlockListServer extends SystemMessageExtra<Map<Object, Object>> {

    public static final String TYPE = "added_block_list";

    /**
     * 操作人 id
     */
    public String operator_id;
    /**
     * 封禁理由
     */
    public String remark;
    /**
     * 被封禁成员 id 列表
     */
    public Object[] user_id;
}

