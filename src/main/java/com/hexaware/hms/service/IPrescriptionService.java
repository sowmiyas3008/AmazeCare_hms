package com.hexaware.hms.service;

import java.util.List;
import com.hexaware.hms.entity.Prescription;

public interface IPrescriptionService {

    Prescription addPrescription(Prescription prescription);

    List<Prescription> getByConsultation(int consultationId);
    
//    List<Prescription> findByConsultationId(int consultationId);
}