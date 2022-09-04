package cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message;

import cn.enaium.kook.spring.boot.starter.annotation.event.Listener;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.TextMessageExtra;

import java.util.Map;

/**
 * 动作消息,可能并非正式命名
 * 详细报文可见 <a href="https://github.com/kaiheila/api-docs/issues/150">kook/api-docs</a>
 * @author CNLuminous
 * @since 0.1.4
 */
@Listener
public class ImageAnimationMessage extends TextMessageExtra {
    public static final String TYPE = "12";

    public Map<Object, Object> kmarkdown;
}
