package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.InviteCreateBody;
import cn.enaium.kookstarter.model.request.InviteDeleteBody;
import cn.enaium.kookstarter.model.response.InviteCreateResponse;
import cn.enaium.kookstarter.model.response.InviteDeleteResponse;
import cn.enaium.kookstarter.model.response.InviteListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 邀请相关接口
 *
 * @author Enaium
 */
public interface InviteService {
    /**
     * 获取邀请列表
     *
     * @param guildId   服务器 id
     * @param channelId 频道 id
     * @param page      目标页数
     * @param pageSize  每页数据数量
     * @since 0.4.0
     */
    @GetExchange("/api/v3/invite/list")
    InviteListResponse inviteList(
            @Nullable @RequestParam(value = "guild_id", required = false) String guildId,
            @Nullable @RequestParam(value = "channel_id", required = false) String channelId,
            @Nullable @RequestParam(value = "page", required = false) Integer page,
            @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize);

    /**
     * 创建邀请链接
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/invite/create")
    InviteCreateResponse inviteCreate(@NotNull @RequestBody InviteCreateBody body);

    /**
     * 删除邀请链接
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/invite/delete")
    InviteDeleteResponse inviteDelete(@NotNull @RequestBody InviteDeleteBody body);
}
