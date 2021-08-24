package com.nsbm.server.controller;

import com.nsbm.server.model.*;
import com.nsbm.server.service.impl.EmployeeServiceImpl;
import com.nsbm.server.service.impl.GrantedAuthorityServiceImpl;
import com.nsbm.server.service.impl.UserUserPermissionServiceImpl;
import com.nsbm.server.service.impl.UserUserRoleServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController()
@RequestMapping("api")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;
    private UserUserRoleServiceImpl roleService;
    private UserUserPermissionServiceImpl permissionService;
    private GrantedAuthorityServiceImpl grantedAuthorityService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmployeeController(EmployeeServiceImpl employeeService,
                              UserUserRoleServiceImpl roleService,
                              UserUserPermissionServiceImpl permissionService,
                              GrantedAuthorityServiceImpl grantedAuthorityService,
                              BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeService = employeeService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.grantedAuthorityService = grantedAuthorityService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//        Employee staff = new Employee(null,
//                "PN234",
//                bCryptPasswordEncoder.encode("123"),
//                "199901410750v",
//                "Yasiru",
//                "54",
//                "y@gmail.com",null,r2);
//
//        Employee manager = new Employee(null,
//                "BL453",
//                bCryptPasswordEncoder.encode("456"),
//                "19410750v",
//                "Kavya",
//                "945",
//                "k@gmail.com",null,r1);


    @GetMapping("/emp")
    @PreAuthorize("hasAuthority('employee:read')")
    public UserRole emp(){
        return employeeService.findByEno("PN234").getUserRole();
    }
    @PreAuthorize("hasAuthority('attendance:delete')")
    @GetMapping("/roles")
    public List<UserRole> roles(){
        return roleService.findAll();
    }
    @GetMapping("/per")
    public List<UserPermission> per(){
        return  permissionService.findAll();
    }


}
