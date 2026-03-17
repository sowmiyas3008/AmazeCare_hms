package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.SpecializationRequestDTO;
import com.hexaware.hms.dto.SpecializationResponseDTO;

public interface ISpecializationService {

    SpecializationResponseDTO addSpecialization(SpecializationRequestDTO dto);

    SpecializationResponseDTO getById(int id);

    List<SpecializationResponseDTO> getAll();

    SpecializationResponseDTO updateSpecialization(int id, SpecializationRequestDTO dto);

    void deleteSpecialization(int id);

    int getDoctorCount(int specializationId);
}