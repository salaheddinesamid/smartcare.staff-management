package com.healthcare.staff_management.controller;

import com.healthcare.staff_management.dto.ApiResponse;
import com.healthcare.staff_management.dto.DoctorResponseDTO;
import com.healthcare.staff_management.dto.NewDoctorRequestDTO;
import com.healthcare.staff_management.service.implementation.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/doctor/get_all")
    public ResponseEntity<ApiResponse<?>> getAllDoctors(){
        List<DoctorResponseDTO> doctors = doctorService.getAllDoctors();

        return ResponseEntity.status(200)
                .body(new ApiResponse<>(
                        true,
                        "",
                        doctors
                ));
    }

    @PostMapping("/doctor/get-doctors")
    public ResponseEntity<ApiResponse<?>> getDoctors(@RequestBody List<Integer> ids){
        List<DoctorResponseDTO> doctors = doctorService.getDoctors(ids);

        ApiResponse<?> response = new ApiResponse<>(
                true,
                "",
                doctors
        );

        return ResponseEntity.ok()
                .body(response);
    }
}
