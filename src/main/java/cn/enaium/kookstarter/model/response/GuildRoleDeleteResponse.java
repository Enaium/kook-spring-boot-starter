package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.Integer;
import java.lang.String;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildRoleDeleteResponse(@JsonProperty("code") Integer code,
                                      @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data() {
    }
}
