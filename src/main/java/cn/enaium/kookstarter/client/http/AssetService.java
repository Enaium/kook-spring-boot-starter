package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.request.AssetCreateBody;
import cn.enaium.kookstarter.model.response.AssetCreateResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

/**
 * 媒体模块
 *
 * @author Enaium
 */
public interface AssetService {
    /**
     * 上传媒体文件
     *
     * @param body 请求体
     * @since 0.4.0
     */
    @PostExchange("/api/v3/asset/create")
    AssetCreateResponse assetCreate(@NotNull @RequestBody AssetCreateBody body);
}
