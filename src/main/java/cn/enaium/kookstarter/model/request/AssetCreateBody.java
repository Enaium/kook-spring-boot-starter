package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

/**
 * @param file 目前支持 图片, 视频(.mp4 .mov), 文件
 * @author Enaium
 * @since 0.4.0
 */
public record AssetCreateBody(@NotNull @JsonProperty("file") Object file) {
}
