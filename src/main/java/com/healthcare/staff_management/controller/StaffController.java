package com.healthcare.staff_management.controller;

import com.healthcare.staff_management.service.implementation.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
