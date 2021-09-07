package com.nsbm.server.service;
import com.nsbm.server.dto.EmployeeDto;

import java.util.HashMap;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);
    EmployeeDto delete(EmployeeDto employeeDto);
    EmployeeDto edit(String key,EmployeeDto employeeDto);;
    HashMap<String,Object> findAll(boolean requireTotalCount,
                                    int skip,
                                    int take,
                                    String sort,
                                    String filter);

}
