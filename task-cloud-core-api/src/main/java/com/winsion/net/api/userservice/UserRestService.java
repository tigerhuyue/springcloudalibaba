package com.winsion.net.api.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users/")
public interface UserRestService {
    @GetMapping("/getUsers")
    String getAllUsers();
}
