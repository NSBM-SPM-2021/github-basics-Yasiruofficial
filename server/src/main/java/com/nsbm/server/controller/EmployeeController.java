package com.nsbm.server.controller;
import com.nsbm.server.dto.EmployeeDto;
import com.nsbm.server.service.impl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @PreAuthorize("hasAnyAuthority('employee:write')")
    @PostMapping("/employees")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employees) {

        return employeeService.save(employees);
    }

    @PreAuthorize("hasAnyAuthority('employee:edit')")
    @PutMapping("/employees/{key}")
    public ResponseEntity<EmployeeDto> editEmployee(
            @PathVariable("key") String key,
            @RequestBody EmployeeDto employee) {

        try{
            EmployeeDto employeeDto =  employeeService.edit(key,employee);
            return ResponseEntity.ok(employeeDto);
        }catch(IllegalStateException e){
            return ResponseEntity.status(403).body(new EmployeeDto());
        }catch(UsernameNotFoundException e){
            return ResponseEntity.status(404).body(new EmployeeDto());
        }
    }

    @PreAuthorize("hasAnyAuthority('employee:delete')")
    @DeleteMapping("/employees/{key}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("key") String key) {

        EmployeeDto employee = new EmployeeDto();
        employee.setEno(key);

        try{
            EmployeeDto employeeDto =  employeeService.delete(employee);
            return ResponseEntity.ok(employeeDto);
        }catch(IllegalStateException e){
            return ResponseEntity.status(403).body(new EmployeeDto());
        }catch(UsernameNotFoundException e){
            return ResponseEntity.status(404).body(new EmployeeDto());
        }
    }


}
