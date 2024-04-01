package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param type     消息类型, 见[type], 不传默认为 1, 代表文本类型。9 代表 kmarkdown 消息, 10 代表卡片消息。
 * @param targetId 目标用户 id，后端会自动创建会话。有此参数之后可不传 chat_code参数
 * @param chatCode 目标会话 Code，chat_code 与 target_id 必须传一个
 * @param content  消息内容
 * @param quote    回复某条消息的 msgId
 * @param nonce    nonce, 服务端不做处理, 原样返回
 * @author Enaium
 * @since 0.4.0
 */
public record DirectMessageCreateBody(@Nullable @JsonProperty("type") Integer type,
                                      @Nullable @JsonProperty("target_id") String targetId,
                                      @Nullable @JsonProperty("chat_code") String chatCode,
                                      @NotNull @JsonProperty("content") String content,
                                      @Nullable @JsonProperty("quote") String quote,
                                      @Nullable @JsonProperty("nonce") String nonce) {
}
