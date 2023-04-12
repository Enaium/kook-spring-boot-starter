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

package cn.enaium.kookstarter.configuration;

import cn.enaium.kookstarter.client.http.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author Enaium
 * @since 0.3.0
 */
@Configuration
public class WebClientConfiguration {

    private final KookConfiguration configuration;

    public WebClientConfiguration(KookConfiguration configuration) {
        this.configuration = configuration;
    }

    @Bean
    WebClient webClient() {
        return WebClient.builder().baseUrl("https://www.kookapp.cn/api/v3/").defaultHeader(HttpHeaders.AUTHORIZATION, "Bot " + configuration.getToken()).build();
    }

    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory(WebClient webClient) {
        return HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
    }

    /**
     * @since 0.3.0
     */
    @Bean
    AssetService AssetService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(AssetService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    BadgeService BadgeService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(BadgeService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    BlackListService BlackListService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(BlackListService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    ChannelService ChannelService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(ChannelService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    ChannelUserService ChannelUserService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(ChannelUserService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    DirectMessageService DirectMessageService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(DirectMessageService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    FriendService FriendService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(FriendService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    GameService GameService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(GameService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    GatewayService GatewayService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(GatewayService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    GuildEmojiService GuildEmojiService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(GuildEmojiService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    GuildRoleService GuildRoleService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(GuildRoleService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    GuildService GuildService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(GuildService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    IntimacyService IntimacyService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(IntimacyService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    InviteService InviteService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(InviteService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    MessageService MessageService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(MessageService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    UserChatService UserChatService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(UserChatService.class);
    }

    /**
     * @since 0.3.0
     */
    @Bean
    UserService UserService(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(UserService.class);
    }
}
