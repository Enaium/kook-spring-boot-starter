package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param name    如果不写，则为"新角色"
 * @param guildId 服务器 id
 * @author Enaium
 * @since 0.4.0
 */
public record GuildRoleCreateBody(@Nullable @JsonProperty("name") String name,
                                  @NotNull @JsonProperty("guild_id") String guildId) {
}
