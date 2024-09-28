package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.*;
import cn.enaium.kookstarter.model.response.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 频道消息相关接口列表
 *
 * @author Enaium
 */
public interface MessageService {
    /**
     * 获取频道聊天消息列表
     *
     * @param targetId 频道 id
     * @param msgId    参考消息 id，不传则查询最新消息
     * @param pin      只能为 0 或者 1，是否查询置顶消息。 置顶消息只支持查询最新的消息
     * @param flag     查询模式，有三种模式可以选择。不传则默认查询最新的消息
     * @param pageSize 当前分页消息数量, 默认 50
     * @since 0.4.0
     */
    @GetExchange("/api/v3/message/list")
    MessageListResponse messageList(@NotNull @RequestParam("target_id") String targetId,
                                    @Nullable @RequestParam(value = "msg_id", required = false) String msgId,
                                    @Nullable @RequestParam(value = "pin", required = false) Object pin,
                                    @Nullable @RequestParam(value = "flag", required = false) String flag,
                                    @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize);

    /**
     * 获取频道聊天消息详情
     *
     * @param msgId 消息 id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/message/view")
    MessageViewResponse messageView(@NotNull @RequestParam("msg_id") String msgId);

    /**
     * 发送频道聊天消息
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/message/create")
    MessageCreateResponse messageCreate(@NotNull @RequestBody MessageCreateBody body);

    /**
     * 更新频道聊天消息
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/message/update")
    MessageUpdateResponse messageUpdate(@NotNull @RequestBody MessageUpdateBody body);

    /**
     * 删除频道聊天消息
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/message/delete")
    MessageDeleteResponse messageDelete(@NotNull @RequestBody MessageDeleteBody body);

    /**
     * 获取频道消息某回应的用户列表
     *
     * @param msgId 频道消息的 id
     * @param emoji emoji 的 id, 可以为 GuilEmoji 或者 Emoji, 注意：在 get 中，应该进行 urlencode
     * @since 0.4.0
     */
    @GetExchange("/api/v3/message/reaction-list")
    MessageReactionListResponse messageReactionList(@NotNull @RequestParam("msg_id") String msgId,
                                                    @NotNull @RequestParam("emoji") String emoji);

    /**
     * 给某个消息添加回应
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/message/add-reaction")
    MessageAddReactionResponse messageAddReaction(
            @NotNull @RequestBody MessageAddReactionBody body);

    /**
     * 删除消息的某个回应
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/message/delete-reaction")
    MessageDeleteReactionResponse messageDeleteReaction(
            @NotNull @RequestBody MessageDeleteReactionBody body);
}
