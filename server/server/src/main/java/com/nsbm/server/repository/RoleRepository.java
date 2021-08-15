package com.nsbm.server.repository;
import com.nsbm.server.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role,UUID> {}
