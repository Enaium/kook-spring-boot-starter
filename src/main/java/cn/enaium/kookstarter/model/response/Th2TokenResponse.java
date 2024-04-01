package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record Th2TokenResponse(@JsonProperty("access_token") String accessToken,
                               @JsonProperty("expires_in") Integer expiresIn,
                               @JsonProperty("token_type") String tokenType,
                               @JsonProperty("scope") String scope) {
}
