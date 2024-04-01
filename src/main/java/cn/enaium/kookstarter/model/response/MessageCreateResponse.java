package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record MessageCreateResponse(@JsonProperty("code") Integer code,
                                    @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("msg_id") String msgId,
                       @JsonProperty("msg_timestamp") Long msgTimestamp, @JsonProperty("nonce") String nonce) {
    }
}
