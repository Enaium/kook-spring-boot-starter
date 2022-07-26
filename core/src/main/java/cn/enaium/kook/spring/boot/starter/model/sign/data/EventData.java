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

package cn.enaium.kook.spring.boot.starter.model.sign.data;

public class EventData<T> {
    /**
     * 消息通道类型, GROUP 为组播消息, PERSON 为单播消息, BROADCAST 为广播消息
     */
    public String channel_type;

    /**
     * 1:文字消息, 2:图片消息，3:视频消息，4:文件消息， 8:音频消息，9:KMarkdown，10:card 消息，255:系统消息, 其它的暂未开放
     */
    public int type;

    /**
     * 发送目的, 频道消息类时, 代表的是频道 channel_id，如果 channel_type 为 GROUP 组播且 type 为 255 系统消息时，则代表服务器 guild_id
     */
    public String target_id;

    /**
     * 发送者 id, 1 代表系统
     */
    public String author_id;

    /**
     * 消息内容, 文件，图片，视频时，content 为 url
     */
    public String content;

    /**
     * 消息的 id
     */
    public String msg_id;

    /**
     * 消息发送时间的毫秒时间戳
     */
    public long msg_timestamp;

    /**
     * 随机串，与用户消息发送 api 中传的 nonce 保持一致
     */
    public String nonce;

    /**
     * 不同的消息类型，结构不一致
     */
    public T extra;
}