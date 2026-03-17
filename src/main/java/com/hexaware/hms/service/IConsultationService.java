package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.ConsultationRequestDTO;
import com.hexaware.hms.dto.ConsultationResponseDTO;

public interface IConsultationService {

    ConsultationResponseDTO addConsultation(ConsultationRequestDTO dto);

    ConsultationResponseDTO getConsultationById(int id);

    List<ConsultationResponseDTO> getAllConsultations();

    ConsultationResponseDTO updateConsultation(int id, ConsultationRequestDTO dto);

    void deleteConsultation(int id);

    List<ConsultationResponseDTO> getConsultationHistoryByPatient(int patientId);

    ConsultationResponseDTO getConsultationByAppointment(int appointmentId);
}