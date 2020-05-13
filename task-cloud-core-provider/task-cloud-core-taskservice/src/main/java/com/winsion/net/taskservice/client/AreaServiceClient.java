package com.winsion.net.taskservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class AreaServiceClient {

    @Autowired
    @Lazy
    private FeignRestService feignRestService;

    @Autowired
    private RestTemplate restTemplate;


    public  String getAllAreas()
    {
       return feignRestService.getAllareas();

    }

    /**
     * 通过网关获取
     * @return
     */
    public String geAllarea2()
    {

        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://service-gateway:18085/area/getAllareas",
                        HttpMethod.GET,
                        null, String.class);
        return restExchange.getBody();

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
