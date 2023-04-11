package cn.enaium.kookstarter;

import cn.enaium.kookstarter.client.http.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.Map;

@SpringBootTest(classes = KookStarter.class)
class KookStarterTests {

    @Autowired
    MessageService messageService;


    @Test
    void contextLoads() {
        WebClient client = WebClient.builder().baseUrl("http://localhost:8080/").build();
        final var build = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        final var block = build.createClient(MessageService.class).postMessageCreate(Map.of("key", "value")).block();
        System.out.println(block);
    }

}
