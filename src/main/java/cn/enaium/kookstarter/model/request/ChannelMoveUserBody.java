package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param targetId 目标频道 id, 需要是语音频道
 * @param userIds  用户 id 的数组
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelMoveUserBody(@NotNull @JsonProperty("target_id") String targetId,
                                  @NotNull @JsonProperty("user_ids") Object userIds) {
}
