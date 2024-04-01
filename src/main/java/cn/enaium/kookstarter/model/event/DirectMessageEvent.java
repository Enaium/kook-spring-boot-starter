package cn.enaium.kookstarter.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DirectMessageEvent() {
    /**
     * 私聊消息更新
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record UpdatedPrivateMessage(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("author_id") String authorId,
                                   @JsonProperty("target_id") String targetId,
                                   @JsonProperty("msg_id") String msgId,
                                   @JsonProperty("content") String content,
                                   @JsonProperty("updated_at") Long updatedAt,
                                   @JsonProperty("chat_code") String chatCode) {
                }
            }
        }
    }

    /**
     * 私聊消息被删除
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record DeletedPrivateMessage(@JsonProperty("d") D d, @JsonProperty("s") Integer s,
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
                public record Body(@JsonProperty("chat_code") String chatCode,
                                   @JsonProperty("msg_id") String msgId,
                                   @JsonProperty("author_id") String authorId,
                                   @JsonProperty("target_id") String targetId,
                                   @JsonProperty("deleted_at") Long deletedAt) {
                }
            }
        }
    }

    /**
     * 私聊内用户添加 reaction
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record PrivateAddedReaction(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("emoji") Emoji emoji,
                                   @JsonProperty("user_id") String userId,
                                   @JsonProperty("chat_code") String chatCode,
                                   @JsonProperty("msg_id") String msgId) {
                    public record Emoji(@JsonProperty("id") String id,
                                        @JsonProperty("name") String name) {
                    }
                }
            }
        }
    }

    /**
     * 私聊内用户取消 reaction
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record PrivateDeletedReaction(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("emoji") Emoji emoji,
                                   @JsonProperty("user_id") String userId,
                                   @JsonProperty("chat_code") String chatCode,
                                   @JsonProperty("msg_id") String msgId) {
                    public record Emoji(@JsonProperty("id") String id,
                                        @JsonProperty("name") String name) {
                    }
                }
            }
        }
    }
}
