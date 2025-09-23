package com.healthcare.staff_management.dto;

import lombok.Data;

@Data
public class UpdateDoctorDTO {
    private PersonalInformation personalInformation;
    private ProfessionalInformation professionalInformation;
}

class PersonalInformation{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
class ProfessionalInformation{

    private String nationalId;
    private String professionalId;
    private String speciality;
    private Integer yearsOfExperience;
}