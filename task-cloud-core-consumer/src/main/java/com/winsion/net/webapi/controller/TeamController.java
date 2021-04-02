package com.winsion.net.webapi.controller;

import com.winsion.net.api.taskservices.TeamService;
import com.winsion.net.api.taskservices.Worktypeservice;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Reference(mock = "com.winsion.net.webapi.mock.TeamsServiceMock")
    TeamService teamService;

    @GetMapping("/getallTeams")
    public String getareas(String message) {
        return teamService.getAllTeaams();
    }
}
