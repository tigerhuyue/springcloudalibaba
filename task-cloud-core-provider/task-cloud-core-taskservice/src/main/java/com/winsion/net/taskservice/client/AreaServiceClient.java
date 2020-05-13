package com.winsion.net.taskservice.client;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import com.winsion.net.api.areasercice.AreasRestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class AreaServiceClient {

    @Autowired
    @Lazy
    private FeignRestService feignRestService;

    public  String getAllAreas()
    {
       return feignRestService.getAllareas();

    }

    @FeignClient("task-cloud-core-areaservice-provider")
    public interface FeignRestService {
        @GetMapping("/getAllareas")
        String getAllareas();
    }

//    @Reference
//    AreasRestService restService;
//
//    public String getAllAreas() {
//        return restService.getAllareas();
//
//    }

}
