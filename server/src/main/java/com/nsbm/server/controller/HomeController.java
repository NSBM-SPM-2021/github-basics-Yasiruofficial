package com.nsbm.server.controller;

import com.nsbm.server.service.impl.UserPermissionServiceImpl;
import com.nsbm.server.service.impl.UserRoleServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class HomeController {

    private UserRoleServiceImpl roleService;
    private UserPermissionServiceImpl permissionService;

    public HomeController(UserRoleServiceImpl roleService, UserPermissionServiceImpl permissionService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
    }


}
