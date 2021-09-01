package com.nsbm.server.repository;

import com.nsbm.server.model.UserPermission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission,Long> {

    @Query(value ="SELECT id,entity,access FROM UserPermission",nativeQuery = true)
    List<String[]> getPermissions(Pageable pageable);
}
