package com.nsbm.server.repository;
import com.nsbm.server.model.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave,UUID> {}
