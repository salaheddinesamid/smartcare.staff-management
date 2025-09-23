package com.healthcare.staff_management.service;

import com.healthcare.staff_management.dto.DoctorResponseDTO;
import com.healthcare.staff_management.dto.NewDoctorRequestDTO;
import com.healthcare.staff_management.dto.UpdateDoctorDTO;

public interface DoctorService {

    /**
     * This method is dedicated to create new doctor to the system
     * @param newDoctorRequestDTO
     * @return DoctorResponseDTO
     */
    DoctorResponseDTO newDoctor(NewDoctorRequestDTO newDoctorRequestDTO);

    /**
     * This method is responsible for modifying doctor's information
     * @param updateDoctorDTO
     */
    DoctorResponseDTO updateDoctor(UpdateDoctorDTO updateDoctorDTO);

    /**
     * This method updates the status of the
     */
}
