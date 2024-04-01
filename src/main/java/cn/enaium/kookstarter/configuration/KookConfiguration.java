package cn.enaium.kookstarter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Kook配置
 *
 * @author Enaium
 */
@ConfigurationProperties(prefix = "kook")
public class KookConfiguration {
    /**
     * 机器人的Token
     */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
