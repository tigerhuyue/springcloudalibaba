package com.winsion.net.webapi.controller;

import com.winsion.net.api.taskservices.Worktypeservice;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    Worktypeservice worktypeservice;


    @GetMapping("/getareas")
    public String getareas(String message) {
        return worktypeservice.getareas();
    }

    @GetMapping("/getareas2")
    public String getareas() {
        return worktypeservice.getareas2();
    }
    @GetMapping("/getusers")
    public String getusers() {
        return worktypeservice.getUsers();
    }
    @GetMapping("/getareatypes")
    public String getareatypes() {
        return worktypeservice.getareatypes();
    }

}
