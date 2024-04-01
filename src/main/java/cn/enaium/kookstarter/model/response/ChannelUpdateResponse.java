package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
                       @JsonProperty("permission_overwrites") List<PermissionOverwrites> permissionOverwrites,
                       @JsonProperty("permission_users") List<PermissionUsers> permissionUsers,
                       @JsonProperty("permission_sync") Integer permissionSync,
                       @JsonProperty("mode") Integer mode, @JsonProperty("has_password") Boolean hasPassword) {
        public record PermissionOverwrites(@JsonProperty("role_id") Integer roleId,
                                           @JsonProperty("allow") Integer allow, @JsonProperty("deny") Integer deny) {
        }

        public record PermissionUsers(@JsonProperty("user") User user,
                                      @JsonProperty("allow") Integer allow, @JsonProperty("deny") Integer deny) {
            public record User(@JsonProperty("id") String id,
                               @JsonProperty("username") String username,
                               @JsonProperty("identify_num") String identifyNum,
                               @JsonProperty("online") Boolean online, @JsonProperty("os") String os,
                               @JsonProperty("status") Integer status, @JsonProperty("avatar") String avatar,
                               @JsonProperty("vip_avatar") String vipAvatar,
                               @JsonProperty("banner") String banner,
                               @JsonProperty("nickname") String nickname,
                               @JsonProperty("roles") List<Integer> roles,
                               @JsonProperty("is_vip") Boolean isVip,
                               @JsonProperty("is_ai_reduce_noise") Boolean isAiReduceNoise,
                               @JsonProperty("bot") Boolean bot, @JsonProperty("tag_info") TagInfo tagInfo,
                               @JsonProperty("mobile_verified") Boolean mobileVerified,
                               @JsonProperty("joined_at") Long joinedAt,
                               @JsonProperty("active_time") Long activeTime) {
                public record TagInfo(@JsonProperty("color") String color,
                                      @JsonProperty("text") String text) {
                }
            }
        }
    }
}
