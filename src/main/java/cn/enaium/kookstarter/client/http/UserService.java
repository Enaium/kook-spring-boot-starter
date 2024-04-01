package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.UserOfflineBody;
import cn.enaium.kookstarter.model.response.UserMeResponse;
import cn.enaium.kookstarter.model.response.UserOfflineResponse;
import cn.enaium.kookstarter.model.response.UserViewResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 用户相关接口列表
 *
 * @author Enaium
 * @since 0.3.0
 */
public interface UserService {
    /**
     * 获取当前用户信息
     *
     * @since 0.4.0
     */
    @GetExchange("/user/me")
    UserMeResponse userMe();

    /**
     * 获取目标用户信息
     *
     * @param userId  none
     * @param guildId 服务器 id
     * @since 0.4.0
     */
    @GetExchange("/user/view")
    UserViewResponse userView(@NotNull @RequestParam String userId,
                              @Nullable @RequestParam(value = "guild_id", required = false) String guildId);

    /**
     * 下线机器人
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/user/offline")
    UserOfflineResponse userOffline(@NotNull @RequestBody UserOfflineBody body);
}
