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
 * 频道相关接口列表
 *
 * @author Enaium
 */
public interface ChannelService {
    /**
     * 获取频道列表
     *
     * @param page     目标页数
     * @param pageSize 每页数据数量
     * @param guildId  服务器 id
     * @param type     频道类型, 1为文字，2为语音, 默认为1
     * @since 0.4.0
     */
    @GetExchange("/api/v3/channel/list")
    ChannelListResponse channelList(
            @Nullable @RequestParam(value = "page", required = false) Integer page,
            @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize,
            @NotNull @RequestParam String guildId,
            @Nullable @RequestParam(value = "type", required = false) Integer type);

    /**
     * 获取频道详情
     *
     * @param targetId     频道 id
     * @param needChildren 是否需要获取子频道。true是 false否 默认为false
     * @since 0.4.0
     */
    @GetExchange("/api/v3/channel/view")
    ChannelViewResponse channelView(@NotNull @RequestParam String targetId,
                                    @Nullable @RequestParam(value = "need_children", required = false) Boolean needChildren);

    /**
     * 创建频道
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/channel/create")
    ChannelCreateResponse channelCreate(@NotNull @RequestBody ChannelCreateBody body);

    /**
     * 编辑频道
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/channel/update")
    ChannelUpdateResponse channelUpdate(@NotNull @RequestBody ChannelUpdateBody body);

    /**
     * 删除频道
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/channel/delete")
    ChannelDeleteResponse channelDelete(@NotNull @RequestBody ChannelDeleteBody body);

    /**
     * 语音频道用户列表
     *
     * @param channelId 频道id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/channel/user-list")
    ChannelUserListResponse channelUserList(@NotNull @RequestParam String channelId);

    /**
     * 语音频道之间移动用户
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/channel/move-user")
    ChannelMoveUserResponse channelMoveUser(@NotNull @RequestBody ChannelMoveUserBody body);

    /**
     * 频道角色权限详情
     *
     * @param channelId 频道 id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/channel-role/index")
    ChannelRoleIndexResponse channelRoleIndex(@NotNull @RequestParam String channelId);

    /**
     * 创建频道角色权限
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/channel-role/create")
    ChannelRoleCreateResponse channelRoleCreate(@NotNull @RequestBody ChannelRoleCreateBody body);

    /**
     * 更新频道角色权限
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/channel-role/update")
    ChannelRoleUpdateResponse channelRoleUpdate(@NotNull @RequestBody ChannelRoleUpdateBody body);

    /**
     * 同步频道角色权限
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/channel-role/sync")
    ChannelRoleSyncResponse channelRoleSync(@NotNull @RequestBody ChannelRoleSyncBody body);

    /**
     * 删除频道角色权限
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/channel-role/delete")
    ChannelRoleDeleteResponse channelRoleDelete(@NotNull @RequestBody ChannelRoleDeleteBody body);
}
