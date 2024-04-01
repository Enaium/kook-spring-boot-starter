package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record MessageReactionListResponse(@JsonProperty("code") Integer code,
                                          @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("username") String username,
                       @JsonProperty("identify_num") String identifyNum,
                       @JsonProperty("online") Boolean online, @JsonProperty("status") Integer status,
                       @JsonProperty("avatar") String avatar, @JsonProperty("bot") Boolean bot,
                       @JsonProperty("tag_info") TagInfo tagInfo, @JsonProperty("nickname") String nickname,
                       @JsonProperty("reaction_time") Long reactionTime) {
        public record TagInfo(@JsonProperty("color") String color,
                              @JsonProperty("text") String text) {
        }
    }
}
