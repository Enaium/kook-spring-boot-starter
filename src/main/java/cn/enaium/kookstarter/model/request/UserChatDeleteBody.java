package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param chatCode 目标私信会话 Code
 * @author Enaium
 * @since 0.4.0
 */
public record UserChatDeleteBody(@NotNull @JsonProperty("chat_code") String chatCode) {
}
