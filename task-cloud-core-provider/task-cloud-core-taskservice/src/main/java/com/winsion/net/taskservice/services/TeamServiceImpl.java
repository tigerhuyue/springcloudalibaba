package com.winsion.net.taskservice.services;

import com.winsion.net.api.taskservices.TeamService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;


@Service(executes = 100,loadbalance = "leastactive",actives = 100)  //最大调用并发数100，负载均衡策略leastactive-调用并发数最小的
public class TeamServiceImpl implements TeamService {
    @Override
    public String getAllTeaams() {
        return null;
    }
}
