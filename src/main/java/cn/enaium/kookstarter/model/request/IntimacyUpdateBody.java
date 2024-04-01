package cn.enaium.kookstarter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @param userId     用户 id
 * @param score      亲密度，0-2200
 * @param socialInfo 机器人与用户的社交信息，500 字以内
 * @param imgId      形象图片 ID
 * @author Enaium
 * @since 0.4.0
 */
public record IntimacyUpdateBody(@NotNull @JsonProperty("user_id") String userId,
                                 @Nullable @JsonProperty("score") Integer score,
                                 @Nullable @JsonProperty("social_info") String socialInfo,
                                 @Nullable @JsonProperty("img_id") String imgId) {
}
