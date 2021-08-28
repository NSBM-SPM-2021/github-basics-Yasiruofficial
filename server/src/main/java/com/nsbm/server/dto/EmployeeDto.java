package com.nsbm.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String eno;
    private String nic;
    private String name;
    private String address;
    private String email;
    private String userRoleId;



}
