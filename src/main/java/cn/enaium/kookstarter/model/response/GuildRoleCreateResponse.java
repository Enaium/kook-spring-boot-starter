package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.Integer;
import java.lang.String;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildRoleCreateResponse(@JsonProperty("code") Integer code,
                                      @JsonProperty("message") String message) {
}
