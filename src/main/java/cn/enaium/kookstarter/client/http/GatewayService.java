package cn.enaium.kookstarter.client.http;

import cn.enaium.kookstarter.model.response.GatewayIndexResponse;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

/**
 * Gateway
 *
 * @author Enaium
 */
public interface GatewayService {
    /**
     * 获取网关连接地址
     *
     * @param compress 下发数据是否压缩，默认为1,代表压缩
     * @since 0.4.0
     */
    @GetExchange("/api/v3/gateway/index")
    GatewayIndexResponse gatewayIndex(
            @Nullable @RequestParam(value = "compress", required = false) Integer compress);
}
