package com.healthcare.staff_management.service.implementation;

import com.healthcare.staff_management.dto.DoctorResponseDTO;
import com.healthcare.staff_management.dto.NewDoctorRequestDTO;
import com.healthcare.staff_management.dto.UpdateDoctorDTO;
import com.healthcare.staff_management.dto.UserResponseDto;
import com.healthcare.staff_management.model.Doctor;
import com.healthcare.staff_management.model.DoctorSpeciality;
import com.healthcare.staff_management.repository.DoctorRepository;
import com.healthcare.staff_management.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final RestTemplate restTemplate;

    @Value("${application.user-management-uri}")
    private static String USER_MANAGEMENT_URI;

    public DoctorServiceImpl(DoctorRepository doctorRepository, RestTemplate restTemplate) {
        this.doctorRepository = doctorRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public DoctorResponseDTO newDoctor(NewDoctorRequestDTO newDoctorRequestDTO) {

        // Check if the doctor already exists:
        if(doctorRepository.existsByNationalId(newDoctorRequestDTO.getNationalId())){

        }
    }

    /**
     * This method helper is responsible for creating new user in the system
     * @return
     */
    private UserResponseDto createUser(){

    }

    @Override
    public DoctorResponseDTO updateDoctor(Integer doctorId, UpdateDoctorDTO updateDoctorDTO) {

        // update the professional information and return the updated data:
        ProfessionalInformation updatedProfessionalInformation = updateProfessionalInformation(
                doctorId,updateDoctorDTO
        );

        // update the personal information and return the new data
        updateProfessionalInformation();

        return new DoctorResponseDTO();
        return null;
    }

    @Override
    public boolean checkDoctorExistence(Integer id) {
        return doctorRepository.existsById(id);
    }

    /**
     * This method helper will update the user information
     */
    private PersonalInformationDto updatePersonalInformation(Integer id, UpdateDoctorDTO updateDoctorDTO){
        PersonalInformationDto personalInformationDto = new PersonalInformationDto(
                updateDoctorDTO.getFirstName(),
                updateDoctorDTO.getLastName(),
                updateDoctorDTO.getEmail(),
                updateDoctorDTO.getPassword()
        );
        // send the request to the user-management service
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<PersonalInformationDto> httpEntity = new HttpEntity<>(personalInformationDto,httpHeaders);
        ResponseEntity<?> response =
                restTemplate.exchange()

    }

    /**
     * This method helper will update the professional information
     */
    private ProfessionalInformation updateProfessionalInformation(Integer id, UpdateDoctorDTO updateDoctorDTO){

        Doctor doctor = doctorRepository.findById(id) // Fetch the doctor from db
                .orElseThrow();

        // update professional information:
        doctor.setProfessionalId(updateDoctorDTO.getProfessionalId());
        doctor.setSpeciality(DoctorSpeciality.valueOf(updateDoctorDTO.getSpeciality()));
        doctor.setYearsOfExperience(updateDoctorDTO.getYearsOfExperience());

        return new ProfessionalInformation(
                doctor.getProfessionalId(),
                doctor.getSpeciality().toString(),
                doctor.getYearsOfExperience()
        );

    }


    public ResponseEntity<?> updateUserDetails(){
        return null;
    }
}

/**
 * These classes are helper to handle server responses
 */
@Data
@AllArgsConstructor
class PersonalInformationDto{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

@Data
@AllArgsConstructor
class ProfessionalInformation{
    private String professionalId;
    private String speciality;
    private Integer yearsOfExperience;
}
