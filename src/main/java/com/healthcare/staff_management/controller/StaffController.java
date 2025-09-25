package com.healthcare.staff_management.controller;

import com.healthcare.staff_management.dto.ApiResponse;
import com.healthcare.staff_management.dto.DoctorResponseDTO;
import com.healthcare.staff_management.dto.NewDoctorRequestDTO;
import com.healthcare.staff_management.service.implementation.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/staff-management")
public class StaffController {

    private final DoctorServiceImpl doctorService;

    @Autowired
    public StaffController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("doctor/check-existence")
    public boolean checkExistence(@RequestParam Integer doctorId){
        return doctorService.checkDoctorExistence(doctorId);
    }

    @PostMapping("doctor/new")
    public ResponseEntity<ApiResponse<?>> newDoctor(@RequestBody NewDoctorRequestDTO newDoctorRequestDTO){

        DoctorResponseDTO doctorResponseDTO = doctorService.newDoctor(newDoctorRequestDTO);
        ApiResponse<DoctorResponseDTO> response = new ApiResponse<>(
                true,
                "",
                doctorResponseDTO

        );

        return ResponseEntity.status(200)
                .body(response);
    }
}
