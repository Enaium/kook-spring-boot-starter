package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelUpdateResponse(@JsonProperty("code") Integer code,
                                    @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("name") String name,
                       @JsonProperty("user_id") String userId, @JsonProperty("guild_id") String guildId,
                       @JsonProperty("voice_quality") String voiceQuality,
                       @JsonProperty("limit_amount") Integer limitAmount,
                       @JsonProperty("is_category") Integer isCategory,
                       @JsonProperty("is_readonly") Boolean isReadonly,
                       @JsonProperty("parent_id") String parentId,
                       @JsonProperty("is_private") Boolean isPrivate,
                       @JsonProperty("server_type") Integer serverType,
                       @JsonProperty("server_url") String serverUrl, @JsonProperty("level") Integer level,
                       @JsonProperty("slow_mode") Integer slowMode, @JsonProperty("topic") String topic,
                       @JsonProperty("is_master") Boolean isMaster, @JsonProperty("type") Integer type,
                       @JsonProperty("permission_sync") Integer permissionSync,
                       @JsonProperty("mode") Integer mode, @JsonProperty("has_password") Boolean hasPassword) {
    }
}
