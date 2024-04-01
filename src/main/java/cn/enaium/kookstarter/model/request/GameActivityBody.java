package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param id        游戏 id
 * @param dataType  请求数据类型 1游戏 2音乐
 * @param software  软件名，枚举值：['cloudmusic'、'qqmusic'、'kugou']，默认为'cloudmusic'
 * @param singer    歌手名，data_type=2 时必传
 * @param musicName 歌曲名，data_type=2 时必传
 * @author Enaium
 * @since 0.4.0
 */
public record GameActivityBody(@NotNull @JsonProperty("id") Integer id,
                               @NotNull @JsonProperty("data_type") Integer dataType,
                               @Nullable @JsonProperty("software") String software,
                               @Nullable @JsonProperty("singer") String singer,
                               @Nullable @JsonProperty("music_name") String musicName) {
}
