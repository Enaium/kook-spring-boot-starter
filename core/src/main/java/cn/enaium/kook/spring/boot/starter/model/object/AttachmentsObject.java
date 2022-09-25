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
 * 附加的多媒体数据
 *
 * @author Enaium
 * @since 0.1.0
 */
public class AttachmentsObject {
    /**
     * 多媒体类型
     */
    public String type;
    /**
     * 多媒体地址
     */
    public String url;
    /**
     * 多媒体名
     */
    public String name;
    /**
     * 大小单位（B）
     */
    public int size;
}
