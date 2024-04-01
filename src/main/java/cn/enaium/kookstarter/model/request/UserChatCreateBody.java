package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param targetId 目标用户 id
 * @author Enaium
 * @since 0.4.0
 */
public record UserChatCreateBody(@NotNull @JsonProperty("target_id") String targetId) {
}
