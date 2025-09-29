package com.healthcare.staff_management.service;

import com.healthcare.staff_management.dto.DoctorResponseDTO;
import com.healthcare.staff_management.dto.NewDoctorRequestDTO;
import com.healthcare.staff_management.dto.UpdateDoctorDTO;

import java.util.List;

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
    DoctorResponseDTO updateDoctor(Integer doctorId, UpdateDoctorDTO updateDoctorDTO);

    /**
     * This method updates the status of the
     */

    /**
     * This method returns all the doctors in the system
     * return
     */

    List<DoctorResponseDTO> getAllDoctors();

    /**
     * This method used to check if a doctor truly exist in the system
     * @return a true/false
     */
    boolean checkDoctorExistence(Integer id);
}
