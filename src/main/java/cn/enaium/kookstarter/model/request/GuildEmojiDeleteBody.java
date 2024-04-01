package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param id 表情 ID
 * @author Enaium
 * @since 0.4.0
 */
public record GuildEmojiDeleteBody(@NotNull @JsonProperty("id") String id) {
}
