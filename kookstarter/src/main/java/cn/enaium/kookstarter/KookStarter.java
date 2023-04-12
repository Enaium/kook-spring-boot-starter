/*
 * Copyright 2023 Enaium
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

import cn.enaium.kookstarter.client.socket.Client;
import cn.enaium.kookstarter.configuration.KookConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Enaium
 * @since 0.1.0
 */
@ComponentScan
@EnableConfigurationProperties(KookConfiguration.class)
public class KookStarter {

    public static final Logger LOGGER = LogManager.getLogger(KookStarter.class);


    private final Client client;

    public KookStarter(Client client) {
        this.client = client;
    }


    @Bean
    public CommandLineRunner run() {
        return args -> {
            LOGGER.info("""
                    \n
                    _|    _|    _|_|      _|_|    _|    _|    _|_|_|  _|_|_|_|_|    _|_|    _|_|_|    _|_|_|_|_|  _|_|_|_|  _|_|_|   \s
                    _|  _|    _|    _|  _|    _|  _|  _|    _|            _|      _|    _|  _|    _|      _|      _|        _|    _| \s
                    _|_|      _|    _|  _|    _|  _|_|        _|_|        _|      _|_|_|_|  _|_|_|        _|      _|_|_|    _|_|_|   \s
                    _|  _|    _|    _|  _|    _|  _|  _|          _|      _|      _|    _|  _|    _|      _|      _|        _|    _| \s
                    _|    _|    _|_|      _|_|    _|    _|  _|_|_|        _|      _|    _|  _|    _|      _|      _|_|_|_|  _|    _| \s
                    """);
            client.start();
        };
    }
}
