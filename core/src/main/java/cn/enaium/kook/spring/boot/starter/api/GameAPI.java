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
 * 用户动态相关接口
 *
 * @author Enaium
 * @since 0.1.0
 */
public interface GameAPI {
    /**
     * 游戏列表
     */
    API GAME = new API(API.Method.GET, "game");
    /**
     * 添加游戏
     */
    API GAME_CREATE = new API(API.Method.POST, "game/create");
    /**
     * 更新游戏
     */
    API GAME_UPDATE = new API(API.Method.POST, "game/update");
    /**
     * 删除游戏
     */
    API GAME_DELETE = new API(API.Method.POST, "game/delete");
    /**
     * 添加游戏记录-开始玩
     */
    API GAME_ACTIVITY = new API(API.Method.POST, "game/activity");
    /**
     * 删除游戏记录-结束玩
     */
    API GAME_DELETE_ACTIVITY = new API(API.Method.POST, "game/delete-activity");
}
