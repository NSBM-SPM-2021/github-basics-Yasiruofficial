package com.nsbm.server.repository;

import com.nsbm.server.model.Employee;
import com.nsbm.server.model.GrantedAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrantedAuthorityRepository extends JpaRepository<GrantedAuthority,Long> {
}
