package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param channelId 频道 ID
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelRoleSyncBody(@NotNull @JsonProperty("channel_id") String channelId) {
}
