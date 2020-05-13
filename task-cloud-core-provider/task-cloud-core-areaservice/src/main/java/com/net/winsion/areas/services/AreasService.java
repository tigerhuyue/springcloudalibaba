package com.net.winsion.areas.services;

import com.alibaba.fastjson.JSON;
import com.net.winsion.areas.api.AreasRestService;
import com.net.winsion.areas.domain.entity.Areas;
import com.net.winsion.areas.domain.repository.AreasRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
@Service
public class AreasService implements AreasRestService {

    @Autowired
    AreasRepository areasRepository;

    @Override
    public String getAllareas() {
        List<Areas> list=areasRepository.findAll();

        return JSON.toJSONString(list);
    }
}


