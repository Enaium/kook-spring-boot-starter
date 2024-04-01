package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildViewResponse(@JsonProperty("code") Integer code,
                                @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("roles") List<Roles> roles,
                       @JsonProperty("channels") List<Channels> channels, @JsonProperty("id") String id,
                       @JsonProperty("name") String name, @JsonProperty("topic") String topic,
                       @JsonProperty("user_id") String userId, @JsonProperty("icon") String icon,
                       @JsonProperty("notify_type") Integer notifyType, @JsonProperty("region") String region,
                       @JsonProperty("enable_open") Boolean enableOpen, @JsonProperty("open_id") String openId,
                       @JsonProperty("default_channel_id") String defaultChannelId,
                       @JsonProperty("welcome_channel_id") String welcomeChannelId,
                       @JsonProperty("boost_num") Integer boostNum, @JsonProperty("level") Integer level) {
        public record Roles(@JsonProperty("role_id") Integer roleId,
                            @JsonProperty("name") String name, @JsonProperty("color") Integer color,
                            @JsonProperty("position") Integer position, @JsonProperty("hoist") Integer hoist,
                            @JsonProperty("mentionable") Integer mentionable,
                            @JsonProperty("permissions") Integer permissions) {
        }

        public record Channels(@JsonProperty("id") Integer id,
                               @JsonProperty("guild_id") String guildId, @JsonProperty("user_id") String userId,
                               @JsonProperty("parent_id") Integer parentId, @JsonProperty("name") String name,
                               @JsonProperty("topic") String topic, @JsonProperty("type") Integer type,
                               @JsonProperty("level") Integer level, @JsonProperty("slow_mode") Integer slowMode,
                               @JsonProperty("is_category") Boolean isCategory) {
        }
    }
}
