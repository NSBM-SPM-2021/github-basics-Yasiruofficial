package com.nsbm.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLeave {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String type; //FullDay, HalfDay, ShortLeave
    private Date fromDateTime;
    private Date toDateTime;

    @ManyToOne
    private LeaveCategory leaveCategory; //Annual, Casual

    @ManyToOne
    private Employee employee;

}
