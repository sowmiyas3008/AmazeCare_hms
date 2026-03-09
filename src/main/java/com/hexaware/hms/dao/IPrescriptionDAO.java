package com.hexaware.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.Prescription;

public interface IPrescriptionDAO extends JpaRepository<Prescription, Integer> {
	List<Prescription> findByConsultation_ConsultationId(int consultationId);
}