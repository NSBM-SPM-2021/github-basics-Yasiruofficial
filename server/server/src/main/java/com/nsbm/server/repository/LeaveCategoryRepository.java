package com.nsbm.server.repository;
import com.nsbm.server.model.LeaveCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LeaveCategoryRepository extends JpaRepository<LeaveCategory,UUID> {}
