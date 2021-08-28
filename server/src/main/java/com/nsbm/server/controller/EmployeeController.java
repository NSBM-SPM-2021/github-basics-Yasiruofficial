package com.nsbm.server.controller;
import com.nsbm.server.dto.EmployeeDto;
import com.nsbm.server.service.impl.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

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

    @PostMapping("/employees")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employees) {

        return employeeService.save(employees);
    }

    @PutMapping("/employees/{key}")
    public EmployeeDto editEmployee(
            @PathVariable("key") String key,
            @RequestBody EmployeeDto employee) {

        return employeeService.edit(key,employee);
    }

    @DeleteMapping("/employees/{key}")
    public EmployeeDto deleteEmployee(@PathVariable("key") String key) {

        EmployeeDto employee = new EmployeeDto();
        employee.setEno(key);

        return  employeeService.delete(employee);
    }


}
