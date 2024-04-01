package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param channelId    服务器中频道的 ID
 * @param name         频道名称
 * @param level        频道排序
 * @param parentId     分组频道 ID，设置为 0 为移出分组
 * @param topic        频道简介，文字频道有效
 * @param slowMode     慢速模式，单位 ms。目前只支持这些值：0, 5000, 10000, 15000, 30000, 60000, 120000, 300000, 600000, 900000, 1800000, 3600000, 7200000, 21600000，文字频道有效
 * @param limitAmount  此频道最大能容纳的用户数量，最大值 99，语音频道有效
 * @param voiceQuality 声音质量，1 流畅，2 正常，3 高质量，语音频道有效
 * @param password     密码，语音频道有效
 * @author Enaium
 * @since 0.4.0
 */
public record ChannelUpdateBody(@NotNull @JsonProperty("channel_id") String channelId,
                                @Nullable @JsonProperty("name") String name,
                                @Nullable @JsonProperty("level") Integer level,
                                @Nullable @JsonProperty("parent_id") String parentId,
                                @Nullable @JsonProperty("topic") String topic,
                                @Nullable @JsonProperty("slow_mode") Integer slowMode,
                                @Nullable @JsonProperty("limit_amount") Integer limitAmount,
                                @Nullable @JsonProperty("voice_quality") String voiceQuality,
                                @Nullable @JsonProperty("password") String password) {
}
