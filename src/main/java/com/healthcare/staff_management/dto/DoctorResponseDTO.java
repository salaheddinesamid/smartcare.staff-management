package com.healthcare.staff_management.dto;

import com.healthcare.staff_management.model.Doctor;
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

    public DoctorResponseDTO(UserResponseDto userResponseDto, Doctor doctor){
        this.userId = userResponseDto.getUserId();
        this.firstName = userResponseDto.getFirstName();
        this.lastName = userResponseDto.getLastName();
        this.email = userResponseDto.getEmail();
        this.password = userResponseDto.getPassword();

        this.professionalId = doctor.getProfessionalId();
        this.yearsOfExperience = doctor.getYearsOfExperience();
        this.speciality = doctor.getSpeciality().toString();
    }
}
