package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param name 名称
 * @param icon 图标
 * @author Enaium
 * @since 0.4.0
 */
public record GameCreateBody(@NotNull @JsonProperty("name") String name,
                             @Nullable @JsonProperty("icon") String icon) {
}
