package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param name 表情名。长度限制 2 - 32 字符，如果不写，则为随机字符串
 * @param id   表情 ID
 * @author Enaium
 * @since 0.4.0
 */
public record GuildEmojiUpdateBody(@NotNull @JsonProperty("name") String name,
                                   @NotNull @JsonProperty("id") String id) {
}
