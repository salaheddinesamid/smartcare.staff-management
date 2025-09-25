package com.healthcare.staff_management.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doctorId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "national_id")
    private String nationalId;

    @Column(name = "professional_id")
    private String professionalId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "speciality")
    @Enumerated(EnumType.STRING)
    private DoctorSpeciality speciality;

    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;
}
