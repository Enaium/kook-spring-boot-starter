package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.Integer;
import java.lang.String;
import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildRoleUpdateResponse(@JsonProperty("code") Integer code,
                                      @JsonProperty("message") String message, @JsonProperty("data") List<Data> data) {
    public record Data(@JsonProperty("role_id") Integer roleId, @JsonProperty("name") String name,
                       @JsonProperty("color") Integer color, @JsonProperty("position") Integer position,
                       @JsonProperty("hoist") Integer hoist, @JsonProperty("mentionable") Integer mentionable,
                       @JsonProperty("permissions") Integer permissions) {
    }
}
