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
 * 服务器相关接口列表
 *
 * @author Enaium
 */
public interface GuildService {
    /**
     * 获取当前用户加入的服务器列表
     *
     * @param page     目标页数
     * @param pageSize 每页数据数量
     * @param sort     代表排序的字段, 比如-id 代表 id 按 DESC 排序，id 代表 id 按 ASC 排序。不一定有, 如果有，接口中会声明支持的排序字段。
     * @since 0.4.0
     */
    @GetExchange("/api/v3/guild/list")
    GuildListResponse guildList(
            @Nullable @RequestParam(value = "page", required = false) Integer page,
            @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize,
            @Nullable @RequestParam(value = "sort", required = false) String sort);

    /**
     * 获取服务器详情
     *
     * @param guildId 服务器 id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/guild/view")
    GuildViewResponse guildView(@NotNull @RequestParam("guild_id") String guildId);

    /**
     * 获取服务器中的用户列表
     *
     * @param guildId        服务器 id
     * @param channelId      频道 id
     * @param search         搜索关键字，在用户名或昵称中搜索
     * @param roleId         角色 ID，获取特定角色的用户列表
     * @param mobileVerified 只能为0或1，0是未认证，1是已认证
     * @param activeTime     根据活跃时间排序，0是顺序排列，1是倒序排列
     * @param joinedAt       根据加入时间排序，0是顺序排列，1是倒序排列
     * @param page           目标页数
     * @param pageSize       每页数据数量
     * @param filterUserId   获取指定 id 所属用户的信息
     * @since 0.4.0
     */
    @GetExchange("/api/v3/guild/user-list")
    GuildUserListResponse guildUserList(@NotNull @RequestParam("guild_id") String guildId,
                                        @Nullable @RequestParam(value = "channel_id", required = false) String channelId,
                                        @Nullable @RequestParam(value = "search", required = false) String search,
                                        @Nullable @RequestParam(value = "role_id", required = false) Integer roleId,
                                        @Nullable @RequestParam(value = "mobile_verified", required = false) Integer mobileVerified,
                                        @Nullable @RequestParam(value = "active_time", required = false) Integer activeTime,
                                        @Nullable @RequestParam(value = "joined_at", required = false) Integer joinedAt,
                                        @Nullable @RequestParam(value = "page", required = false) Integer page,
                                        @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize,
                                        @Nullable @RequestParam(value = "filter_user_id", required = false) String filterUserId);

    /**
     * 修改服务器中用户的昵称
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild/nickname")
    GuildNicknameResponse guildNickname(@NotNull @RequestBody GuildNicknameBody body);

    /**
     * 离开服务器
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild/leave")
    GuildLeaveResponse guildLeave(@NotNull @RequestBody GuildLeaveBody body);

    /**
     * 踢出服务器
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild/kickout")
    GuildKickoutResponse guildKickout(@NotNull @RequestBody GuildKickoutBody body);

    /**
     * 服务器静音闭麦列表
     *
     * @param guildId    服务器 id
     * @param returnType 返回格式，建议为"detail", 其他情况仅作为兼容
     * @since 0.4.0
     */
    @GetExchange("/api/v3/guild-mute/list")
    GuildMuteListResponse guildMuteList(@NotNull @RequestParam("guild_id") String guildId,
                                        @Nullable @RequestParam(value = "return_type", required = false) String returnType);

    /**
     * 添加服务器静音或闭麦
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-mute/create")
    GuildMuteCreateResponse guildMuteCreate(@NotNull @RequestBody GuildMuteCreateBody body);

    /**
     * 删除服务器静音或闭麦
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-mute/delete")
    GuildMuteDeleteResponse guildMuteDelete(@NotNull @RequestBody GuildMuteDeleteBody body);

    /**
     * 服务器助力历史
     *
     * @param guildId   服务器 id
     * @param startTime unix 时间戳，时间范围的开始时间
     * @param endTime   unix 时间戳，时间范围的结束时间
     * @since 0.4.0
     */
    @GetExchange("/api/v3/guild-boost/history")
    GuildBoostHistoryResponse guildBoostHistory(@NotNull @RequestParam("guild_id") String guildId,
                                                @Nullable @RequestParam(value = "start_time", required = false) Integer startTime,
                                                @Nullable @RequestParam(value = "end_time", required = false) Integer endTime);
}
