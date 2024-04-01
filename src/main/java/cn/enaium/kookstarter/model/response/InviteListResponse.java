package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record InviteListResponse(@JsonProperty("code") Integer code,
                                 @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("meta") Meta meta, @JsonProperty("sort") Sort sort) {
        public record Meta(@JsonProperty("page") Integer page,
                           @JsonProperty("page_total") Integer pageTotal,
                           @JsonProperty("page_size") Integer pageSize, @JsonProperty("total") Integer total) {
        }

        public record Sort() {
        }
    }
}
