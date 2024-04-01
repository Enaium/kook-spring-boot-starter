package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param guildId 服务器 id
 * @param roleId  角色 id
 * @author Enaium
 * @since 0.4.0
 */
public record GuildRoleDeleteBody(@NotNull @JsonProperty("guild_id") String guildId,
                                  @NotNull @JsonProperty("role_id") Object roleId) {
}
