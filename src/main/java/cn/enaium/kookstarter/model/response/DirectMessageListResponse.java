package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record DirectMessageListResponse(@JsonProperty("code") Integer code,
                                        @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("items") List<Items> items) {
        public record Items(@JsonProperty("id") String id, @JsonProperty("type") Integer type,
                            @JsonProperty("content") String content,
                            @JsonProperty("embeds") List<Object> embeds,
                            @JsonProperty("attachments") List<Object> attachments,
                            @JsonProperty("create_at") Long createAt,
                            @JsonProperty("updated_at") Integer updatedAt,
                            @JsonProperty("reactions") List<Object> reactions,
                            @JsonProperty("author_id") String authorId,
                            @JsonProperty("image_name") String imageName,
                            @JsonProperty("read_status") Boolean readStatus,
                            @JsonProperty("quote") Object quote,
                            @JsonProperty("mention_info") Object mentionInfo) {
        }
    }
}
