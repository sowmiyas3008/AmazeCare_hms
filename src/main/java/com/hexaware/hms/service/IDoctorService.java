package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.DoctorRequestDTO;
import com.hexaware.hms.dto.DoctorResponseDTO;

public interface IDoctorService {

    DoctorResponseDTO addDoctor(DoctorRequestDTO dto);

    DoctorResponseDTO getDoctorById(int doctorId);

    List<DoctorResponseDTO> getAllDoctors();

    DoctorResponseDTO updateDoctor(int doctorId, DoctorRequestDTO dto);

    void deleteDoctor(int doctorId);

    DoctorResponseDTO getDoctorByUserId(int userId);

    List<DoctorResponseDTO> getDoctorsBySpeciality(String speciality);

    List<DoctorResponseDTO> getDoctorsByQualification(String qualification);

    List<DoctorResponseDTO> getExperiencedDoctors(int minYears);

    List<DoctorResponseDTO> getDoctorsByDesignation(String designation);

    boolean existsByPhone(String phone);

    int getDoctorCount();
}