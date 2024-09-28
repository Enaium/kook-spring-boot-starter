package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.response.BadgeGuildResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

/**
 * Badge 相关文档
 *
 * @author Enaium
 */
public interface BadgeService {
    /**
     * 获取服务器 Badge
     *
     * @param guildId 服务器 id
     * @param style   样式类型，默认为 0
     * @since 0.4.0
     */
    @GetExchange("/api/v3/badge/guild")
    BadgeGuildResponse badgeGuild(@NotNull @RequestParam("guild_id") String guildId,
                                  @Nullable @RequestParam(value = "style", required = false) Integer style);
}
