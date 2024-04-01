package cn.enaium.kookstarter.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GuildEvent() {
    /**
     * 服务器信息更新
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record UpdatedGuild(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("user_id") String userId, @JsonProperty("icon") String icon,
                                   @JsonProperty("notify_type") Integer notifyType,
                                   @JsonProperty("region") String region,
                                   @JsonProperty("enable_open") Integer enableOpen,
                                   @JsonProperty("open_id") Integer openId,
                                   @JsonProperty("default_channel_id") String defaultChannelId,
                                   @JsonProperty("welcome_channel_id") String welcomeChannelId) {
                }
            }
        }
    }

    /**
     * 服务器删除
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record DeletedGuild(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("user_id") String userId, @JsonProperty("icon") String icon,
                                   @JsonProperty("notify_type") Integer notifyType,
                                   @JsonProperty("region") String region,
                                   @JsonProperty("enable_open") Integer enableOpen,
                                   @JsonProperty("open_id") Integer openId,
                                   @JsonProperty("default_channel_id") String defaultChannelId,
                                   @JsonProperty("welcome_channel_id") String welcomeChannelId) {
                }
            }
        }
    }

    /**
     * 服务器封禁用户
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record AddedBlockList(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("operator_id") String operatorId,
                                   @JsonProperty("remark") String remark,
                                   @JsonProperty("user_id") List<String> userId) {
                }
            }
        }
    }

    /**
     * 服务器取消封禁用户
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record DeletedBlockList(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("operator_id") String operatorId,
                                   @JsonProperty("user_id") List<String> userId) {
                }
            }
        }
    }

    /**
     * 服务器添加新表情
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record AddedEmoji(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("name") String name) {
                }
            }
        }
    }

    /**
     * 服务器删除表情
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record RemovedEmoji(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("name") String name) {
                }
            }
        }
    }

    /**
     * 服务器更新表情
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record UpdatedEmoji(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                                   @JsonProperty("name") String name) {
                }
            }
        }
    }
}
