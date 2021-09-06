package com.nsbm.server.controller;
import com.nsbm.server.dto.EmployeeDto;
import com.nsbm.server.service.impl.EmployeeServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PreAuthorize("hasAnyAuthority('employee:read')")
    @GetMapping("/employees")
    public HashMap<String,Object> getEmployees(
            @RequestParam(name="requireTotalCount",required = false) boolean requireTotalCount,
            @RequestParam(name="skip") int skip,
            @RequestParam(name="take") int take,
            @RequestParam(name="sort",required = false) String sort,
            @RequestParam(name="filter",required = false) String filter
    ) {

        return employeeService.findAll(requireTotalCount,skip,take,sort,filter);
    }

}
