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
 * 服务器角色权限相关接口列表
 *
 * @author Enaium
 */
public interface GuildRoleService {
    /**
     * 获取服务器角色列表
     *
     * @param guildId  服务器 id
     * @param page     目标页数
     * @param pageSize 每页数据数量
     * @since 0.4.0
     */
    @GetExchange("/api/v3/guild-role/list")
    GuildRoleListResponse guildRoleList(@NotNull @RequestParam("guild_id") String guildId,
                                        @Nullable @RequestParam(value = "page", required = false) Integer page,
                                        @Nullable @RequestParam(value = "page_size", required = false) Integer pageSize);

    /**
     * 创建服务器角色
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-role/create")
    GuildRoleCreateResponse guildRoleCreate(@NotNull @RequestBody GuildRoleCreateBody body);

    /**
     * 更新服务器角色
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-role/update")
    GuildRoleUpdateResponse guildRoleUpdate(@NotNull @RequestBody GuildRoleUpdateBody body);

    /**
     * 删除服务器角色
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-role/delete")
    GuildRoleDeleteResponse guildRoleDelete(@NotNull @RequestBody GuildRoleDeleteBody body);

    /**
     * 赋予用户角色
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-role/grant")
    GuildRoleGrantResponse guildRoleGrant(@NotNull @RequestBody GuildRoleGrantBody body);

    /**
     * 删除用户角色
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/guild-role/revoke")
    GuildRoleRevokeResponse guildRoleRevoke(@NotNull @RequestBody GuildRoleRevokeBody body);
}
