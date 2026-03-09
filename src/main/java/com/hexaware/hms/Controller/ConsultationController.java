package com.hexaware.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.entity.Consultation;
import com.hexaware.hms.service.IConsultationService;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private IConsultationService consultationService;

    @PostMapping
    public Consultation addConsultation(@RequestBody Consultation consultation) {
        return consultationService.addConsultation(consultation);
    }

    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable int id) {
        return consultationService.getConsultationById(id);
    }

    @GetMapping
    public List<Consultation> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @PutMapping("/{id}")
    public Consultation updateConsultation(@PathVariable int id,
                                           @RequestBody Consultation consultation) {
        return consultationService.updateConsultation(id, consultation);
    }

    @DeleteMapping("/{id}")
    public String deleteConsultation(@PathVariable int id) {
        consultationService.deleteConsultation(id);
        return "Consultation deleted";
    }

    @GetMapping("/patient/{patientId}")
    public List<Consultation> getConsultationHistoryByPatient(@PathVariable int patientId) {
        return consultationService.getConsultationHistoryByPatient(patientId);
    }

    @GetMapping("/appointment/{appointmentId}")
    public Consultation getConsultationByAppointment(@PathVariable int appointmentId) {
        return consultationService.getConsultationByAppointment(appointmentId);
    }
}