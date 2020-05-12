package com.winsion.net.api.areasercice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/areas")
public interface  AreasRestService {
     @GetMapping("/getAllareas")
     String getAllareas();
}
