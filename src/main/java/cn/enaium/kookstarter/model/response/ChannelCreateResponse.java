package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelCreateResponse(@JsonProperty("code") Integer code,
                                    @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("guild_id") String guildId,
                       @JsonProperty("parent_id") String parentId, @JsonProperty("user_id") String userId,
                       @JsonProperty("name") String name, @JsonProperty("topic") String topic,
                       @JsonProperty("type") Integer type, @JsonProperty("level") Integer level,
                       @JsonProperty("slow_mode") Integer slowMode,
                       @JsonProperty("has_password") Boolean hasPassword,
                       @JsonProperty("limit_amount") Integer limitAmount,
                       @JsonProperty("is_category") Boolean isCategory,
                       @JsonProperty("permission_sync") Integer permissionSync,
                       @JsonProperty("permission_overwrites") List<PermissionOverwrites> permissionOverwrites,
                       @JsonProperty("permission_users") List<Object> permissionUsers,
                       @JsonProperty("voice_quality") String voiceQuality,
                       @JsonProperty("server_url") String serverUrl) {
        public record PermissionOverwrites(@JsonProperty("role_id") Integer roleId,
                                           @JsonProperty("allow") Integer allow, @JsonProperty("deny") Integer deny) {
        }
    }
}
