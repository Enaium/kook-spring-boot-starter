package cn.enaium.kookstarter.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public record GameUpdateResponse(@JsonProperty("code") Integer code,
                                 @JsonProperty("message") String message, @JsonProperty("data") Data data) {
    public record Data(@JsonProperty("id") Integer id, @JsonProperty("name") String name,
                       @JsonProperty("type") Integer type, @JsonProperty("options") String options,
                       @JsonProperty("kmhook_admin") Boolean kmhookAdmin, @JsonProperty("icon") String icon,
                       @JsonProperty("process_name") List<Object> processName,
                       @JsonProperty("product_name") List<Object> productName) {
    }
}
