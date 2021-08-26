package com.nsbm.server.repository;

import com.nsbm.server.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEno(String eno);

    @Query(value ="SELECT id,name,address FROM Employee",nativeQuery = true)
    List<String[]> getEmployees(Pageable pageable);

}
