package com.nsbm.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private int eno;
    private String nic;
    private String name;
    private String address;
    private String email;
    private boolean isManager;
    private boolean isDepartmentHead;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Branch branch;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeLeave> employeeLeave;

    @OneToMany(mappedBy = "employee")
    private Set<Attendance> attendances;

    @ManyToMany
    private Set<Role> roles;

}
