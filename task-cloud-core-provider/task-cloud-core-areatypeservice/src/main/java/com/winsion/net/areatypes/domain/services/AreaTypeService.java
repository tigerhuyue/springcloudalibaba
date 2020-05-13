package com.winsion.net.areatypes.domain.services;

import com.alibaba.fastjson.JSON;

import com.winsion.net.api.areasercice.AreaTypeRestService;
import com.winsion.net.areatypes.domain.entity.Areatypes;
import com.winsion.net.areatypes.domain.repository.AreasTypeRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AreaTypeService implements AreaTypeRestService {

    @Autowired
    AreasTypeRepository areasTypeRepository;



    @Override
    public String getAllareatypes() {
        List<Areatypes> areatypesList=areasTypeRepository.findAll();
        return JSON.toJSONString(areatypesList);
    }
}
