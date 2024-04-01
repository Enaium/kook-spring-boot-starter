package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param channelId 频道 id, 如果频道是分组的 id,会同步给所有 sync=1 的子频道
 * @param type      value 的类型，只能为"role_id","user_id",不传则默认为"user_id"
 * @param value     根据 type，为用户 id 或角色 id
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelRoleDeleteBody(@NotNull @JsonProperty("channel_id") String channelId,
                                    @Nullable @JsonProperty("type") String type,
                                    @Nullable @JsonProperty("value") String value) {
}
