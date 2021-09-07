package com.nsbm.server.service.impl;

import com.nsbm.server.model.UserRole;
import com.nsbm.server.repository.UserRoleRepository;
import com.nsbm.server.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole save(UserRole role) {
        return userRoleRepository.save(role);
    }

    @Override
    public UserRole delete(UserRole role) {

        Optional<UserRole> r = userRoleRepository.findById(role.getId());

        if(r.isPresent()){
            userRoleRepository.delete(r.get());
            return r.get();
        }

        throw new IllegalStateException("UserRole Not Found");

    }

    @Override
    public UserRole edit(UserRole role) {
        return userRoleRepository.save(role);
    }


    @Override
    public UserRole findById(Long id) {

        Optional<UserRole> role =userRoleRepository.findById(id);
        if(role.isPresent()) {
            return role.get();
        }
        throw new IllegalStateException("UserRole Not Found");

    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }
}