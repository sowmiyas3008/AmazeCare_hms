package com.hexaware.hms.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.Patient;

public interface IPatientDAO extends JpaRepository<Patient, Integer> {
	Patient findByUser_UserId(int userId);

	List<Patient> findByDobBefore(LocalDate date);

	List<Patient> findByFullNameContainingIgnoreCase(String name);
}