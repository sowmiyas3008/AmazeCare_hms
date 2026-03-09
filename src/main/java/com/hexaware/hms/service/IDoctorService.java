package com.hexaware.hms.service;

import java.util.List;
import com.hexaware.hms.entity.Doctor;

public interface IDoctorService {

    // CRUD
    Doctor addDoctor(Doctor doctor);
    Doctor getDoctorById(int doctorId);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(int doctorId, Doctor doctor);
    void deleteDoctor(int doctorId);

    // Search
    Doctor getDoctorByUserId(int userId);
    List<Doctor> getDoctorsBySpeciality(String speciality);
    List<Doctor> getDoctorsByQualification(String qualification);

    // Filters
    List<Doctor> getExperiencedDoctors(int minYears);
    List<Doctor> getDoctorsByDesignation(String designation);

    // Utility
    boolean existsByPhone(String phone);
    int getDoctorCount();
}