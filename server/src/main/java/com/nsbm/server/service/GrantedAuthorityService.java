package com.nsbm.server.service;

import com.nsbm.server.model.GrantedAuthority;

import java.util.List;

public interface GrantedAuthorityService {

    GrantedAuthority save(GrantedAuthority grantedAuthority);
    GrantedAuthority delete(GrantedAuthority grantedAuthority);
    GrantedAuthority edit(GrantedAuthority grantedAuthority);
    GrantedAuthority findById(Long id);
    List<GrantedAuthority> findAll();


}
