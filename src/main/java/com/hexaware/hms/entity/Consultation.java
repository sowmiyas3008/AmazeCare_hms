package com.hexaware.hms.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="consultations")
public class Consultation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consultation_id")
    private int consultationId;
	
    @OneToOne
    @JoinColumn(name = "appointment_id", unique = true)
    private Appointment appointment;
    

    
    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;
    
    @Column(name="symptoms")
    private String symptoms;
    
    @Column(name="physical_exam")
    private String physicalExam;
    
    @Column(name="diagnosis")
    private String diagnosis;
    
    @Column(name="treatment_plan")
    private String treatmentPlan;

    public Consultation() {}

	public int getConsultationId() {
		return consultationId;
	}

	public void setConsultationId(int consultationId) {
		this.consultationId = consultationId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getPhysicalExam() {
		return physicalExam;
	}

	public void setPhysicalExam(String physicalExam) {
		this.physicalExam = physicalExam;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatmentPlan() {
		return treatmentPlan;
	}

	public void setTreatmentPlan(String treatmentPlan) {
		this.treatmentPlan = treatmentPlan;
	}

    
}



