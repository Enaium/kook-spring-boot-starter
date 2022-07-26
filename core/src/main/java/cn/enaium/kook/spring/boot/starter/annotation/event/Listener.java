/*
 * Copyright 2022 Enaium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.enaium.kook.spring.boot.starter.annotation.event;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在类上添加注解表示这个类是一个监听器
 * <p>
 * 类必须继承{@link cn.enaium.kook.spring.boot.starter.model.sign.data.extra.SystemMessageExtra}类
 * <p>
 * 或{@link cn.enaium.kook.spring.boot.starter.model.sign.data.extra.TextMessageExtra}类
 * <p>
 * 必须在监听器类中声明一个静态变量,类型为{@link String},名称为<b>TYPE</b>
 * <p>
 * 比如
 * <pre>{@code public static final String TYPE = "added_channel"; }</pre>
 *
 * @author Enaium
 * @since 0.1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Listener {
}
