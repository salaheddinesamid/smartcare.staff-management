package com.healthcare.staff_management.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nurseId;

    @Column(name = "national_id")
    private String nationalId;

    @Column(name = "professional_id")
    private String professionalId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth")
    private Date date;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StaffStatus status;
}
