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

package cn.enaium.kook.spring.boot.starter.util;

import java.util.concurrent.TimeUnit;

/**
 * @author Enaium
 * @since 0.1.0
 */
public class TimeUtil {

    private long lastMS = -1L;

    public boolean delay(double nextDelay) {
        return (double) (System.currentTimeMillis() - this.lastMS) >= nextDelay;
    }

    public void reset() {
        this.lastMS = System.currentTimeMillis();
    }

    public long getLastMS() {
        return lastMS;
    }

    public static void time(TimeUnit timeUnit, long timeout, Runnable runnable) {
        ASyncUtil.execute(() -> {
            try {
                timeUnit.sleep(timeout);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            runnable.run();
        });
    }
}