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

package cn.enaium.kookstarter;

import cn.enaium.kookstarter.client.socket.DefaultClient;
import cn.enaium.kookstarter.configuration.KookConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Enaium
 */
@EnableConfigurationProperties(KookConfiguration.class)
@ComponentScan("cn.enaium.kookstarter")
public class KookStarter {

    private static final Logger LOGGER = LoggerFactory.getLogger(KookStarter.class);

    private final DefaultClient defaultClient;

    public KookStarter(DefaultClient defaultClient) {
        this.defaultClient = defaultClient;
    }

    @Bean
    public CommandLineRunner run() {

        LOGGER.info("KookStarter is starting...");

        return args -> defaultClient.connect();
    }
}
