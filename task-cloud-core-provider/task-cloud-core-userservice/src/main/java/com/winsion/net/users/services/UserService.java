package com.winsion.net.users.services;

import com.alibaba.fastjson.JSON;
import com.winsion.net.api.userservice.UserRestService;
import com.winsion.net.users.domain.entity.Users;
import com.winsion.net.users.domain.repository.UsersRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService implements UserRestService {
    @Autowired
    UsersRepository usersRepository;


    @Override
    public String getAllUsers() {
        List<Users> list=usersRepository.findAll();
        return JSON.toJSONString(list);
    }
}
