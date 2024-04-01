package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelRoleCreateResponse(@JsonProperty("code") Integer code,
                                        @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("user_id") String userId, @JsonProperty("allow") Integer allow,
                       @JsonProperty("deny") Integer deny) {
    }
}
