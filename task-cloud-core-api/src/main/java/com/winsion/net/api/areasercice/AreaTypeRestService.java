package com.winsion.net.api.areasercice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AreaTypeRestService {
      @GetMapping("/getAllareatypes")
     String getAllareatypes();
    @GetMapping("/delByAreaTypeid")
    boolean delByAreaTypeid(String areaTypeid);
}
