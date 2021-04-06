package com.net.winsion.areas.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AreasRestService {
    @GetMapping("/getAllareas")
    String getAllareas();
    @GetMapping("/delbyareaTypeid")
    boolean delbyareaTypeid(String areaTypeid);
}
