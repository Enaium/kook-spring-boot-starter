package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelUserListResponse(@JsonProperty("code") Integer code,
                                      @JsonProperty("message") String message, @JsonProperty("data") List<Data> data) {
    public record Data(@JsonProperty("id") String id, @JsonProperty("username") String username,
                       @JsonProperty("identify_num") String identifyNum,
                       @JsonProperty("online") Boolean online, @JsonProperty("os") String os,
                       @JsonProperty("status") Integer status, @JsonProperty("avatar") String avatar,
                       @JsonProperty("vip_avatar") String vipAvatar, @JsonProperty("banner") String banner,
                       @JsonProperty("nickname") String nickname, @JsonProperty("roles") List<Integer> roles,
                       @JsonProperty("is_vip") Boolean isVip,
                       @JsonProperty("is_ai_reduce_noise") Boolean isAiReduceNoise,
                       @JsonProperty("is_personal_card_bg") Boolean isPersonalCardBg,
                       @JsonProperty("bot") Boolean bot,
                       @JsonProperty("mobile_verified") Boolean mobileVerified,
                       @JsonProperty("joined_at") Long joinedAt, @JsonProperty("active_time") Long activeTime,
                       @JsonProperty("live_info") LiveInfo liveInfo) {
        public record LiveInfo(@JsonProperty("in_live") Boolean inLive,
                               @JsonProperty("audience_count") Integer audienceCount,
                               @JsonProperty("live_thumb") String liveThumb,
                               @JsonProperty("live_start_time") Integer liveStartTime) {
        }
    }
}
