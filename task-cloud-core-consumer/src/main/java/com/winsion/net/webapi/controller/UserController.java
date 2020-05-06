package com.winsion.net.webapi.controller;

import com.winsion.net.api.taskservices.Worktypeservice;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference
    Worktypeservice worktypeservice;


    @GetMapping("/getall")
    public String echo(String message) {
        return worktypeservice.getAll();
    }


}
