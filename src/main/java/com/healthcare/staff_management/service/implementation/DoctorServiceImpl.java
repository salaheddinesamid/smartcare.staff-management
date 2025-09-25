package com.healthcare.staff_management.service.implementation;

import com.healthcare.staff_management.dto.*;
import com.healthcare.staff_management.exception.DoctorAlreadyExistsException;
import com.healthcare.staff_management.model.Doctor;
import com.healthcare.staff_management.model.DoctorSpeciality;
import com.healthcare.staff_management.repository.DoctorRepository;
import com.healthcare.staff_management.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
            throw new DoctorAlreadyExistsException();
        }

        // Create new user:
        NewUserRequestDto newUserRequestDto = new NewUserRequestDto(

        );
        UserResponseDto user = createUser(newUserRequestDto);

        // Then, we create a new doctor:
        Doctor doctor = new Doctor();
        doctor.setUserId(user.getUserId());
        doctor.setGender(newDoctorRequestDTO.getGender());
        doctor.setProfessionalId(newDoctorRequestDTO.getProfessionalId());
        doctor.setNationalId(newDoctorRequestDTO.getNationalId());
        doctor.setSpeciality(DoctorSpeciality.valueOf(newDoctorRequestDTO.getSpeciality()));
        doctor.setYearsOfExperience(newDoctorRequestDTO.getYearsOfExperience());

        return new DoctorResponseDTO(
                user,
                doctor
        );
    }

    /**
     * This method helper is responsible for creating new user in the system
     * @return
     */
    private UserResponseDto createUser(NewUserRequestDto newUserRequestDto){
        String uri = USER_MANAGEMENT_URI + "/api/user/new";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<NewUserRequestDto> entity = new HttpEntity<>(newUserRequestDto,headers);
        ResponseEntity<ApiResponse<UserResponseDto>> response =
                restTemplate.exchange(
                        uri,
                        HttpMethod.POST,
                        entity,
                        new ParameterizedTypeReference<ApiResponse<UserResponseDto>>() {}
                );

        return response.getBody().getData();
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
    private PersonalInformationDto updatePersonalInformation(Integer id, UpdateUserRequestDTO updateUserRequestDTO){

        String uri = USER_MANAGEMENT_URI + "/api/user/update";
        PersonalInformationDto personalInformationDto = new PersonalInformationDto(
                updateUserRequestDTO.getFirstName(),
                updateUserRequestDTO.getLastName(),
                updateUserRequestDTO.getEmail(),
                updateUserRequestDTO.getPassword()
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
