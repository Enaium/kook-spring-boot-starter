package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.BlacklistCreateBody;
import cn.enaium.kookstarter.model.request.BlacklistDeleteBody;
import cn.enaium.kookstarter.model.response.BlacklistCreateResponse;
import cn.enaium.kookstarter.model.response.BlacklistDeleteResponse;
import cn.enaium.kookstarter.model.response.BlacklistListResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 黑名单相关接口
 *
 * @author Enaium
 */
public interface BlacklistService {
    /**
     * 获取黑名单列表
     *
     * @param guildId 服务器 id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/blacklist/list")
    BlacklistListResponse blacklistList(@NotNull @RequestParam String guildId);

    /**
     * 加入黑名单
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/blacklist/create")
    BlacklistCreateResponse blacklistCreate(@NotNull @RequestBody BlacklistCreateBody body);

    /**
     * 移除黑名单
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/blacklist/delete")
    BlacklistDeleteResponse blacklistDelete(@NotNull @RequestBody BlacklistDeleteBody body);
}
