package com.nsbm.server.service.impl;

import com.nsbm.server.model.UserPermission;
import com.nsbm.server.model.UserRole;
import com.nsbm.server.repository.UserPermissionRepository;
import com.nsbm.server.service.UserPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    private UserPermissionRepository userPermissionRepository;

    public UserPermissionServiceImpl(UserPermissionRepository userPermissionRepository) {
        this.userPermissionRepository = userPermissionRepository;
    }

    @Override
    public UserPermission save(UserPermission userPermission) {
        return userPermissionRepository.save(userPermission);
    }

    @Override
    public UserPermission delete(UserPermission userPermission) {
        Optional<UserPermission> p = userPermissionRepository.findById(userPermission.getId());

        if(p.isPresent()){
            userPermissionRepository.delete(p.get());
            return p.get();
        }
        throw new IllegalStateException("UserPermission Not Found");

    }

    @Override
    public UserPermission edit(UserPermission userPermission) {
        return userPermissionRepository.save(userPermission);
    }

    @Override
    public UserPermission findById(Long id) {
        Optional<UserPermission> permission =userPermissionRepository.findById(id);
        if(permission.isPresent()) {
            return permission.get();
        }
        throw new IllegalStateException("UserPermission Not Found");
    }

    @Override
    public List<UserPermission> findAll() {
        return userPermissionRepository.findAll();
    }
}