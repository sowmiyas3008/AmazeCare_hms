package com.hexaware.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.Consultation;

public interface IConsultationDAO extends JpaRepository<Consultation, Integer> {
	List<Consultation> findByAppointment_Patient_PatientId(int patientId);

	Consultation findByAppointment_AppointmentId(int appointmentId);
}