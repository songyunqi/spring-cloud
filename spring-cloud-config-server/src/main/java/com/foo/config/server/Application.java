package com.foo.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Created by on 16/4/28.
 */
@SpringBootApplication
@EnableConfigServer
@RefreshScope
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
