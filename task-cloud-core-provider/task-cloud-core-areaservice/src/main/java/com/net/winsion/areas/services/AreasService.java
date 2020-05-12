package com.net.winsion.areas.services;

import com.alibaba.fastjson.JSON;
import com.net.winsion.areas.domain.entity.Areas;
import com.net.winsion.areas.domain.repository.AreasRepository;
import com.winsion.net.api.areasercice.AreasRestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class AreasService implements AreasRestService {

    @Autowired
    AreasRepository areasRepository;

    @Override
    public String getAllareas() {
        List<Areas> list=areasRepository.findAll();
        String name=list.get(0).getAreaname();
        return JSON.toJSONString(list);
    }
}


