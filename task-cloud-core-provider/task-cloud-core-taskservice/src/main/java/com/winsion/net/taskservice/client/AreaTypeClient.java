package com.winsion.net.taskservice.client;

import com.winsion.net.api.areasercice.AreaTypeRestService;
import com.winsion.net.api.userservice.UserRestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class AreaTypeClient {

    @Reference
    AreaTypeRestService areaTypeRestService;
    public String getAllAreatypes() {
        return areaTypeRestService.getAllareatypes();
    }
}
