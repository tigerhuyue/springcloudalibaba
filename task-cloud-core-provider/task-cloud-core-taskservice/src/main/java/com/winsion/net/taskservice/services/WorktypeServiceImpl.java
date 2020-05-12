package com.winsion.net.taskservice.services;

import com.alibaba.fastjson.JSON;
import com.winsion.net.api.taskservices.Worktypeservice;
import com.winsion.net.taskservice.domain.enttiy.Areas;
import com.winsion.net.taskservice.domain.repository.AreasRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
//@Component
public class WorktypeServiceImpl implements Worktypeservice {
    @Autowired
    AreasRepository areasRepository;

    @Override
    public  String getAll()
    {
        List<Areas>list=areasRepository.findAll();
        String name=list.get(0).getAreaname();
        return JSON.toJSONString(list);
    }
}
