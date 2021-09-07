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

        Employee e = new Employee();
        e.setEno(employeeDto.getEno());
        e.setNic(employeeDto.getNic());
        e.setName(employeeDto.getName());
        e.setAddress(employeeDto.getAddress());
        e.setPassword("$2a$10$PB4n5eIsV8L.4Rou6/Xtkey/dS6k5T/ODBUEb3k.7Rl9YgLEP8x3O");
        e.setEmail(employeeDto.getEmail());
        UserRole userRole = userRoleService.findById(Long.valueOf(employeeDto.getUserRoleId()));
        e.setUserRole(userRole);

        employeeRepository.save(e);

        return employeeDto;

    }

    @Override
    public EmployeeDto delete(EmployeeDto employee) throws IllegalStateException{

        System.out.println("Delete Role is -> "+employee.getUserRoleId());

        Optional<Employee> e = employeeRepository.findByEno(employee.getEno());

        if(e.isPresent()){
            if(e.get().getUserRole().getDescription().equals("ROLE_HR")){
                throw new IllegalStateException("ROLE_HR can't delete another ROLE_HR");
            }
            e.get().setUserRole(null);
            employeeRepository.deleteById(e.get().getId());
            return new EmployeeDto();
        }
        throw new UsernameNotFoundException("User not found in the database");

    }

    @Override
    public EmployeeDto edit(String key,EmployeeDto employeeDto) throws IllegalStateException{


        Optional<Employee> e = employeeRepository.findByEno(key);

        if(e.isPresent()) {
            if(e.get().getUserRole().getDescription().equals("ROLE_HR")){
                throw new IllegalStateException("ROLE_HR can't edit another ROLE_HR");
            }
            if(employeeDto.getEno() != null){
                e.get().setEno(employeeDto.getEno());
            }
            if(employeeDto.getNic() != null){
                e.get().setNic(employeeDto.getNic());
            }
            if(employeeDto.getName() != null){
                e.get().setName(employeeDto.getName());
            }
            if(employeeDto.getAddress() != null){
                e.get().setAddress(employeeDto.getAddress());
            }
            if(employeeDto.getEmail() != null){
                e.get().setEmail(employeeDto.getEmail());
            }
            if(employeeDto.getUserRoleId() != null){
                UserRole role = userRoleService.findById(Long.valueOf(employeeDto.getUserRoleId()));
                e.get().setUserRole(role);
            }

            System.out.println(e.get().toString());
            System.out.println("End Edit Method");
            employeeRepository.save(e.get());

            return employeeDto;
       }
        throw new UsernameNotFoundException("User not found in the database");

    }


    @Override
    public HashMap<String, Object> findAll(boolean requireTotalCount, int skip, int take, String sort, String filter) {
        Pageable pageable;
        Page<Employee> employeePage;
        List<Employee> employeeList;
        int totalCount;

        pageable = PageRequest.of(skip/take,take);

        if(filter == null){
            employeePage = employeeRepository.findAll(pageable);
            totalCount = (int)employeePage.getTotalElements();

        }else{

            filter = filter.replace("\"", "");
            filter = filter.replace("]", "");
            filter = filter.replace("[", "");
            filter = filter.replace(" ", "");

            String[] splitFilter = filter.split(",");

            String query = "";

            if(splitFilter[1].equals("contains")){
                switch(splitFilter[0]){
                    case "eno":
                        query = splitFilter[2]; break;
                }
            }

            employeePage = employeeRepository.findByEnoContaining(query,pageable);
            totalCount = (int)employeePage.getTotalElements();

        }

        employeeList =employeePage.getContent();
        List<EmployeeDto> responseEmployeeList = new ArrayList<>();

        for( Employee e : employeeList ){

            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto = mapEmployeeToDto(e);
            responseEmployeeList.add(employeeDto);

        }

        HashMap map = new HashMap();

        map.put("data", responseEmployeeList);
        map.put("totalCount", totalCount);

        return map;

    }
}