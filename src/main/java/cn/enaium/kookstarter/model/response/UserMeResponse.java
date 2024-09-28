package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
                       @JsonProperty("vip_avatar") String vipAvatar, @JsonProperty("banner") String banner,
                       @JsonProperty("nickname") String nickname, @JsonProperty("roles") List<Object> roles,
                       @JsonProperty("is_vip") Boolean isVip, @JsonProperty("vip_amp") Boolean vipAmp,
                       @JsonProperty("bot") Boolean bot, @JsonProperty("bot_status") Integer botStatus,
                       @JsonProperty("tag_info") TagInfo tagInfo,
                       @JsonProperty("mobile_verified") Boolean mobileVerified,
                       @JsonProperty("is_sys") Boolean isSys, @JsonProperty("client_id") String clientId,
                       @JsonProperty("verified") Boolean verified,
                       @JsonProperty("mobile_prefix") String mobilePrefix,
                       @JsonProperty("mobile") String mobile,
                       @JsonProperty("invited_count") Integer invitedCount) {
        public record TagInfo(@JsonProperty("color") String color,
                              @JsonProperty("bg_color") String bgColor, @JsonProperty("text") String text) {
        }
    }
}
