package com.nsbm.server.repository;
import com.nsbm.server.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance,UUID> {}
