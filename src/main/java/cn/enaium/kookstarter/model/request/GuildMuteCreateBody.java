package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param guildId 服务器 id
 * @param userId  目标用户 id
 * @param type    静音类型，1代表麦克风闭麦，2代表耳机静音
 * @author Enaium
 * @since 0.4.0
 */
public record GuildMuteCreateBody(@NotNull @JsonProperty("guild_id") String guildId,
                                  @NotNull @JsonProperty("user_id") String userId,
                                  @NotNull @JsonProperty("type") Integer type) {
}
