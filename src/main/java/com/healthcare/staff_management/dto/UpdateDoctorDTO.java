package com.healthcare.staff_management.dto;

import lombok.*;

@Data
public class UpdateDoctorDTO {
    public String firstName;
    private String lastName;
    private String email;
    private String password;

    private String nationalId;
    private String professionalId;
    private String speciality;
    private Integer yearsOfExperience;
}
