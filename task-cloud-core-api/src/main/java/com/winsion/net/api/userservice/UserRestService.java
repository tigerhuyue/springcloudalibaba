package com.winsion.net.api.userservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/users")
public interface UserRestService {
    String getAllUsers();
}
