package com.hexaware.hms.service;

import java.util.List;
import com.hexaware.hms.entity.Consultation;

public interface IConsultationService {

    Consultation addConsultation(Consultation consultation);
    Consultation getConsultationById(int id);
    List<Consultation> getAllConsultations();
    Consultation updateConsultation(int id, Consultation consultation);
    void deleteConsultation(int id);

    // ⭐ MAIN FEATURE
    List<Consultation> getConsultationHistoryByPatient(int patientId);

    // Useful
    Consultation getConsultationByAppointment(int appointmentId);
}