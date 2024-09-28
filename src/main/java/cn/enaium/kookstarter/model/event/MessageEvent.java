package cn.enaium.kookstarter.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MessageEvent() {
    /**
     * 文字消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record Message1(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                           @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce, @JsonProperty("extra") Extra extra) {
            public record Extra(@JsonProperty("type") Integer type,
                                @JsonProperty("guild_id") String guildId,
                                @JsonProperty("channel_name") String channelName,
                                @JsonProperty("mention") List<Object> mention,
                                @JsonProperty("mention_all") Boolean mentionAll,
                                @JsonProperty("mention_roles") List<Object> mentionRoles,
                                @JsonProperty("mention_here") Boolean mentionHere,
                                @JsonProperty("code") String code, @JsonProperty("author") Author author,
                                @JsonProperty("channel_type") Integer channelType) {
                public record Author(@JsonProperty("identify_num") String identifyNum,
                                     @JsonProperty("avatar") String avatar,
                                     @JsonProperty("username") String username, @JsonProperty("id") String id,
                                     @JsonProperty("nickname") String nickname,
                                     @JsonProperty("roles") List<Object> roles) {
                }
            }
        }
    }

    /**
     * 图片消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record Message2(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                           @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce, @JsonProperty("extra") Extra extra) {
            public record Extra(@JsonProperty("type") Integer type,
                                @JsonProperty("code") String code, @JsonProperty("guild_id") String guildId,
                                @JsonProperty("attachments") Attachments attachments,
                                @JsonProperty("author") Author author,
                                @JsonProperty("channel_type") Integer channelType) {
                public record Attachments(@JsonProperty("type") String type,
                                          @JsonProperty("name") String name, @JsonProperty("url") String url) {
                }

                public record Author(@JsonProperty("identify_num") String identifyNum,
                                     @JsonProperty("avatar") String avatar,
                                     @JsonProperty("username") String username, @JsonProperty("id") String id,
                                     @JsonProperty("nickname") String nickname,
                                     @JsonProperty("roles") List<Object> roles) {
                }
            }
        }
    }

    /**
     * 视频消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record Message3(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                           @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce, @JsonProperty("extra") Extra extra) {
            public record Extra(@JsonProperty("type") Integer type,
                                @JsonProperty("guild_id") String guildId, @JsonProperty("code") String code,
                                @JsonProperty("attachments") Attachments attachments,
                                @JsonProperty("author") Author author) {
                public record Attachments(@JsonProperty("type") String type,
                                          @JsonProperty("url") String url, @JsonProperty("name") String name,
                                          @JsonProperty("file_type") String fileType,
                                          @JsonProperty("size") Integer size,
                                          @JsonProperty("duration") Integer duration,
                                          @JsonProperty("width") Integer width,
                                          @JsonProperty("height") Integer height) {
                }

                public record Author(@JsonProperty("identify_num") String identifyNum,
                                     @JsonProperty("avatar") String avatar,
                                     @JsonProperty("username") String username, @JsonProperty("id") String id,
                                     @JsonProperty("nickname") String nickname,
                                     @JsonProperty("roles") List<Object> roles) {
                }
            }
        }
    }

    /**
     * 文件消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record Message4(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                           @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce, @JsonProperty("extra") Extra extra) {
            public record Extra(@JsonProperty("type") Integer type,
                                @JsonProperty("guild_id") String guildId, @JsonProperty("code") String code,
                                @JsonProperty("attachments") Attachments attachments,
                                @JsonProperty("author") Author author,
                                @JsonProperty("channel_type") Integer channelType) {
                public record Attachments(@JsonProperty("type") String type,
                                          @JsonProperty("url") String url, @JsonProperty("name") String name,
                                          @JsonProperty("file_type") String fileType,
                                          @JsonProperty("size") Integer size) {
                }

                public record Author(@JsonProperty("identify_num") String identifyNum,
                                     @JsonProperty("avatar") String avatar,
                                     @JsonProperty("username") String username, @JsonProperty("id") String id,
                                     @JsonProperty("nickname") String nickname,
                                     @JsonProperty("roles") List<Object> roles) {
                }
            }
        }
    }

    /**
     * KMarkdown 消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record Message9(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                           @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") Integer type,
                                @JsonProperty("guild_id") String guildId,
                                @JsonProperty("channel_name") String channelName,
                                @JsonProperty("mention") List<Object> mention,
                                @JsonProperty("mention_all") Boolean mentionAll,
                                @JsonProperty("mention_roles") List<Object> mentionRoles,
                                @JsonProperty("mention_here") Boolean mentionHere,
                                @JsonProperty("nav_channels") List<Object> navChannels,
                                @JsonProperty("code") String code, @JsonProperty("author") Author author,
                                @JsonProperty("kmarkdown") Kmarkdown kmarkdown,
                                @JsonProperty("channel_type") Integer channelType) {
                public record Author(@JsonProperty("id") String id,
                                     @JsonProperty("username") String username,
                                     @JsonProperty("identify_num") String identifyNum,
                                     @JsonProperty("online") Boolean online, @JsonProperty("os") String os,
                                     @JsonProperty("status") Integer status,
                                     @JsonProperty("avatar") String avatar,
                                     @JsonProperty("tag_info") TagInfo tagInfo,
                                     @JsonProperty("nickname") String nickname,
                                     @JsonProperty("roles") List<Integer> roles) {
                    public record TagInfo(@JsonProperty("color") String color,
                                          @JsonProperty("text") String text) {
                    }
                }

                public record Kmarkdown(@JsonProperty("raw_content") String rawContent,
                                        @JsonProperty("mention_part") List<Object> mentionPart,
                                        @JsonProperty("mention_role_part") List<Object> mentionRolePart) {
                }
            }
        }
    }

    /**
     * Card 消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record Message10(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                            @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") Integer type,
                                @JsonProperty("guild_id") String guildId,
                                @JsonProperty("channel_name") String channelName,
                                @JsonProperty("mention") List<Object> mention,
                                @JsonProperty("mention_all") Boolean mentionAll,
                                @JsonProperty("mention_roles") List<Object> mentionRoles,
                                @JsonProperty("mention_here") Boolean mentionHere,
                                @JsonProperty("nav_channels") List<Object> navChannels,
                                @JsonProperty("code") String code, @JsonProperty("author") Author author,
                                @JsonProperty("channel_type") Integer channelType) {
                public record Author(@JsonProperty("id") String id,
                                     @JsonProperty("username") String username,
                                     @JsonProperty("identify_num") String identifyNum,
                                     @JsonProperty("online") Boolean online, @JsonProperty("os") String os,
                                     @JsonProperty("status") Integer status,
                                     @JsonProperty("avatar") String avatar,
                                     @JsonProperty("tag_info") TagInfo tagInfo,
                                     @JsonProperty("nickname") String nickname,
                                     @JsonProperty("roles") List<Integer> roles) {
                    public record TagInfo(@JsonProperty("color") String color,
                                          @JsonProperty("text") String text) {
                    }
                }
            }
        }
    }

    /**
     * 道具 消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record Message12(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                            @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId,
                        @JsonProperty("content") Content content, @JsonProperty("extra") Extra extra,
                        @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Content(@JsonProperty("type") String type,
                                  @JsonProperty("data") Data data) {
                public record Data(@JsonProperty("user_id") String userId,
                                   @JsonProperty("target_id") String targetId,
                                   @JsonProperty("item_id") Integer itemId) {
                }
            }

            public record Extra(@JsonProperty("type") Integer type,
                                @JsonProperty("mention") List<String> mention,
                                @JsonProperty("author") Author author,
                                @JsonProperty("kmarkdown") Kmarkdown kmarkdown,
                                @JsonProperty("channel_type") Integer channelType) {
                public record Author(@JsonProperty("id") String id,
                                     @JsonProperty("username") String username,
                                     @JsonProperty("identify_num") String identifyNum,
                                     @JsonProperty("online") Boolean online, @JsonProperty("os") String os,
                                     @JsonProperty("status") Integer status,
                                     @JsonProperty("avatar") String avatar,
                                     @JsonProperty("tag_info") TagInfo tagInfo,
                                     @JsonProperty("nickname") String nickname,
                                     @JsonProperty("roles") List<Integer> roles) {
                    public record TagInfo(@JsonProperty("color") String color,
                                          @JsonProperty("text") String text) {
                    }
                }

                public record Kmarkdown(@JsonProperty("mention") List<String> mention,
                                        @JsonProperty("mention_part") List<MentionPart> mentionPart,
                                        @JsonProperty("item_part") List<Object> itemPart) {
                    public record MentionPart(@JsonProperty("id") String id,
                                              @JsonProperty("username") String username,
                                              @JsonProperty("full_name") String fullName,
                                              @JsonProperty("avatar") String avatar) {
                    }
                }
            }
        }
    }
}
