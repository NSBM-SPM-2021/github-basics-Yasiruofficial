package com.nsbm.server.repository;
import com.nsbm.server.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BranchRepository extends JpaRepository<Branch,UUID> {}
