package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param guildId      服务器 id
 * @param name         频道名称
 * @param parentId     父分组 id
 * @param type         频道类型，1 文字，2 语音，默认为 1
 * @param limitAmount  语音频道人数限制，最大 99
 * @param voiceQuality 语音音质，默认为2。1流畅，2正常，3高质量
 * @param isCategory   是否是分组，默认为 0。1 是，0 否。当该值传 1 时，只接收 guild_id、name、is_category 三个字段！
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelCreateBody(@NotNull @JsonProperty("guild_id") String guildId,
                                @NotNull @JsonProperty("name") String name,
                                @Nullable @JsonProperty("parent_id") String parentId,
                                @Nullable @JsonProperty("type") Integer type,
                                @Nullable @JsonProperty("limit_amount") Integer limitAmount,
                                @Nullable @JsonProperty("voice_quality") String voiceQuality,
                                @Nullable @JsonProperty("is_category") Integer isCategory) {
}
