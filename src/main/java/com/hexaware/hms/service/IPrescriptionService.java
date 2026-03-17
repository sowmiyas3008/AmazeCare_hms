package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.PrescriptionRequestDTO;
import com.hexaware.hms.dto.PrescriptionResponseDTO;

public interface IPrescriptionService {

    PrescriptionResponseDTO addPrescription(PrescriptionRequestDTO dto);

    List<PrescriptionResponseDTO> getByConsultation(int consultationId);
}