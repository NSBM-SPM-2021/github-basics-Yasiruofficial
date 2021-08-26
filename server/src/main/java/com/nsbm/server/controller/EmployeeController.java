package com.nsbm.server.controller;

import com.nsbm.server.model.*;
import com.nsbm.server.repository.EmployeeRepository;
import com.nsbm.server.repository.UserPermissionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
@RequestMapping("api")
public class EmployeeController {


    private EmployeeRepository employeeRepository;
    private UserPermissionRepository permissinRepository;

    public EmployeeController(EmployeeRepository employeeRepository, UserPermissionRepository permissinRepository){
        this.employeeRepository = employeeRepository;
        this.permissinRepository = permissinRepository;
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
    public List<Employee> emp(){
        return employeeRepository.findAll();
    }

    @GetMapping("/emp1")
    public List<String[]> emp1(){
        Pageable pageable = PageRequest.of(0, 2);
        List<String[]> e = permissinRepository.getPermissions(pageable);
        return e;
    }




//    @PreAuthorize("hasAuthority('attendance:delete')")
//    @GetMapping("/roles")
//    public List<UserRole> roles(){
//        return roleService.findAll();
//    }
//    @GetMapping("/per")
//    public List<UserPermission> per(){
//        return  permissionService.findAll();
//    }


}
