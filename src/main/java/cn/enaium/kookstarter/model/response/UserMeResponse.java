package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record UserMeResponse(@JsonProperty("code") Integer code,
                             @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("username") String username,
                       @JsonProperty("identify_num") String identifyNum,
                       @JsonProperty("online") Boolean online, @JsonProperty("os") String os,
                       @JsonProperty("status") Integer status, @JsonProperty("avatar") String avatar,
                       @JsonProperty("banner") String banner, @JsonProperty("bot") Boolean bot,
                       @JsonProperty("mobile_verified") Boolean mobileVerified,
                       @JsonProperty("client_id") String clientId,
                       @JsonProperty("mobile_prefix") String mobilePrefix,
                       @JsonProperty("mobile") String mobile,
                       @JsonProperty("invited_count") Integer invitedCount) {
    }
}
