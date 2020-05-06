package com.winsion.net.taskservice;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.winsion.net.bootstrap.core.jpa.EnableDruid;
import com.winsion.net.bootstrap.core.jpa.EnableEntityManagerHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEntityManagerHolder
@EnableTransactionManagement
@ServletComponentScan
public class TaskApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TaskApplication.class)
                .properties("spring.profiles.active=nacos")
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
