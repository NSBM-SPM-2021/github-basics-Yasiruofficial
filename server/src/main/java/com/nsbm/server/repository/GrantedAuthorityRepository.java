package com.nsbm.server.repository;

import com.nsbm.server.model.Employee;
import com.nsbm.server.model.GrantedAuthority;
import com.nsbm.server.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface GrantedAuthorityRepository extends JpaRepository<GrantedAuthority,Long> {

    Set<GrantedAuthority> findAllByUserRole(UserRole userRole);

}
