package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param msgId 消息 id
 * @author Enaium
 * @since 0.4.0
 */
public record MessageDeleteBody(@NotNull @JsonProperty("msg_id") String msgId) {
}
