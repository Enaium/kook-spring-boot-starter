package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param type         消息类型, 见[type], 不传默认为 1, 代表文本类型。 9 代表 kmarkdown 消息, 10 代表卡片消息。
 * @param targetId     目标频道 id
 * @param content      消息内容
 * @param quote        回复某条消息的 msgId
 * @param nonce        nonce, 服务端不做处理, 原样返回
 * @param tempTargetId 用户 id,如果传了，代表该消息是临时消息，该消息不会存数据库，但是会在频道内只给该用户推送临时消息。用于在频道内针对用户的操作进行单独的回应通知等。
 * @author Enaium
 * @since 0.4.0
 */
public record MessageCreateBody(@Nullable @JsonProperty("type") Integer type,
                                @NotNull @JsonProperty("target_id") String targetId,
                                @NotNull @JsonProperty("content") String content,
                                @Nullable @JsonProperty("quote") String quote,
                                @Nullable @JsonProperty("nonce") String nonce,
                                @Nullable @JsonProperty("temp_target_id") String tempTargetId) {
}
