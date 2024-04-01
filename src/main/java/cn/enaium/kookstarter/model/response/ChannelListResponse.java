package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelListResponse(@JsonProperty("code") Integer code,
                                  @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("meta") Meta meta, @JsonProperty("sort") List<Object> sort) {
        public record Meta(@JsonProperty("page") Integer page,
                           @JsonProperty("page_total") Integer pageTotal,
                           @JsonProperty("page_size") Integer pageSize, @JsonProperty("total") Integer total) {
        }
    }
}
