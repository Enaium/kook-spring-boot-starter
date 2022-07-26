package cn.enaium.kook.spring.boot.starter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Enaium
 */
@Component
@ConfigurationProperties(value = "kook")
public class KookConfiguration {
    /**
     * 机器人的Token
     */
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
