package com.nsbm.server.service.impl;
import com.nsbm.server.dto.EmployeeDto;
import com.nsbm.server.model.Employee;
import com.nsbm.server.model.GrantedAuthority;
import com.nsbm.server.model.UserPermission;
import com.nsbm.server.model.UserRole;
import com.nsbm.server.repository.EmployeeRepository;
import com.nsbm.server.repository.GrantedAuthorityRepository;
import com.nsbm.server.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService , UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final GrantedAuthorityRepository grantedAuthorityRepository;
    private UserRoleServiceImpl userRoleService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, GrantedAuthorityRepository grantedAuthorityRepository, UserRoleServiceImpl userRoleService) {
        this.employeeRepository = employeeRepository;
        this.grantedAuthorityRepository = grantedAuthorityRepository;
        this.userRoleService = userRoleService;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Employee> employee = employeeRepository.findByEno(s);

        if(!employee.isPresent()) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", employee);

            UserRole userRole =  employee.get().getUserRole();
            Set<GrantedAuthority> grantedAuthorities =  grantedAuthorityRepository.findAllByUserRole(userRole);

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

            for (GrantedAuthority grantedAuthority : grantedAuthorities) {

                UserPermission userPermission = grantedAuthority.getUserPermission();
                String p = userPermission.getEntity() +":"+ userPermission.getAccess();

                authorities.add(new SimpleGrantedAuthority(p));

            }
            return new User(employee.get().getEno(), employee.get().getPassword(), authorities);
        }
    }

    private EmployeeDto mapEmployeeToDto(Employee e){

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEno(e.getEno());
        employeeDto.setNic(e.getNic());
        employeeDto.setName(e.getName());
        employeeDto.setAddress(e.getAddress());
        employeeDto.setEmail(e.getEmail());
        employeeDto.setUserRoleId(e.getUserRole().getId().toString());

        return employeeDto;
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto delete(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto edit(String key, EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto findById(Long id) {
        return null;
    }

    @Override
    public EmployeeDto findByEno(String eno) {
        return null;
    }

    @Override
    public HashMap<String, Object> findAll(boolean requireTotalCount, int skip, int take, String sort, String filter) {
        return null;
    }
}