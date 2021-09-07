package com.nsbm.server.repository;

import com.nsbm.server.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEno(String eno);

    Page<Employee> findByEnoContaining(String eno,Pageable pageable);

}
