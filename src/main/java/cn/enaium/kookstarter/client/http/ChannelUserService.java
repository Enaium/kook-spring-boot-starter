package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.response.ChannelUserGetJoinedChannelResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

/**
 * 频道用户相关接口列表
 *
 * @author Enaium
 */
public interface ChannelUserService {
    /**
     * 根据用户 id 和服务器 id 获取用户所在语音频道
     *
     * @param page     目标页数
     * @param pageSize 每页数据数量
     * @param guildId  服务器 id
     * @param userId   用户 id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/channel-user/get-joined-channel")
    ChannelUserGetJoinedChannelResponse channelUserGetJoinedChannel(
            @Nullable @RequestParam(value = "page", required = false) Integer page,
            @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize,
            @NotNull @RequestParam String guildId, @NotNull @RequestParam String userId);
}
