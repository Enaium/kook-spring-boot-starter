package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.IntimacyUpdateBody;
import cn.enaium.kookstarter.model.response.IntimacyIndexResponse;
import cn.enaium.kookstarter.model.response.IntimacyUpdateResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 亲密度相关接口列表
 *
 * @author Enaium
 */
public interface IntimacyService {
    /**
     * 获取用户亲密度
     *
     * @param userId 用户的 id
     * @since 0.4.0
     */
    @GetExchange("/api/v3/intimacy/index")
    IntimacyIndexResponse intimacyIndex(@NotNull @RequestParam("user_id") String userId);

    /**
     * 更新用户亲密度
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/intimacy/update")
    IntimacyUpdateResponse intimacyUpdate(@NotNull @RequestBody IntimacyUpdateBody body);
}
