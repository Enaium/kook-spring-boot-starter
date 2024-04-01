package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param msgId   消息 id
 * @param content 消息内容
 * @param quote   回复某条消息的msgId。如果为空，则代表删除回复，不传则无影响。
 * @author Enaium
 * @since 0.4.0
 */
public record DirectMessageUpdateBody(@Nullable @JsonProperty("msg_id") String msgId,
                                      @NotNull @JsonProperty("content") String content,
                                      @Nullable @JsonProperty("quote") String quote) {
}
