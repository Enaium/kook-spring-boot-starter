package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param guildId    服务器 id
 * @param targetId   目标用户 id
 * @param remark     加入黑名单的原因
 * @param delMsgDays 删除最近几天的消息，最大 7 天, 默认 0
 * @author Enaium
 * @since 0.4.0
 */
public record BlacklistCreateBody(@NotNull @JsonProperty("guild_id") String guildId,
                                  @NotNull @JsonProperty("target_id") String targetId,
                                  @Nullable @JsonProperty("remark") String remark,
                                  @Nullable @JsonProperty("del_msg_days") Integer delMsgDays) {
}
