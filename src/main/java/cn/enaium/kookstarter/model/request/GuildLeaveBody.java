package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param guildId 服务器 id
 * @author Enaium
 * @since 0.4.0
 */
public record GuildLeaveBody(@NotNull @JsonProperty("guild_id") String guildId) {
}
