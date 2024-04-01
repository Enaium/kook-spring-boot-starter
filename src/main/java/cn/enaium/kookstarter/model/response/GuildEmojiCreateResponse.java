package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildEmojiCreateResponse(@JsonProperty("code") Integer code,
                                       @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("name") String name, @JsonProperty("id") String id,
                       @JsonProperty("user_info") UserInfo userInfo) {
        public record UserInfo(@JsonProperty("id") String id,
                               @JsonProperty("username") String username,
                               @JsonProperty("identify_num") String identifyNum,
                               @JsonProperty("online") Boolean online, @JsonProperty("status") Integer status,
                               @JsonProperty("avatar") String avatar,
                               @JsonProperty("vip_avatar") String vipAvatar) {
        }
    }
}
