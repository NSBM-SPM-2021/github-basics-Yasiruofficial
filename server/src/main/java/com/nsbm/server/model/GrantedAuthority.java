package com.nsbm.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne(cascade = {CascadeType.ALL})
    private UserRole userRole;

    @JoinColumn
    @ManyToOne(cascade = {CascadeType.ALL})
    private UserPermission userPermission;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @JsonBackReference
    public UserPermission getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(UserPermission userPermission) {
        this.userPermission = userPermission;
    }

}
