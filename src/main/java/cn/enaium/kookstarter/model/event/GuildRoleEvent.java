package cn.enaium.kookstarter.model.event;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GuildRoleEvent() {
    /**
     * 服务器角色增加
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record AddedRole(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("role_id") Integer roleId,
                                   @JsonProperty("name") String name, @JsonProperty("color") Integer color,
                                   @JsonProperty("position") Integer position,
                                   @JsonProperty("hoist") Integer hoist,
                                   @JsonProperty("mentionable") Integer mentionable,
                                   @JsonProperty("permissions") Integer permissions) {
                }
            }
        }
    }

    /**
     * 服务器角色删除
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record DeletedRole(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("role_id") Integer roleId,
                                   @JsonProperty("name") String name, @JsonProperty("color") Integer color,
                                   @JsonProperty("position") Integer position,
                                   @JsonProperty("hoist") Integer hoist,
                                   @JsonProperty("mentionable") Integer mentionable,
                                   @JsonProperty("permissions") Integer permissions) {
                }
            }
        }
    }

    /**
     * 服务器角色更新
     *
     * @author Enaium
     * @since 0.4.0
     */
    public record UpdatedRole(@JsonProperty("s") Integer s, @JsonProperty("d") D d,
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
                public record Body(@JsonProperty("role_id") Integer roleId,
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
