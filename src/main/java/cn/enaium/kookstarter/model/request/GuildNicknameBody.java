package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param guildId  服务器的 ID
 * @param nickname 昵称，2 - 64 长度，不传则清空昵称
 * @param userId   要修改昵称的目标用户 ID，不传则修改当前登陆用户的昵称
 * @author Enaium
 * @since 0.4.0
 */
public record GuildNicknameBody(@NotNull @JsonProperty("guild_id") String guildId,
                                @Nullable @JsonProperty("nickname") String nickname,
                                @Nullable @JsonProperty("user_id") String userId) {
}
