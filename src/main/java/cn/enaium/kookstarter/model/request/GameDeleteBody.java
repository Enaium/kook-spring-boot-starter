package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param id 主键 id
 * @author Enaium
 * @since 0.4.0
 */
public record GameDeleteBody(@NotNull @JsonProperty("id") Integer id) {
}
