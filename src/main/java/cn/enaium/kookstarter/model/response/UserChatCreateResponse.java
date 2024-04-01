package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record UserChatCreateResponse(@JsonProperty("code") Integer code,
                                     @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("code") String code,
                       @JsonProperty("last_read_time") Long lastReadTime,
                       @JsonProperty("latest_msg_time") Long latestMsgTime,
                       @JsonProperty("unread_count") Integer unreadCount,
                       @JsonProperty("is_friend") Boolean isFriend,
                       @JsonProperty("is_blocked") Boolean isBlocked,
                       @JsonProperty("is_target_blocked") Boolean isTargetBlocked,
                       @JsonProperty("target_info") TargetInfo targetInfo) {
        public record TargetInfo(@JsonProperty("id") String id,
                                 @JsonProperty("username") String username, @JsonProperty("online") Boolean online,
                                 @JsonProperty("avatar") String avatar) {
        }
    }
}
