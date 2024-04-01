package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param guildId  服务器 ID
 * @param targetId 目标用户 ID
 * @author Enaium
 * @since 0.4.0
 */
public record GuildKickoutBody(@NotNull @JsonProperty("guild_id") String guildId,
                               @NotNull @JsonProperty("target_id") String targetId) {
}
