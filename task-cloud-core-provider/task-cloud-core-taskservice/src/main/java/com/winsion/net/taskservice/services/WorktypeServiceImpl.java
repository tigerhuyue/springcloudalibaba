package com.winsion.net.taskservice.services;

import com.alibaba.fastjson.JSON;
import com.winsion.net.api.areasercice.AreaTypeRestService;
import com.winsion.net.api.taskservices.Worktypeservice;
import com.winsion.net.taskservice.client.AreaServiceClient;
import com.winsion.net.taskservice.client.AreaTypeClient;
import com.winsion.net.taskservice.client.UserServiceClient;
import com.winsion.net.taskservice.domain.enttiy.Areas;
import com.winsion.net.taskservice.domain.repository.AreasRepository;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Component
public class WorktypeServiceImpl implements Worktypeservice {
    @Autowired
    AreasRepository areasRepository;

    @Autowired
    AreaServiceClient areaServiceClient;

    @Autowired
    UserServiceClient userServiceClient;

    @Autowired
    AreaTypeClient areaTypeClient;

    private static final String SUCCESS = "SUCCESS";

    @Override
    public String getareas() {

        return areaServiceClient.getAllAreas();

    }

    @Override
    public String getareas2() {

        return areaServiceClient.geAllarea2();
    }


    @Override
    public String getUsers() {
        return userServiceClient.getAllUsers();
    }

    @Override
    public String getareatypes() {
        return areaTypeClient.getAllAreatypes();
    }

    @Override
    public String updateTask() {
        return null;
    }


    @GlobalTransactional(timeoutMills = 30000)
    @Override
    public String DelteAreas(
            String areatypeid

    ) {

        boolean flag = areaTypeClient.deleteByAreatypeid(areatypeid);
        if (!flag) {
            throw new RuntimeException("mock error");

        }

        flag = areaServiceClient.delbyareaTypeid(areatypeid);
        if (!flag) {
            throw new RuntimeException("mock error");

        }
        return SUCCESS;
    }


    //实现一个异步执行
    @Override
    public CompletableFuture<String> sayHello(String name) {
        RpcContext savedContext = RpcContext.getContext();

        return CompletableFuture.supplyAsync(() -> {
            System.out.println(savedContext.getAttachment("consumer-key1"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "async response from provider.";
        });
        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
    }


}
