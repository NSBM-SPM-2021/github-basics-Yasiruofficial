package com.nsbm.server.service;
import com.nsbm.server.dto.EmployeeDto;
import com.nsbm.server.model.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);
    EmployeeDto delete(EmployeeDto employeeDto);
    EmployeeDto edit(String key,EmployeeDto employeeDto);
    EmployeeDto findById(Long id);
    EmployeeDto findByEno(String eno);
    HashMap<String,Object> findAll(boolean requireTotalCount,
                                    int skip,
                                    int take,
                                    String sort,
                                    String filter);

}
