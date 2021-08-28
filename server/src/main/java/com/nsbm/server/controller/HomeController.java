package com.nsbm.server.controller;

import com.nsbm.server.model.GrantedAuthority;
import com.nsbm.server.service.impl.GrantedAuthorityServiceImpl;
import com.nsbm.server.service.impl.UserPermissionServiceImpl;
import com.nsbm.server.service.impl.UserRoleServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class HomeController {

    private UserRoleServiceImpl roleService;
    private UserPermissionServiceImpl permissionService;
    private GrantedAuthorityServiceImpl grantedAuthorityService;

    public HomeController(UserRoleServiceImpl roleService, UserPermissionServiceImpl permissionService, GrantedAuthorityServiceImpl grantedAuthorityService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.grantedAuthorityService = grantedAuthorityService;
    }

    @GetMapping("/ga")
    public List<GrantedAuthority> getGA() {

        return grantedAuthorityService.findAll();
    }


}
