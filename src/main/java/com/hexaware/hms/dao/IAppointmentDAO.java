package com.hexaware.hms.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.AppointmentStatus;

public interface IAppointmentDAO extends JpaRepository<Appointment, Integer> {
	List<Appointment> findByPatient_PatientId(int patientId);

	List<Appointment> findByDoctor_DoctorId(int doctorId);

	List<Appointment> findByStatus(AppointmentStatus status);

	List<Appointment> findByAppointmentDate(LocalDate date);

	List<Appointment> findByAppointmentDateAfter(LocalDateTime date);

	List<Appointment> findByAppointmentDateBefore(LocalDateTime date);

}