package com.healthcare.staff_management.repository;

import com.healthcare.staff_management.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
