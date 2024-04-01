package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildMuteListResponse(@JsonProperty("code") Integer code,
                                    @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("mic") Mic mic, @JsonProperty("headset") Headset headset) {
        public record Mic(@JsonProperty("type") Integer type,
                          @JsonProperty("user_ids") List<String> userIds) {
        }

        public record Headset(@JsonProperty("type") Integer type,
                              @JsonProperty("user_ids") List<String> userIds) {
        }
    }
}
