package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param guildId  服务器 id
 * @param targetId 目标用户 id
 * @author Enaium
 * @since 0.4.0
 */
public record BlacklistDeleteBody(@NotNull @JsonProperty("guild_id") String guildId,
                                  @NotNull @JsonProperty("target_id") String targetId) {
}
