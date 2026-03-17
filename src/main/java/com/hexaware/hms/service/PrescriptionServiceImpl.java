package com.hexaware.hms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IPrescriptionDAO;
import com.hexaware.hms.dto.PrescriptionRequestDTO;
import com.hexaware.hms.dto.PrescriptionResponseDTO;
import com.hexaware.hms.entity.Consultation;
import com.hexaware.hms.entity.Prescription;

@Service
public class PrescriptionServiceImpl implements IPrescriptionService {

    @Autowired
    private IPrescriptionDAO prescriptionDAO;

    @Override
    public PrescriptionResponseDTO addPrescription(PrescriptionRequestDTO dto) {

        Prescription p = new Prescription();

        Consultation consultation = new Consultation();
        consultation.setConsultationId(dto.getConsultationId());

        p.setConsultation(consultation);
        p.setMedicineId(dto.getMedicineId());
        p.setDosage(dto.getDosage());
        p.setInstructions(dto.getInstructions());
        p.setDuration_days(dto.getDurationDays());

        Prescription saved = prescriptionDAO.save(p);

        return mapToDTO(saved);
    }

    @Override
    public List<PrescriptionResponseDTO> getByConsultation(int consultationId) {

        return prescriptionDAO.findByConsultation_ConsultationId(consultationId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private PrescriptionResponseDTO mapToDTO(Prescription p) {

        PrescriptionResponseDTO dto = new PrescriptionResponseDTO();

        dto.setPrescriptionId(p.getPrescriptionId());
        dto.setConsultationId(p.getConsultation().getConsultationId());
        dto.setMedicineId(p.getMedicineId());
        dto.setDosage(p.getDosage());
        dto.setInstructions(p.getInstructions());
        dto.setDurationDays(p.getDuration_days());

        return dto;
    }
}