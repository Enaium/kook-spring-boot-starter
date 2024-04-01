package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param guildId     服务器 id
 * @param roleId      角色 id
 * @param name        角色名称
 * @param color       颜色
 * @param hoist       只能为 0 或者 1，是否把该角色的用户在用户列表排到前面
 * @param mentionable 只能为 0 或者 1，该角色是否可以被提及
 * @param permissions 权限,参见权限说明
 * @author Enaium
 * @since 0.4.0
 */
public record GuildRoleUpdateBody(@NotNull @JsonProperty("guild_id") String guildId,
                                  @NotNull @JsonProperty("role_id") Object roleId,
                                  @Nullable @JsonProperty("name") String name,
                                  @Nullable @JsonProperty("color") Object color,
                                  @Nullable @JsonProperty("hoist") Object hoist,
                                  @Nullable @JsonProperty("mentionable") Object mentionable,
                                  @Nullable @JsonProperty("permissions") Object permissions) {
}
