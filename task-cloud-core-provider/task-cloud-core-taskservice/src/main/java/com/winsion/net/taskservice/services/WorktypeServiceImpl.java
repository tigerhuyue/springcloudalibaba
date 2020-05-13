package com.winsion.net.taskservice.services;

import com.alibaba.fastjson.JSON;
import com.winsion.net.api.areasercice.AreaTypeRestService;
import com.winsion.net.api.taskservices.Worktypeservice;
import com.winsion.net.taskservice.client.AreaServiceClient;
import com.winsion.net.taskservice.client.AreaTypeClient;
import com.winsion.net.taskservice.client.UserServiceClient;
import com.winsion.net.taskservice.domain.enttiy.Areas;
import com.winsion.net.taskservice.domain.repository.AreasRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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


    @Override
    public  String getareas()
    {

        return  areaServiceClient.getAllAreas();

    }

    @Override
    public  String getareas2()
    {

        return  areaServiceClient.geAllarea2();

    }
    @Override
    public  String getUsers()
    {
        return  userServiceClient.getAllUsers();
    }

    @Override
    public String getareatypes() {
        return areaTypeClient.getAllAreatypes();
    }


}
