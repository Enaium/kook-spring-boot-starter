package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param dataType 请求数据类型 1游戏 2音乐
 * @author Enaium
 * @since 0.4.0
 */
public record GameDeleteActivityBody(@NotNull @JsonProperty("data_type") Integer dataType) {
}
