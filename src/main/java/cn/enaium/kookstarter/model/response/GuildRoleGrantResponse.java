package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildRoleGrantResponse(@JsonProperty("code") Integer code,
                                     @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("user_id") String userId,
                       @JsonProperty("guild_id") String guildId, @JsonProperty("roles") List<Integer> roles) {
    }
}
