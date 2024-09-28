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
 * 用户私聊消息接口列表
 *
 * @author Enaium
 */
public interface DirectMessageService {
    /**
     * 获取私信聊天消息列表
     *
     * @param chatCode 私信会话 Code。chat_code与target_id必须传一个
     * @param targetId 目标用户 id，后端会自动创建会话。有此参数之后可不传chat_code参数
     * @param msgId    参考消息 id，不传则查询最新消息
     * @param flag     查询模式，有三种模式可以选择。不传则默认查询最新的消息。
     * @param page     目标页数
     * @param pageSize 当前分页消息数量, 默认 50
     * @since 0.4.0
     */
    @GetExchange("/api/v3/direct-message/list")
    DirectMessageListResponse directMessageList(
            @Nullable @RequestParam(value = "chat_code", required = false) String chatCode,
            @Nullable @RequestParam(value = "target_id", required = false) String targetId,
            @Nullable @RequestParam(value = "msg_id", required = false) String msgId,
            @Nullable @RequestParam(value = "flag", required = false) String flag,
            @Nullable @RequestParam(value = "page", required = false) Integer page,
            @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize);

    /**
     * 获取私信聊天消息详情
     *
     * @param chatCode 私信会话 Code。
     * @param msgId    私聊消息 id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/direct-message/view")
    DirectMessageViewResponse directMessageView(@NotNull @RequestParam("chat_code") String chatCode,
                                                @NotNull @RequestParam("msg_id") String msgId);

    /**
     * 发送私信聊天消息
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/direct-message/create")
    DirectMessageCreateResponse directMessageCreate(
            @NotNull @RequestBody DirectMessageCreateBody body);

    /**
     * 更新私信聊天消息
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/direct-message/update")
    DirectMessageUpdateResponse directMessageUpdate(
            @NotNull @RequestBody DirectMessageUpdateBody body);

    /**
     * 删除私信聊天消息
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/direct-message/delete")
    DirectMessageDeleteResponse directMessageDelete(
            @NotNull @RequestBody DirectMessageDeleteBody body);

    /**
     * 获取频道消息某回应的用户列表
     *
     * @param msgId 消息的 id
     * @param emoji emoji 的 id, 可以为 GuildEmoji 或者 Emoji, 注意：在 get 中，应该进行 urlencode
     * @since 0.4.0
     */
    @GetExchange("/api/v3/direct-message/reaction-list")
    DirectMessageReactionListResponse directMessageReactionList(
            @NotNull @RequestParam("msg_id") String msgId,
            @Nullable @RequestParam(value = "emoji", required = false) String emoji);

    /**
     * 给某个消息添加回应
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/direct-message/add-reaction")
    DirectMessageAddReactionResponse directMessageAddReaction(
            @NotNull @RequestBody DirectMessageAddReactionBody body);

    /**
     * 删除消息的某个回应
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/direct-message/delete-reaction")
    DirectMessageDeleteReactionResponse directMessageDeleteReaction(
            @NotNull @RequestBody DirectMessageDeleteReactionBody body);
}
