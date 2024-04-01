package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param msgId        消息 id
 * @param content      消息内容
 * @param quote        回复某条消息的 msgId。如果为空，则代表删除回复，不传则无影响。
 * @param tempTargetId 用户 id，针对特定用户临时更新消息，必须是正常消息才能更新。与发送临时消息概念不同，但同样不保存数据库。
 * @author Enaium
 * @since 0.4.0
 */
public record MessageUpdateBody(@NotNull @JsonProperty("msg_id") String msgId,
                                @NotNull @JsonProperty("content") String content,
                                @Nullable @JsonProperty("quote") String quote,
                                @Nullable @JsonProperty("temp_target_id") String tempTargetId) {
}
