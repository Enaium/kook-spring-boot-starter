package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.*;
import cn.enaium.kookstarter.model.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 用户动态相关接口-游戏/进程/音乐
 *
 * @author Enaium
 */
public interface GameService {
    /**
     * 游戏列表
     *
     * @param type 类型：0全部 1用户创建 2系统创建
     * @since 0.4.0
     */
    @GetExchange("/api/v3/game")
    GameResponse game(@Nullable @RequestParam(value = "type", required = false) String type);

    /**
     * 添加游戏
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/game/create")
    GameCreateResponse gameCreate(@NotNull @RequestBody GameCreateBody body);

    /**
     * 更新游戏
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/game/update")
    GameUpdateResponse gameUpdate(@NotNull @RequestBody GameUpdateBody body);

    /**
     * 删除游戏
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/game/delete")
    GameDeleteResponse gameDelete(@NotNull @RequestBody GameDeleteBody body);

    /**
     * 添加游戏/音乐记录-开始玩/听
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/game/activity")
    GameActivityResponse gameActivity(@NotNull @RequestBody GameActivityBody body);

    /**
     * 删除游戏/音乐记录-结束玩/听
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/game/delete-activity")
    GameDeleteActivityResponse gameDeleteActivity(
            @NotNull @RequestBody GameDeleteActivityBody body);
}
