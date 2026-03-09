package com.hexaware.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.Doctor;

public interface IDoctorDAO extends JpaRepository<Doctor, Integer> {
	Doctor findByUser_UserId(int userId);

	List<Doctor> findBySpeciality(String speciality);

	List<Doctor> findByQualification(String qualification);

	List<Doctor> findByExperienceYearsGreaterThanEqual(int minYears);

	List<Doctor> findByDesignation(String designation);

	boolean existsByPhone(String phone);
}