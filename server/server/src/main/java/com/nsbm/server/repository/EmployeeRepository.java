package com.nsbm.server.repository;
import com.nsbm.server.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee,UUID> {}
