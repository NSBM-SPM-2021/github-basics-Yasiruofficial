package com.nsbm.server.service;

import com.nsbm.server.model.UserRole;

import java.util.List;

public interface UserRoleService {

    UserRole save(UserRole role);
    UserRole delete(UserRole role);
    UserRole edit(UserRole role);
    UserRole findById(Long id);
    List<UserRole> findAll();

}
