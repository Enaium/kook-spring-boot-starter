package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record MessageViewResponse(@JsonProperty("code") Integer code,
                                  @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("type") Integer type,
                       @JsonProperty("content") String content, @JsonProperty("mention") List<String> mention,
                       @JsonProperty("mention_all") Boolean mentionAll,
                       @JsonProperty("mention_roles") List<Object> mentionRoles,
                       @JsonProperty("mention_here") Boolean mentionHere,
                       @JsonProperty("embeds") List<Object> embeds,
                       @JsonProperty("attachments") Object attachments,
                       @JsonProperty("create_at") Long createAt, @JsonProperty("updated_at") Integer updatedAt,
                       @JsonProperty("reactions") List<Object> reactions,
                       @JsonProperty("author") Author author, @JsonProperty("image_name") String imageName,
                       @JsonProperty("read_status") Boolean readStatus, @JsonProperty("quote") Object quote,
                       @JsonProperty("mention_info") MentionInfo mentionInfo) {
        public record Author(@JsonProperty("id") String id,
                             @JsonProperty("username") String username,
                             @JsonProperty("identify_num") String identifyNum,
                             @JsonProperty("online") Boolean online, @JsonProperty("os") String os,
                             @JsonProperty("status") Integer status, @JsonProperty("avatar") String avatar,
                             @JsonProperty("vip_avatar") String vipAvatar, @JsonProperty("banner") String banner,
                             @JsonProperty("nickname") String nickname,
                             @JsonProperty("roles") List<Object> roles, @JsonProperty("is_vip") Boolean isVip,
                             @JsonProperty("bot") Boolean bot) {
        }

        public record MentionInfo(@JsonProperty("mention_part") List<Object> mentionPart,
                                  @JsonProperty("mention_role_part") List<Object> mentionRolePart) {
        }
    }
}
