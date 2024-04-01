package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildViewResponse(@JsonProperty("code") Integer code,
                                @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("name") String name,
                       @JsonProperty("topic") String topic, @JsonProperty("user_id") String userId,
                       @JsonProperty("icon") String icon, @JsonProperty("notify_type") Integer notifyType,
                       @JsonProperty("region") String region, @JsonProperty("enable_open") Boolean enableOpen,
                       @JsonProperty("open_id") String openId,
                       @JsonProperty("default_channel_id") String defaultChannelId,
                       @JsonProperty("welcome_channel_id") String welcomeChannelId,
                       @JsonProperty("boost_num") Integer boostNum, @JsonProperty("level") Integer level) {
    }
}
