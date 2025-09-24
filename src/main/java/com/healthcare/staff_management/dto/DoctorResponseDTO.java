package com.healthcare.staff_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDTO {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String professionalId;
    private String speciality;
    private Integer yearsOfExperience;
}
