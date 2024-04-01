package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildListResponse(@JsonProperty("code") Integer code,
                                @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("items") List<Items> items, @JsonProperty("meta") Meta meta,
                       @JsonProperty("sort") Sort sort) {
        public record Items(@JsonProperty("id") String id, @JsonProperty("name") String name,
                            @JsonProperty("topic") String topic, @JsonProperty("user_id") String userId,
                            @JsonProperty("icon") String icon, @JsonProperty("notify_type") Integer notifyType,
                            @JsonProperty("region") String region,
                            @JsonProperty("enable_open") Boolean enableOpen,
                            @JsonProperty("open_id") String openId,
                            @JsonProperty("default_channel_id") String defaultChannelId,
                            @JsonProperty("welcome_channel_id") String welcomeChannelId,
                            @JsonProperty("boost_num") Integer boostNum, @JsonProperty("level") Integer level) {
        }

        public record Meta(@JsonProperty("page") Integer page,
                           @JsonProperty("page_total") Integer pageTotal,
                           @JsonProperty("page_size") Integer pageSize, @JsonProperty("total") Integer total) {
        }

        public record Sort(@JsonProperty("id") Integer id) {
        }
    }
}
