package com.hexaware.hms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name="appointments")
public class Appointment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private int appointmentId;
	
	
	@OneToOne(mappedBy = "appointment")
	private Consultation consultation;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	
	@Column(name="appointment_date")
    private LocalDateTime appointmentDate;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
    
	@Column(name="symptoms")
    private String symptoms;
	
	@Column(name="visit_type")
    private String visitType;
	
	@Column(name="status")
    private AppointmentStatus status;

    public Appointment() {}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}


    
}




