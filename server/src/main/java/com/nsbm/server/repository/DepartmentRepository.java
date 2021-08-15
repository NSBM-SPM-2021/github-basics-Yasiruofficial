package com.nsbm.server.repository;
import com.nsbm.server.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department,UUID> {}
