package com.healthcare.staff_management.dto;

import lombok.Data;

@Data
public class NewDoctorRequestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    private String nationalId;
    private String gender;
    private String professionalId;
    private Integer yearsOfExperience;
    private String speciality;

}
