package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.PatientRequestDTO;
import com.hexaware.hms.dto.PatientResponseDTO;

public interface IPatientService {

    PatientResponseDTO addPatient(PatientRequestDTO dto);

    PatientResponseDTO updatePatient(int id, PatientRequestDTO dto);

    PatientResponseDTO getByUserId(int userId);

    PatientResponseDTO getByPatientId(int pid);

    void deletePatient(int id);

    int calculateAge(int patientId);

    List<PatientResponseDTO> getPatientsAboveAge(int age);

    List<PatientResponseDTO> searchPatientsByName(String name);

    List<PatientResponseDTO> getAllPatients();
}