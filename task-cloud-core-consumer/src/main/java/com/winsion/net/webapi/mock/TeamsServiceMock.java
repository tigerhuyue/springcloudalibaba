package com.winsion.net.webapi.mock;

import com.winsion.net.api.taskservices.TeamService;

public class TeamsServiceMock  implements TeamService {
    @Override
    public String getAllTeaams() {
        return "你的数据异常了";
    }
}
