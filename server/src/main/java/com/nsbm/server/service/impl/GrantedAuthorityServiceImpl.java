package com.nsbm.server.service.impl;

import com.nsbm.server.model.GrantedAuthority;
import com.nsbm.server.repository.GrantedAuthorityRepository;
import com.nsbm.server.service.GrantedAuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrantedAuthorityServiceImpl implements GrantedAuthorityService {

    private GrantedAuthorityRepository grantedAuthorityRepository;

    public GrantedAuthorityServiceImpl(GrantedAuthorityRepository grantedAuthorityRepository) {
        this.grantedAuthorityRepository = grantedAuthorityRepository;
    }

    @Override
    public GrantedAuthority save(GrantedAuthority grantedAuthority) {
        return grantedAuthorityRepository.save(grantedAuthority);
    }

    @Override
    public GrantedAuthority delete(GrantedAuthority grantedAuthority) {

        Optional<GrantedAuthority> g = grantedAuthorityRepository.findById(grantedAuthority.getId());

        if(g.isPresent()){
            grantedAuthorityRepository.delete(g.get());
            return g.get();
        }
        throw new IllegalStateException("GrantedAuthorityRepository Not Found");

    }

    @Override
    public GrantedAuthority edit(GrantedAuthority grantedAuthority) {
        return grantedAuthorityRepository.save(grantedAuthority);
    }

    @Override
    public GrantedAuthority findById(Long id) {
        Optional<GrantedAuthority> auth =grantedAuthorityRepository.findById(id);
        if(auth.isPresent()) {
            return auth.get();
        }
        throw new IllegalStateException("GrantedAuthorityRepository Not Found");
    }

    @Override
    public List<GrantedAuthority> findAll() {
        return grantedAuthorityRepository.findAll();
    }
}
