package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelRoleSyncResponse(@JsonProperty("code") Integer code,
                                      @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("permission_users") List<Object> permissionUsers) {
    }
}
