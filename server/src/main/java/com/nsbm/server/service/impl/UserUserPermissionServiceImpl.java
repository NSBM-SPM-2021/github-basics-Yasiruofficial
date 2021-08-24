package com.nsbm.server.service.impl;

import com.nsbm.server.model.UserPermission;
import com.nsbm.server.repository.UserPermissionRepository;
import com.nsbm.server.service.UserPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserUserPermissionServiceImpl implements UserPermissionService {

    private UserPermissionRepository userPermissionRepository;

    public UserUserPermissionServiceImpl(UserPermissionRepository userPermissionRepository) {
        this.userPermissionRepository = userPermissionRepository;
    }

    @Override
    public UserPermission save(UserPermission userPermission) {
        return userPermissionRepository.save(userPermission);
    }

    @Override
    public UserPermission delete(UserPermission userPermission) {
        Optional<UserPermission> p = userPermissionRepository.findById(userPermission.getId());

        if(!p.isPresent()){
            userPermissionRepository.delete(p.get());
        }

        return p.get();
    }

    @Override
    public UserPermission edit(UserPermission userPermission) {
        return userPermissionRepository.save(userPermission);
    }

    @Override
    public UserPermission findById(Long id) {
        return userPermissionRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserPermission> findAll() {
        return userPermissionRepository.findAll();
    }
}