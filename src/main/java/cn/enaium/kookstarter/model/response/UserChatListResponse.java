package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record UserChatListResponse(@JsonProperty("code") Integer code,
                                   @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("items") List<Items> items, @JsonProperty("meta") Meta meta,
                       @JsonProperty("sort") Sort sort) {
        public record Items(@JsonProperty("code") String code,
                            @JsonProperty("last_read_time") Long lastReadTime,
                            @JsonProperty("latest_msg_time") Long latestMsgTime,
                            @JsonProperty("unread_count") Integer unreadCount,
                            @JsonProperty("target_info") TargetInfo targetInfo) {
            public record TargetInfo(@JsonProperty("id") String id,
                                     @JsonProperty("username") String username,
                                     @JsonProperty("online") Boolean online, @JsonProperty("avatar") String avatar) {
            }
        }

        public record Meta(@JsonProperty("page") Integer page,
                           @JsonProperty("page_total") Integer pageTotal,
                           @JsonProperty("page_size") Integer pageSize, @JsonProperty("total") Integer total) {
        }

        public record Sort(@JsonProperty("id") Integer id) {
        }
    }
}
