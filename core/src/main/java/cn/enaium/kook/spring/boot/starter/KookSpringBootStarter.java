package cn.enaium.kook.spring.boot.starter;

import cn.enaium.kook.spring.boot.starter.connect.WebSocketClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * @author Enaium
 */
@ComponentScan
public class KookSpringBootStarter {

    private final Logger logger = LogManager.getLogger(KookSpringBootStarter.class);

    @Autowired
    private WebSocketClient webSocketClient;

    @Bean
    private CommandLineRunner run() {
        return args -> {
            logger.info("""
                     \s
                      _  __           _     ____  _             _           \s
                     | |/ /___   ___ | | __/ ___|| |_ __ _ _ __| |_ ___ _ __\s
                     | ' // _ \\ / _ \\| |/ /\\___ \\| __/ _` | '__| __/ _ \\ '__|
                     | . \\ (_) | (_) |   <  ___) | || (_| | |  | ||  __/ |  \s
                     |_|\\_\\___/ \\___/|_|\\_\\|____/ \\__\\__,_|_|   \\__\\___|_|  \s
                    """);
            webSocketClient.start();
        };
    }
}
