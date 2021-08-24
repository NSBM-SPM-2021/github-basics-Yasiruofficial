package com.nsbm.server.service.impl;
import com.nsbm.server.model.Employee;
import com.nsbm.server.model.GrantedAuthority;
import com.nsbm.server.model.UserPermission;
import com.nsbm.server.repository.EmployeeRepository;
import com.nsbm.server.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService , UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee delete(Employee employee) {

        Optional<Employee> e = employeeRepository.findByEno(employee.getEno());

        if(e.isPresent()){
            employeeRepository.delete(e.get());
        }
        return e.get();

    }

    @Override
    public Employee edit(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee findByEno(String eno) {
        return employeeRepository.findByEno(eno).orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Employee> employee = employeeRepository.findByEno(s);

        if(!employee.isPresent()) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", employee);

            Set<GrantedAuthority> grantedAuthorities =  employee.get().getUserRole().getGrantedAuthorities();

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

            for (GrantedAuthority grantedAuthority : employee.get().getUserRole().getGrantedAuthorities()) {

                UserPermission userPermission = grantedAuthority.getUserPermission();
                String p = userPermission.getEntity() +":"+ userPermission.getAccess();

                authorities.add(new SimpleGrantedAuthority(p));

            }
            System.out.println(Arrays.asList(authorities));
            return new User(employee.get().getEno(), employee.get().getPassword(), authorities);
        }
    }
}