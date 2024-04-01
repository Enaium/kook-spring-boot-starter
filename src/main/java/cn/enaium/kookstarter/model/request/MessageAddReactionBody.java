package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param msgId 频道消息的 id
 * @param emoji emoji 的 id, 可以为 GuilEmoji 或者 Emoji
 * @author Enaium
 * @since 0.4.0
 */
public record MessageAddReactionBody(@NotNull @JsonProperty("msg_id") String msgId,
                                     @NotNull @JsonProperty("emoji") String emoji) {
}
