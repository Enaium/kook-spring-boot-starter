package cn.enaium.kookstarter.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserEvent() {
    /**
     * 用户加入语音频道
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record JoinedChannel(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("user_id") String userId,
                                   @JsonProperty("channel_id") String channelId,
                                   @JsonProperty("joined_at") Long joinedAt) {
                }
            }
        }
    }

    /**
     * 用户退出语音频道
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record ExitedChannel(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("user_id") String userId,
                                   @JsonProperty("channel_id") String channelId,
                                   @JsonProperty("exited_at") Long exitedAt) {
                }
            }
        }
    }

    /**
     * 用户信息更新
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record UserUpdated(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("user_id") String userId,
                                   @JsonProperty("username") String username,
                                   @JsonProperty("avatar") String avatar) {
                }
            }
        }
    }

    /**
     * 自己新加入服务器
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record SelfJoinedGuild(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("guild_id") String guildId) {
                }
            }
        }
    }

    /**
     * 自己退出服务器
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record SelfExitedGuild(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("guild_id") String guildId) {
                }
            }
        }
    }

    /**
     * Card 消息中的 Button 点击事件
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record MessageBtnClick(@JsonProperty("s") Integer s, @JsonProperty("sn") Integer sn,
                                  @JsonProperty("d") D d) {
        public record D(@JsonProperty("type") Integer type,
                        @JsonProperty("channel_type") String channelType,
                        @JsonProperty("target_id") String targetId,
                        @JsonProperty("author_id") String authorId, @JsonProperty("content") String content,
                        @JsonProperty("msg_id") String msgId,
                        @JsonProperty("msg_timestamp") Long msgTimestamp,
                        @JsonProperty("nonce") String nonce, @JsonProperty("extra") Extra extra) {
            public record Extra(@JsonProperty("type") String type,
                                @JsonProperty("body") Body body) {
                public record Body(@JsonProperty("value") String value,
                                   @JsonProperty("msg_id") String msgId,
                                   @JsonProperty("user_id") String userId,
                                   @JsonProperty("target_id") String targetId) {
                }
            }
        }
    }
}
