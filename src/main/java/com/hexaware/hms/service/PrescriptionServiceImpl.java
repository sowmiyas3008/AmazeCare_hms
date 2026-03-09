package com.hexaware.hms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexaware.hms.dao.IPrescriptionDAO;
import com.hexaware.hms.entity.Prescription;
import com.hexaware.hms.service.IPrescriptionService;

@Service
public class PrescriptionServiceImpl implements IPrescriptionService {

    @Autowired
    private IPrescriptionDAO prescriptionDAO;

    public Prescription addPrescription(Prescription prescription) {
        return prescriptionDAO.save(prescription);
    }

    public List<Prescription> getByConsultation(int consultationId) {
        return prescriptionDAO.findByConsultation_ConsultationId(consultationId);
    }
}