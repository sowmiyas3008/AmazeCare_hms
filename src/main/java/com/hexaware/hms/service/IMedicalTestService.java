package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.MedicalTestRequestDTO;
import com.hexaware.hms.dto.MedicalTestResponseDTO;

public interface IMedicalTestService {

    MedicalTestResponseDTO addTest(MedicalTestRequestDTO test);

    List<MedicalTestResponseDTO> getAllTests();
}