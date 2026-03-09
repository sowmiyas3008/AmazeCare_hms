package com.hexaware.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IDoctorDAO;
import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorDAO doctorDAO;

    public Doctor addDoctor(Doctor doctor) {
        return doctorDAO.save(doctor);
    }

    
    public Doctor getDoctorById(int doctorId) {
        return doctorDAO.findById(doctorId).orElse(null);
    }

    
    public List<Doctor> getAllDoctors() {
        return doctorDAO.findAll();
    }

    public Doctor updateDoctor(int doctorId, Doctor doctor) {
        Optional<Doctor> existing = doctorDAO.findById(doctorId);

        if (existing.isPresent()) {
            Doctor d = existing.get();
            d.setName(doctor.getName());
            d.setSpeciality(doctor.getSpeciality());
            d.setQualification(doctor.getQualification());
            d.setExperienceYears(doctor.getExperienceYears());
            d.setDesignation(doctor.getDesignation());
            d.setPhone(doctor.getPhone());
            return doctorDAO.save(d);
        }
        return null;
    }

    public void deleteDoctor(int doctorId) {
        doctorDAO.deleteById(doctorId);
    }

    public Doctor getDoctorByUserId(int userId) {
        return doctorDAO.findByUser_UserId(userId);
    }

    public List<Doctor> getDoctorsBySpeciality(String speciality) {
        return doctorDAO.findBySpeciality(speciality);
    }

    public List<Doctor> getDoctorsByQualification(String qualification) {
        return doctorDAO.findByQualification(qualification);
    }

    public List<Doctor> getExperiencedDoctors(int minYears) {
        return doctorDAO.findByExperienceYearsGreaterThanEqual(minYears);
    }

    public List<Doctor> getDoctorsByDesignation(String designation) {
        return doctorDAO.findByDesignation(designation);
    }

    public boolean existsByPhone(String phone) {
        return doctorDAO.existsByPhone(phone);
    }

    public int getDoctorCount() {
        return (int) doctorDAO.count();
    }


}