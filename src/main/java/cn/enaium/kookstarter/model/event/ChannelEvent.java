package cn.enaium.kookstarter.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ChannelEvent() {
    /**
     * 频道内用户取消 reaction
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record DeletedReaction(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                                  @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") String type,
                                @JsonProperty("body") Body body) {
                public record Body(@JsonProperty("channel_id") String channelId,
                                   @JsonProperty("emoji") Emoji emoji, @JsonProperty("user_id") String userId,
                                   @JsonProperty("msg_id") String msgId) {
                    public record Emoji(@JsonProperty("id") String id,
                                        @JsonProperty("name") String name) {
                    }
                }
            }
        }
    }

    /**
     * 频道消息更新
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record UpdatedMessage(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                                 @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") String type,
                                @JsonProperty("body") Body body) {
                public record Body(@JsonProperty("channel_id") String channelId,
                                   @JsonProperty("content") String content,
                                   @JsonProperty("mention") List<Object> mention,
                                   @JsonProperty("mention_all") Boolean mentionAll,
                                   @JsonProperty("mention_here") Boolean mentionHere,
                                   @JsonProperty("mention_roles") List<Object> mentionRoles,
                                   @JsonProperty("updated_at") Long updatedAt,
                                   @JsonProperty("msg_id") String msgId) {
                }
            }
        }
    }

    /**
     * 频道消息被删除
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record DeletedMessage(@JsonProperty("d") D d, @JsonProperty("s") Integer s,
                                 @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") String type,
                                @JsonProperty("body") Body body) {
                public record Body(@JsonProperty("channel_id") String channelId,
                                   @JsonProperty("msg_id") String msgId) {
                }
            }
        }
    }

    /**
     * 新增频道
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record AddedChannel(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                               @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") String type,
                                @JsonProperty("body") Body body) {
                public record Body(@JsonProperty("id") String id, @JsonProperty("name") String name,
                                   @JsonProperty("user_id") String userId,
                                   @JsonProperty("guild_id") String guildId,
                                   @JsonProperty("is_category") Integer isCategory,
                                   @JsonProperty("parent_id") String parentId,
                                   @JsonProperty("level") Integer level,
                                   @JsonProperty("slow_mode") Integer slowMode,
                                   @JsonProperty("topic") String topic, @JsonProperty("type") Integer type,
                                   @JsonProperty("permission_sync") Integer permissionSync) {
                }
            }
        }
    }

    /**
     * 删除频道
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record DeletedChannel(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                                 @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") String type,
                                @JsonProperty("body") Body body) {
                public record Body(@JsonProperty("id") String id,
                                   @JsonProperty("deleted_at") Long deletedAt) {
                }
            }
        }
    }

    /**
     * 新的频道置顶消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record PinnedMessage(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
                                @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") String type,
                                @JsonProperty("body") Body body) {
                public record Body(@JsonProperty("channel_id") String channelId,
                                   @JsonProperty("operator_id") String operatorId,
                                   @JsonProperty("msg_id") String msgId) {
                }
            }
        }
    }

    /**
     * 取消频道置顶消息
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record UnpinnedMessage(@JsonProperty("d") D d, @JsonProperty("s") Integer s,
                                  @JsonProperty("sn") Integer sn) {
        public record D(@JsonProperty("channel_type") String channelType,
                        @JsonProperty("type") Integer type, @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("extra") Extra extra, @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce,
                        @JsonProperty("verify_token") String verifyToken) {
            public record Extra(@JsonProperty("type") String type,
                                @JsonProperty("body") Body body) {
                public record Body(@JsonProperty("channel_id") String channelId,
                                   @JsonProperty("operator_id") String operatorId,
                                   @JsonProperty("msg_id") String msgId) {
                }
            }
        }
    }
}
