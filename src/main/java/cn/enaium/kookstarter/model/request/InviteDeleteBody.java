package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param urlCode   邀请码
 * @param guildId   服务器 id
 * @param channelId 服务器频道 ID
 * @author Enaium
 * @since 0.4.0
 */
public record InviteDeleteBody(@NotNull @JsonProperty("url_code") String urlCode,
                               @Nullable @JsonProperty("guild_id") String guildId,
                               @Nullable @JsonProperty("channel_id") String channelId) {
}
