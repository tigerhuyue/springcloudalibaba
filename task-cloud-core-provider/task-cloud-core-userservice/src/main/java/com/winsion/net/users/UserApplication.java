package com.winsion.net.users;

import com.winsion.net.bootstrap.core.jpa.EnableEntityManagerHolder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEntityManagerHolder
@EnableTransactionManagement
public class UserApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class)
                .properties("spring.profiles.active=nacos").run(args);
    }

}
