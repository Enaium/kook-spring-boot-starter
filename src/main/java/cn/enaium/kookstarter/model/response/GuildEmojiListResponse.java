package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildEmojiListResponse(@JsonProperty("code") Integer code,
                                     @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("items") List<Items> items, @JsonProperty("meta") Meta meta,
                       @JsonProperty("sort") Sort sort) {
        public record Items(@JsonProperty("name") String name, @JsonProperty("id") String id,
                            @JsonProperty("user_info") UserInfo userInfo) {
            public record UserInfo(@JsonProperty("id") String id,
                                   @JsonProperty("username") String username,
                                   @JsonProperty("identify_num") String identifyNum,
                                   @JsonProperty("online") Boolean online, @JsonProperty("os") String os,
                                   @JsonProperty("status") Integer status, @JsonProperty("avatar") String avatar) {
            }
        }

        public record Meta(@JsonProperty("page") Integer page,
                           @JsonProperty("page_total") Integer pageTotal,
                           @JsonProperty("page_size") Integer pageSize, @JsonProperty("total") Integer total) {
        }

        public record Sort(@JsonProperty("id") Integer id) {
        }
    }
}
