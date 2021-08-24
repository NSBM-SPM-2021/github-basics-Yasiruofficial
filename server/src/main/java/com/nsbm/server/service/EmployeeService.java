package com.nsbm.server.service;
import com.nsbm.server.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    Employee delete(Employee employee);
    Employee edit(Employee employee);
    Employee findById(Long id);
    Employee findByEno(String eno);
    List<Employee> findAll();

}
