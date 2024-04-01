package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param guildId 服务器 id
 * @param userId  用户 id
 * @param roleId  服务器角色 id
 * @author Enaium
 * @since 0.4.0
 */
public record GuildRoleGrantBody(@NotNull @JsonProperty("guild_id") String guildId,
                                 @NotNull @JsonProperty("user_id") String userId,
                                 @NotNull @JsonProperty("role_id") Object roleId) {
}
