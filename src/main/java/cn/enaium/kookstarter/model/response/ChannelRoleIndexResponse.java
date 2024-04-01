package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelRoleIndexResponse(@JsonProperty("code") Integer code,
                                       @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(
            @JsonProperty("permission_overwrites") List<PermissionOverwrites> permissionOverwrites,
            @JsonProperty("permission_users") List<PermissionUsers> permissionUsers,
            @JsonProperty("permission_sync") Integer permissionSync) {
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
                               @JsonProperty("mobile_verified") Boolean mobileVerified,
                               @JsonProperty("nickname") String nickname,
                               @JsonProperty("roles") List<Object> roles,
                               @JsonProperty("joined_at") Long joinedAt,
                               @JsonProperty("active_time") Long activeTime) {
            }
        }
    }
}
