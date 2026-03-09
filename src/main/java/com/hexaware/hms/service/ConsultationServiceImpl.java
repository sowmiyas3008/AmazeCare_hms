package com.hexaware.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IConsultationDAO;
import com.hexaware.hms.entity.Consultation;
import com.hexaware.hms.service.IConsultationService;

@Service
public class ConsultationServiceImpl implements IConsultationService {

    @Autowired
    private IConsultationDAO consultationDAO;

    @Override
    public Consultation addConsultation(Consultation consultation) {
        return consultationDAO.save(consultation);
    }

    @Override
    public Consultation getConsultationById(int id) {
        return consultationDAO.findById(id).orElse(null);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationDAO.findAll();
    }

    @Override
    public Consultation updateConsultation(int id, Consultation consultation) {
        Consultation existing = consultationDAO.findById(id).orElse(null);

        if (existing!=null) {
            existing.setDiagnosis(consultation.getDiagnosis());
            existing.setSymptoms(consultation.getSymptoms());
            existing.setPhysicalExam(consultation.getPhysicalExam());
            existing.setTreatmentPlan(consultation.getTreatmentPlan());
            
            
            return consultationDAO.save(existing);
        }
		return null;
    }

    @Override
    public void deleteConsultation(int id) {
        consultationDAO.deleteById(id);
    }

    @Override
    public List<Consultation> getConsultationHistoryByPatient(int patientId) {
        return consultationDAO.findByAppointment_Patient_PatientId(patientId);
    }

    @Override
    public Consultation getConsultationByAppointment(int appointmentId) {
        return consultationDAO.findByAppointment_AppointmentId(appointmentId);
    }
}