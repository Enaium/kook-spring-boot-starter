package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GuildUserListResponse(@JsonProperty("code") Integer code,
                                    @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("items") List<Items> items, @JsonProperty("meta") Meta meta,
                       @JsonProperty("sort") Sort sort, @JsonProperty("user_count") Integer userCount,
                       @JsonProperty("online_count") Integer onlineCount,
                       @JsonProperty("offline_count") Integer offlineCount) {
        public record Items(@JsonProperty("id") String id,
                            @JsonProperty("username") String username,
                            @JsonProperty("identify_num") String identifyNum,
                            @JsonProperty("online") Boolean online, @JsonProperty("status") Integer status,
                            @JsonProperty("bot") Boolean bot, @JsonProperty("avatar") String avatar,
                            @JsonProperty("vip_avatar") String vipAvatar,
                            @JsonProperty("nickname") String nickname,
                            @JsonProperty("roles") List<Integer> roles) {
        }

        public record Meta(@JsonProperty("page") Integer page,
                           @JsonProperty("page_total") Integer pageTotal,
                           @JsonProperty("page_size") Integer pageSize, @JsonProperty("total") Integer total) {
        }

        public record Sort(@JsonProperty("id") Integer id) {
        }
    }
}
