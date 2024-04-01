package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record UserViewResponse(@JsonProperty("code") Integer code,
                               @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("username") String username,
                       @JsonProperty("identify_num") String identifyNum,
                       @JsonProperty("online") Boolean online, @JsonProperty("status") Integer status,
                       @JsonProperty("bot") Boolean bot, @JsonProperty("avatar") String avatar,
                       @JsonProperty("vip_avatar") String vipAvatar,
                       @JsonProperty("mobile_verified") Boolean mobileVerified,
                       @JsonProperty("roles") List<Roles> roles, @JsonProperty("joined_at") Integer joinedAt,
                       @JsonProperty("active_time") Integer activeTime) {
        public record Roles() {
        }
    }
}
