package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record MessageListResponse(@JsonProperty("code") Integer code,
                                  @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("items") List<Items> items) {
        public record Items(@JsonProperty("id") String id, @JsonProperty("type") Integer type,
                            @JsonProperty("content") String content,
                            @JsonProperty("mention") List<String> mention,
                            @JsonProperty("mention_all") Boolean mentionAll,
                            @JsonProperty("mention_roles") List<Object> mentionRoles,
                            @JsonProperty("mention_here") Boolean mentionHere,
                            @JsonProperty("embeds") List<Embeds> embeds,
                            @JsonProperty("attachments") Object attachments,
                            @JsonProperty("create_at") Long createAt,
                            @JsonProperty("updated_at") Integer updatedAt,
                            @JsonProperty("reactions") List<Reactions> reactions,
                            @JsonProperty("author") Author author, @JsonProperty("image_name") String imageName,
                            @JsonProperty("read_status") Boolean readStatus,
                            @JsonProperty("quote") Object quote,
                            @JsonProperty("mention_info") MentionInfo mentionInfo) {
            public record Embeds(@JsonProperty("type") String type, @JsonProperty("url") String url,
                                 @JsonProperty("origin_url") String originUrl,
                                 @JsonProperty("av_no") String avNo,
                                 @JsonProperty("iframe_path") String iframePath,
                                 @JsonProperty("duration") Integer duration, @JsonProperty("title") String title,
                                 @JsonProperty("pic") String pic) {
            }

            public record Reactions(@JsonProperty("emoji") Emoji emoji,
                                    @JsonProperty("count") Integer count, @JsonProperty("me") Boolean me) {
                public record Emoji(@JsonProperty("id") String id,
                                    @JsonProperty("name") String name) {
                }
            }

            public record Author(@JsonProperty("id") String id,
                                 @JsonProperty("username") String username,
                                 @JsonProperty("online") Boolean online, @JsonProperty("avatar") String avatar) {
            }

            public record MentionInfo(@JsonProperty("mention_part") List<MentionPart> mentionPart,
                                      @JsonProperty("mention_role_part") List<MentionRolePart> mentionRolePart) {
                public record MentionPart(@JsonProperty("id") String id,
                                          @JsonProperty("username") String username,
                                          @JsonProperty("full_name") String fullName,
                                          @JsonProperty("avatar") String avatar) {
                }

                public record MentionRolePart(@JsonProperty("role_id") Integer roleId,
                                              @JsonProperty("name") String name, @JsonProperty("color") Integer color,
                                              @JsonProperty("position") Integer position,
                                              @JsonProperty("hoist") Integer hoist,
                                              @JsonProperty("mentionable") Integer mentionable,
                                              @JsonProperty("permissions") Integer permissions) {
                }
            }
        }
    }
}
