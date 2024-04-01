package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record DirectMessageViewResponse(@JsonProperty("code") Integer code,
                                        @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("type") Integer type,
                       @JsonProperty("content") String content, @JsonProperty("embeds") List<Object> embeds,
                       @JsonProperty("attachments") Boolean attachments,
                       @JsonProperty("create_at") Long createAt, @JsonProperty("updated_at") Integer updatedAt,
                       @JsonProperty("reactions") List<Reactions> reactions,
                       @JsonProperty("author_id") String authorId,
                       @JsonProperty("image_name") String imageName,
                       @JsonProperty("mention_info") MentionInfo mentionInfo,
                       @JsonProperty("from_type") Integer fromType, @JsonProperty("msg_icon") String msgIcon,
                       @JsonProperty("quote") Object quote) {
        public record Reactions(@JsonProperty("emoji") Emoji emoji,
                                @JsonProperty("count") Integer count, @JsonProperty("me") Boolean me) {
            public record Emoji(@JsonProperty("id") String id, @JsonProperty("name") String name) {
            }
        }

        public record MentionInfo(@JsonProperty("mention_part") List<Object> mentionPart,
                                  @JsonProperty("channel_part") List<Object> channelPart,
                                  @JsonProperty("item_part") List<Object> itemPart) {
        }
    }
}
