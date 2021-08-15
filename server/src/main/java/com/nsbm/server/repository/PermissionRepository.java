package com.nsbm.server.repository;
import com.nsbm.server.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

interface PermissionRepository extends JpaRepository<Permission,UUID> {}
