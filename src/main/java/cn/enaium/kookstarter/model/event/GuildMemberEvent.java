package cn.enaium.kookstarter.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GuildMemberEvent() {
    /**
     * 新成员加入服务器
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record JoinedGuild(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("joined_at") Long joinedAt) {
                }
            }
        }
    }

    /**
     * 服务器成员退出
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record ExitedGuild(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("exited_at") Long exitedAt) {
                }
            }
        }
    }

    /**
     * 服务器成员信息更新
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record UpdatedGuildMember(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("nickname") String nickname) {
                }
            }
        }
    }

    /**
     * 服务器成员上线
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record GuildMemberOnline(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("event_time") Long eventTime,
                                   @JsonProperty("guilds") List<String> guilds) {
                }
            }
        }
    }

    /**
     * 服务器成员下线
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record GuildMemberOffline(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("event_time") Long eventTime,
                                   @JsonProperty("guilds") List<String> guilds) {
                }
            }
        }
    }
}
