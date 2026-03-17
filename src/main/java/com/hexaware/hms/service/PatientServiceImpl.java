package com.hexaware.hms.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IPatientDAO;
import com.hexaware.hms.dto.PatientRequestDTO;
import com.hexaware.hms.dto.PatientResponseDTO;
import com.hexaware.hms.entity.Patient;
import com.hexaware.hms.entity.User;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientDAO patientDAO;

    @Override
    public PatientResponseDTO addPatient(PatientRequestDTO dto) {

        Patient p = new Patient();

        User user = new User();
        user.setUserId(dto.getUserId());

        p.setUser(user);
        p.setFullName(dto.getFullName());
        p.setDob(dto.getDob());
        p.setGender(dto.getGender());
        p.setPhone(dto.getPhone());
        p.setAddress(dto.getAddress());

        Patient saved = patientDAO.save(p);

        return mapToDTO(saved);
    }

    @Override
    public PatientResponseDTO updatePatient(int id, PatientRequestDTO dto) {

        Optional<Patient> existing = patientDAO.findById(id);

        if (existing.isPresent()) {

            Patient patient = existing.get();

            patient.setFullName(dto.getFullName());
            patient.setPhone(dto.getPhone());
            patient.setDob(dto.getDob());
            patient.setGender(dto.getGender());
            patient.setAddress(dto.getAddress());

            Patient updated = patientDAO.save(patient);

            return mapToDTO(updated);
        }

        return null;
    }

    @Override
    public PatientResponseDTO getByUserId(int userId) {

        Patient p = patientDAO.findByUser_UserId(userId);

        return mapToDTO(p);
    }

    @Override
    public PatientResponseDTO getByPatientId(int pid) {

        Patient p = patientDAO.findById(pid).orElse(null);

        return mapToDTO(p);
    }

    @Override
    public void deletePatient(int id) {
        patientDAO.deleteById(id);
    }

    @Override
    public int calculateAge(int patientId) {

        Patient p = patientDAO.findById(patientId).orElse(null);

        if (p != null) {
            return Period.between(p.getDob(), LocalDate.now()).getYears();
        }

        return 0;
    }

    @Override
    public List<PatientResponseDTO> getPatientsAboveAge(int age) {

        return patientDAO.findByDobBefore(LocalDate.now().minusYears(age))
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientResponseDTO> searchPatientsByName(String name) {

        return patientDAO.findByFullNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {

        return patientDAO.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private PatientResponseDTO mapToDTO(Patient p) {

        if (p == null) return null;

        PatientResponseDTO dto = new PatientResponseDTO();

        dto.setPatientId(p.getPatientId());
        dto.setUserId(p.getUser().getUserId());
        dto.setFullName(p.getFullName());
        dto.setDob(p.getDob());
        dto.setGender(p.getGender());
        dto.setPhone(p.getPhone());
        dto.setAddress(p.getAddress());

        return dto;
    }
}