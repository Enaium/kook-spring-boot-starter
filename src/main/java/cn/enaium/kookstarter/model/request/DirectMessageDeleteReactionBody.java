package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param msgId  消息 id
 * @param emoji  表情的 ID
 * @param userId 用户的 id, 如果不填则为自己的 id。删除别人的 reaction 需要有管理频道消息的权限
 * @author Enaium
 * @since 0.4.0
 */
public record DirectMessageDeleteReactionBody(@NotNull @JsonProperty("msg_id") String msgId,
                                              @NotNull @JsonProperty("emoji") String emoji,
                                              @Nullable @JsonProperty("user_id") String userId) {
}
