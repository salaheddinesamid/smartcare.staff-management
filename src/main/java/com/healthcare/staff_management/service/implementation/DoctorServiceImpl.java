package com.healthcare.staff_management.service.implementation;

import com.healthcare.staff_management.dto.DoctorResponseDTO;
import com.healthcare.staff_management.dto.NewDoctorRequestDTO;
import com.healthcare.staff_management.dto.UpdateDoctorDTO;
import com.healthcare.staff_management.service.DoctorService;
import org.springframework.http.ResponseEntity;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public DoctorResponseDTO newDoctor(NewDoctorRequestDTO newDoctorRequestDTO) {
        return null;
    }

    @Override
    public DoctorResponseDTO updateDoctor(UpdateDoctorDTO updateDoctorDTO) {
        updatePersonalInformation();
        updateProfessionalInformation();
        return null;
    }

    private void updatePersonalInformation(){

    }

    private void updateProfessionalInformation(){

    }


    public ResponseEntity<?> updateUserDetails(){
        return null;
    }
}
