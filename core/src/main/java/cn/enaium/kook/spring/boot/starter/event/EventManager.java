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

package cn.enaium.kook.spring.boot.starter.event;

import cn.enaium.kook.spring.boot.starter.annotation.event.Event;
import cn.enaium.kook.spring.boot.starter.annotation.event.Listener;
import cn.enaium.kook.spring.boot.starter.annotation.event.Register;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Enaium
 * @since 0.1.0
 */
@Component
public class EventManager {
    public final Map<String, Class<?>> listener = new HashMap<>();

    /**
     * 键为事件类型 值为目标
     */
    public final Map<Class<?>, CopyOnWriteArrayList<Target>> event = new HashMap<>();

    public EventManager(ApplicationContext applicationContext) {
        //添加所有事件
        for (Object value : applicationContext.getBeansWithAnnotation(Listener.class).values()) {
            Class<?> klass = value.getClass();
            try {
                listener.put(String.valueOf(klass.getField("TYPE").get(null)), klass);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        //注册所有事件
        for (Object value : applicationContext.getBeansWithAnnotation(Register.class).values()) {
            register(value);
        }
    }

    public void register(Object o) {
        Class<?> type = o.getClass();

        for (Method method : type.getDeclaredMethods()) {
            if (method.getParameterTypes().length == 1 && method.isAnnotationPresent(Event.class)) {
                method.setAccessible(true);
                Class<?> event = method.getAnnotation(Event.class).value();

                Target target = new Target(o, method, method.getAnnotation(Event.class).priority());

                if (this.event.containsKey(event)) {
                    if (!this.event.get(event).contains(target)) {
                        this.event.get(event).add(target);
                    }
                } else {
                    this.event.put(event, new CopyOnWriteArrayList<>(Collections.singletonList(target)));
                }
            }
        }
        event.values().forEach(it -> it.sort((Comparator.comparingInt(Target::getPriority))));
    }

    /**
     * 发布事件
     * @param o 注册类的实例化
     * @param klass 监听器
     */
    public void publish(Object o, Class<?> klass) {
        CopyOnWriteArrayList<Target> targets = event.get(klass);

        if (targets == null) {
            return;
        }

        targets.forEach(event -> {
            try {
                event.getMethod().invoke(event.getInstance(), o);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
