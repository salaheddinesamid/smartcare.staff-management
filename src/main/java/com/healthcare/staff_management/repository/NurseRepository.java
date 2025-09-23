package com.healthcare.staff_management.repository;

import com.healthcare.staff_management.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse,Integer> {
}
