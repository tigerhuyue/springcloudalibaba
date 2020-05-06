package com.winsion.net.webapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication//(scanBasePackages ="com.winsion.net.webapi.*")
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .properties("spring.profiles.active=nacos")
                .run(args);
    }
}
