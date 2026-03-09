package com.hexaware.hms.service;
import com.hexaware.hms.dao.IPatientDAO;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IPatientDAO;
import com.hexaware.hms.entity.Patient;
import com.hexaware.hms.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientDAO patientDAO;

    @Override
    public Patient addPatient(Patient p) {
        return patientDAO.save(p);
    }

    @Override
    public Patient updatePatient(int id, Patient p) {
        Optional<Patient> existing = patientDAO.findById(id);

        if (existing.isPresent()) {
            Patient patient = existing.get();
            patient.setFullName(p.getFullName());
            patient.setPhone(p.getPhone());
            patient.setDob(p.getDob());
            return patientDAO.save(patient);
        }
        return null;
    }

    @Override
    public Patient getByUserId(int userId) {
        return patientDAO.findByUser_UserId(userId);
    }

    @Override
    public Patient getByPatientId(int pid) {
        return patientDAO.findById(pid).orElse(null);
    }

    @Override
    public void deletePatient(int id) {
        patientDAO.deleteById(id);
    }

    @Override
    public int calculateAge(int patientId) {
        Patient p = getByPatientId(patientId);
        if (p != null) {
            return Period.between(p.getDob(), LocalDate.now()).getYears();
        }
        return 0;
    }

    @Override
    public List<Patient> getPatientsAboveAge(int age) {
        return patientDAO.findByDobBefore(LocalDate.now().minusYears(age));
    }

    @Override
    public List<Patient> searchPatientsByName(String name) {
        return patientDAO.findByFullNameContainingIgnoreCase(name);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.findAll();
    }
}