package com.winsion.net.users;

import com.winsion.net.bootstrap.core.jpa.EnableEntityManagerHolder;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEntityManagerHolder
public class UserApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserApplication.class)
                .properties("spring.profiles.active=nacos")
                .web(WebApplicationType.NONE)
                .run(args);
    }

}
