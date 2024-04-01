package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.Oauth2TokenBody;
import cn.enaium.kookstarter.model.response.Oauth2TokenResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

/**
 * OAuth2.0相关接口
 *
 * @author Enaium
 */
public interface OauthService {
    /**
     * 获取AccessToken
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/oauth2/token")
    Oauth2TokenResponse oauth2Token(@NotNull @RequestBody Oauth2TokenBody body);
}
