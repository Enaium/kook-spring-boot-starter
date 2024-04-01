package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param grantType    授权类型, 目前仅支持 authorization_code
 * @param clientId     当前 OAuth 客户端的 client_id, 可在机器人详情页查看
 * @param clientSecret 当前 OAuth 客户端的 client_secret, 可在机器人详情页查看
 * @param code         用户授权成功回调后获得的 authorization_code
 * @param redirectUri  本次授权所使用的回调地址 (需为机器人 OAuth 配置白名单中的地址)
 * @author Enaium
 * @since 0.4.0
 */
public record Th2TokenBody(@NotNull @JsonProperty("grant_type") String grantType,
                           @NotNull @JsonProperty("client_id") String clientId,
                           @NotNull @JsonProperty("client_secret") String clientSecret,
                           @NotNull @JsonProperty("code") String code,
                           @NotNull @JsonProperty("redirect_uri") String redirectUri) {
}
