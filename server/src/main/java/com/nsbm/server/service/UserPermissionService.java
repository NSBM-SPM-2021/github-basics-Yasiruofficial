package com.nsbm.server.service;

import com.nsbm.server.model.UserPermission;

import java.util.List;

public interface UserPermissionService {

    UserPermission save(UserPermission userPermission);
    UserPermission delete(UserPermission userPermission);
    UserPermission edit(UserPermission userPermission);
    UserPermission findById(Long id);
    List<UserPermission> findAll();

}
