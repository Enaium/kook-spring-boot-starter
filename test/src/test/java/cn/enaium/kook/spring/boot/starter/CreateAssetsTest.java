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

package cn.enaium.kook.spring.boot.starter;

import cn.enaium.kook.spring.boot.starter.api.AssetAPI;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * @author Enaium
 * @since 0.2.0
 */
@SpringBootTest
class CreateAssetsTest {

    private final Logger logger = LogManager.getLogger(CreateAssetsTest.class);
    @Autowired
    private HttpUtil httpUtil;

    @Test
    public void create() {
        logger.info(httpUtil.request(AssetAPI.ASSET_CREATE).field("file", new File(System.getProperty("user.dir"), "README.md")).asString().getBody());
    }
}