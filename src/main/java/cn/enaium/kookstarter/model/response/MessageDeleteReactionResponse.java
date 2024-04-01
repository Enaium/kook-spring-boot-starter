package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record MessageDeleteReactionResponse(@JsonProperty("code") Integer code,
                                            @JsonProperty("message") String message,
                                            @JsonProperty("data") List<Object> data) {
}
