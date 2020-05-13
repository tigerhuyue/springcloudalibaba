package com.winsion.net.taskservice.client;

import com.winsion.net.api.userservice.UserRestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class UserServiceClient {
    @Reference
    UserRestService userRestService;

    public String getAllUsers() {
        return userRestService.getAllUsers();
    }



}
