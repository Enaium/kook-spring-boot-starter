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

package cn.enaium.kook.spring.boot.starter.model.constant;

/**
 * 1:文字消息, 2:图片消息，3:视频消息，4:文件消息， 8:音频消息，9:KMarkdown，10:card 消息，12:动作消息 255:系统消息, 其它的暂未开放
 *
 * @author Enaium
 * @since 0.2.0
 */
public interface MessageType {
    int TEXT = 1;
    int IMAGE = 2;
    int VIDEO = 3;
    int FILE = 4;
    int AUDIO = 8;
    int KMARKDOWN = 9;
    int CARD = 10;
    int SYSTEM = 255;
}
