package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param name    表情名。长度限制 2 - 32 字符，如果不写，则为随机字符串
 * @param guildId 服务器 id
 * @param emoji   表情文件。必须为 PNG 类型，大小不能超过 256 KB
 * @author Enaium
 * @since 0.4.0
 */
public record GuildEmojiCreateBody(@Nullable @JsonProperty("name") String name,
                                   @NotNull @JsonProperty("guild_id") String guildId,
                                   @NotNull @JsonProperty("emoji") Object emoji) {
}
