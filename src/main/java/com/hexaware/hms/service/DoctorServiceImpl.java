package com.hexaware.hms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IDoctorDAO;
import com.hexaware.hms.dto.DoctorRequestDTO;
import com.hexaware.hms.dto.DoctorResponseDTO;
import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.entity.User;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorDAO doctorDAO;

    // ENTITY → DTO
    public DoctorResponseDTO convertToDTO(Doctor doctor) {

        DoctorResponseDTO dto = new DoctorResponseDTO();

        dto.setDoctorId(doctor.getDoctorId());
        dto.setName(doctor.getName());
        dto.setSpeciality(doctor.getSpeciality());
        dto.setQualification(doctor.getQualification());
        dto.setExperienceYears(doctor.getExperienceYears());
        dto.setDesignation(doctor.getDesignation());
        dto.setPhone(doctor.getPhone());
        dto.setUserId(doctor.getUser().getUserId());

        return dto;
    }

    // DTO → ENTITY
    public Doctor convertToEntity(DoctorRequestDTO dto) {

        Doctor doctor = new Doctor();

        User user = new User();
        user.setUserId(dto.getUserId());

        doctor.setName(dto.getName());
        doctor.setSpeciality(dto.getSpeciality());
        doctor.setQualification(dto.getQualification());
        doctor.setExperienceYears(dto.getExperienceYears());
        doctor.setDesignation(dto.getDesignation());
        doctor.setPhone(dto.getPhone());
        doctor.setUser(user);

        return doctor;
    }

    @Override
    public DoctorResponseDTO addDoctor(DoctorRequestDTO dto) {

        Doctor doctor = convertToEntity(dto);

        Doctor saved = doctorDAO.save(doctor);

        return convertToDTO(saved);
    }

    @Override
    public DoctorResponseDTO getDoctorById(int doctorId) {

        Doctor doctor = doctorDAO.findById(doctorId).orElse(null);

        if (doctor != null)
            return convertToDTO(doctor);

        return null;
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {

        return doctorDAO.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorResponseDTO updateDoctor(int doctorId, DoctorRequestDTO dto) {

        Doctor doctor = doctorDAO.findById(doctorId).orElse(null);

        if (doctor != null) {

            doctor.setName(dto.getName());
            doctor.setSpeciality(dto.getSpeciality());
            doctor.setQualification(dto.getQualification());
            doctor.setExperienceYears(dto.getExperienceYears());
            doctor.setDesignation(dto.getDesignation());
            doctor.setPhone(dto.getPhone());

            Doctor updated = doctorDAO.save(doctor);

            return convertToDTO(updated);
        }

        return null;
    }

    @Override
    public void deleteDoctor(int doctorId) {
        doctorDAO.deleteById(doctorId);
    }

    @Override
    public DoctorResponseDTO getDoctorByUserId(int userId) {

        Doctor doctor = doctorDAO.findByUser_UserId(userId);

        if (doctor != null)
            return convertToDTO(doctor);

        return null;
    }

    @Override
    public List<DoctorResponseDTO> getDoctorsBySpeciality(String speciality) {

        return doctorDAO.findBySpeciality(speciality)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorResponseDTO> getDoctorsByQualification(String qualification) {

        return doctorDAO.findByQualification(qualification)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorResponseDTO> getExperiencedDoctors(int minYears) {

        return doctorDAO.findByExperienceYearsGreaterThanEqual(minYears)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorResponseDTO> getDoctorsByDesignation(String designation) {

        return doctorDAO.findByDesignation(designation)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByPhone(String phone) {
        return doctorDAO.existsByPhone(phone);
    }

    @Override
    public int getDoctorCount() {
        return (int) doctorDAO.count();
    }
}