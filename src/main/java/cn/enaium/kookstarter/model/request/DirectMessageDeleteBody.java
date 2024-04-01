package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

/**
 * @param msgId 消息 id
 * @author Enaium
 * @since 0.4.0
 */
public record DirectMessageDeleteBody(@Nullable @JsonProperty("msg_id") String msgId) {
}
