package com.hexaware.hms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IConsultationDAO;
import com.hexaware.hms.dto.ConsultationRequestDTO;
import com.hexaware.hms.dto.ConsultationResponseDTO;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.Consultation;

@Service
public class ConsultationServiceImpl implements IConsultationService {

    @Autowired
    private IConsultationDAO consultationDAO;

    // ENTITY → DTO
    public ConsultationResponseDTO convertToDTO(Consultation consultation) {

        ConsultationResponseDTO dto = new ConsultationResponseDTO();

        dto.setConsultationId(consultation.getConsultationId());
        dto.setAppointmentId(consultation.getAppointment().getAppointmentId());
        dto.setPatientId(consultation.getAppointment().getPatient().getPatientId());
        dto.setDoctorId(consultation.getAppointment().getDoctor().getDoctorId());

        dto.setSymptoms(consultation.getSymptoms());
        dto.setPhysicalExam(consultation.getPhysicalExam());
        dto.setDiagnosis(consultation.getDiagnosis());
        dto.setTreatmentPlan(consultation.getTreatmentPlan());

        return dto;
    }

    // DTO → ENTITY
    public Consultation convertToEntity(ConsultationRequestDTO dto) {

        Consultation consultation = new Consultation();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(dto.getAppointmentId());

        consultation.setAppointment(appointment);
        consultation.setSymptoms(dto.getSymptoms());
        consultation.setPhysicalExam(dto.getPhysicalExam());
        consultation.setDiagnosis(dto.getDiagnosis());
        consultation.setTreatmentPlan(dto.getTreatmentPlan());

        return consultation;
    }

    @Override
    public ConsultationResponseDTO addConsultation(ConsultationRequestDTO dto) {

        Consultation consultation = convertToEntity(dto);

        Consultation saved = consultationDAO.save(consultation);

        return convertToDTO(saved);
    }

    @Override
    public ConsultationResponseDTO getConsultationById(int id) {

        Consultation consultation = consultationDAO.findById(id).orElse(null);

        if (consultation != null) {
            return convertToDTO(consultation);
        }

        return null;
    }

    @Override
    public List<ConsultationResponseDTO> getAllConsultations() {

        return consultationDAO.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultationResponseDTO updateConsultation(int id, ConsultationRequestDTO dto) {

        Optional<Consultation> optional = consultationDAO.findById(id);

        if (optional.isPresent()) {

            Consultation consultation = optional.get();

            consultation.setSymptoms(dto.getSymptoms());
            consultation.setPhysicalExam(dto.getPhysicalExam());
            consultation.setDiagnosis(dto.getDiagnosis());
            consultation.setTreatmentPlan(dto.getTreatmentPlan());

            Consultation updated = consultationDAO.save(consultation);

            return convertToDTO(updated);
        }

        return null;
    }

    @Override
    public void deleteConsultation(int id) {
        consultationDAO.deleteById(id);
    }

    @Override
    public List<ConsultationResponseDTO> getConsultationHistoryByPatient(int patientId) {

        return consultationDAO.findByAppointment_Patient_PatientId(patientId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultationResponseDTO getConsultationByAppointment(int appointmentId) {

        Consultation consultation =
                consultationDAO.findByAppointment_AppointmentId(appointmentId);

        if (consultation != null) {
            return convertToDTO(consultation);
        }

        return null;
    }
}