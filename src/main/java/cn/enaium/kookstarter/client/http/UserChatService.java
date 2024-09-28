package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.UserChatCreateBody;
import cn.enaium.kookstarter.model.request.UserChatDeleteBody;
import cn.enaium.kookstarter.model.response.UserChatCreateResponse;
import cn.enaium.kookstarter.model.response.UserChatDeleteResponse;
import cn.enaium.kookstarter.model.response.UserChatListResponse;
import cn.enaium.kookstarter.model.response.UserChatViewResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 私信聊天会话接口列表
 *
 * @author Enaium
 */
public interface UserChatService {
    /**
     * 获取私信聊天会话列表
     *
     * @param page     目标页数
     * @param pageSize 每页数据数量
     * @since 0.4.0
     */
    @GetExchange("/api/v3/user-chat/list")
    UserChatListResponse userChatList(
            @Nullable @RequestParam(value = "page", required = false) Integer page,
            @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize);

    /**
     * 获取私信聊天会话详情
     *
     * @param chatCode 私聊会话 Code
     * @since 0.4.0
     */
    @GetExchange("/api/v3/user-chat/view")
    UserChatViewResponse userChatView(@NotNull @RequestParam("chat_code") String chatCode);

    /**
     * 创建私信聊天会话
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/user-chat/create")
    UserChatCreateResponse userChatCreate(@NotNull @RequestBody UserChatCreateBody body);

    /**
     * 删除私信聊天会话
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/user-chat/delete")
    UserChatDeleteResponse userChatDelete(@NotNull @RequestBody UserChatDeleteBody body);
}
