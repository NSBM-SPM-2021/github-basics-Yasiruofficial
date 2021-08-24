package com.nsbm.server.controller;

import com.nsbm.server.service.impl.UserUserPermissionServiceImpl;
import com.nsbm.server.service.impl.UserUserRoleServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class HomeController {

    private UserUserRoleServiceImpl roleService;
    private UserUserPermissionServiceImpl permissionService;

    public HomeController(UserUserRoleServiceImpl roleService, UserUserPermissionServiceImpl permissionService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
    }


}
