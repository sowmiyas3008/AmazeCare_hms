package com.hexaware.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.ConsultationRequestDTO;
import com.hexaware.hms.dto.ConsultationResponseDTO;
import com.hexaware.hms.service.IConsultationService;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private IConsultationService consultationService;

    @PostMapping
    public ConsultationResponseDTO addConsultation(
            @RequestBody ConsultationRequestDTO consultation) {

        return consultationService.addConsultation(consultation);
    }

    @GetMapping("/{id}")
    public ConsultationResponseDTO getConsultationById(@PathVariable int id) {

        return consultationService.getConsultationById(id);
    }

    @GetMapping
    public List<ConsultationResponseDTO> getAllConsultations() {

        return consultationService.getAllConsultations();
    }

    @PutMapping("/{id}")
    public ConsultationResponseDTO updateConsultation(
            @PathVariable int id,
            @RequestBody ConsultationRequestDTO consultation) {

        return consultationService.updateConsultation(id, consultation);
    }

    @DeleteMapping("/{id}")
    public String deleteConsultation(@PathVariable int id) {

        consultationService.deleteConsultation(id);

        return "Consultation deleted";
    }

    @GetMapping("/patient/{patientId}")
    public List<ConsultationResponseDTO> getConsultationHistoryByPatient(
            @PathVariable int patientId) {

        return consultationService.getConsultationHistoryByPatient(patientId);
    }

    @GetMapping("/appointment/{appointmentId}")
    public ConsultationResponseDTO getConsultationByAppointment(
            @PathVariable int appointmentId) {

        return consultationService.getConsultationByAppointment(appointmentId);
    }
}