package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

/**
 * @param guildId      服务器 id
 * @param channelId    服务器频道 id
 * @param duration     邀请链接有效时长（秒），默认 7 天。可选值： 0 => 永不； 1800 => 0.5 小时； 3600 => 1 个小时； 21600 => 6 个小时； 43200 => 12 个小时； 86400 => 1 天； 604800 => 7 天
 * @param settingTimes 设置的次数，默认-1。可选值： -1 => 无限制； 1 => 1 次使用； 5 => 5 次使用； 10 => 10 次使用 ；25 => 25 次使用； 50 => 50 次使用； 100 => 100 次使用
 * @author Enaium
 * @since 0.4.0
 */
public record InviteCreateBody(@Nullable @JsonProperty("guild_id") String guildId,
                               @Nullable @JsonProperty("channel_id") String channelId,
                               @Nullable @JsonProperty("duration") Integer duration,
                               @Nullable @JsonProperty("setting_times") Integer settingTimes) {
}
