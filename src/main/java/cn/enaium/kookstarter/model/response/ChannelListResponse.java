package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelListResponse(@JsonProperty("code") Integer code,
                                  @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("items") List<Items> items, @JsonProperty("meta") Meta meta,
                       @JsonProperty("sort") List<Object> sort) {
        public record Items(@JsonProperty("id") String id, @JsonProperty("user_id") String userId,
                            @JsonProperty("parent_id") String parentId, @JsonProperty("name") String name,
                            @JsonProperty("type") Integer type, @JsonProperty("level") Integer level,
                            @JsonProperty("limit_amount") Integer limitAmount,
                            @JsonProperty("is_category") Boolean isCategory) {
        }

        public record Meta(@JsonProperty("page") Integer page,
                           @JsonProperty("page_total") Integer pageTotal,
                           @JsonProperty("page_size") Integer pageSize, @JsonProperty("total") Integer total) {
        }
    }
}
