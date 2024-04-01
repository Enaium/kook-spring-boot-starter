package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.GuildEmojiCreateBody;
import cn.enaium.kookstarter.model.request.GuildEmojiDeleteBody;
import cn.enaium.kookstarter.model.request.GuildEmojiUpdateBody;
import cn.enaium.kookstarter.model.response.GuildEmojiCreateResponse;
import cn.enaium.kookstarter.model.response.GuildEmojiDeleteResponse;
import cn.enaium.kookstarter.model.response.GuildEmojiListResponse;
import cn.enaium.kookstarter.model.response.GuildEmojiUpdateResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 服务器表情相关接口列表
 *
 * @author Enaium
 */
public interface GuildEmojiService {
    /**
     * 获取服务器表情列表
     *
     * @param page     目标页数
     * @param pageSize 每页数据数量
     * @param guildId  服务器 id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/guild-emoji/list")
    GuildEmojiListResponse guildEmojiList(
            @Nullable @RequestParam(value = "page", required = false) Integer page,
            @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize,
            @NotNull @RequestParam String guildId);

    /**
     * 创建服务器表情
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-emoji/create")
    GuildEmojiCreateResponse guildEmojiCreate(@NotNull @RequestBody GuildEmojiCreateBody body);

    /**
     * 更新服务器表情
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-emoji/update")
    GuildEmojiUpdateResponse guildEmojiUpdate(@NotNull @RequestBody GuildEmojiUpdateBody body);

    /**
     * 删除服务器表情
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-emoji/delete")
    GuildEmojiDeleteResponse guildEmojiDelete(@NotNull @RequestBody GuildEmojiDeleteBody body);
}
