package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.ConsultationTestRequestDTO;
import com.hexaware.hms.dto.ConsultationTestResponseDTO;

public interface IConsultationTestService {

    ConsultationTestResponseDTO addTestToConsultation(ConsultationTestRequestDTO dto);

    List<ConsultationTestResponseDTO> getTestsByConsultation(int consultationId);
}