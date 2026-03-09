package com.hexaware.hms.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doctor_id")
    private int doctorId;
	
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;
	
	
	@OneToOne
	@JoinColumn(name="user_id")
    private User user;
	
	
	@ManyToOne
	@JoinColumn(name = "specializationId")
	private Specialization specialization;
	
	@Column(name="name")
    private String name;
	
	@Column(name="speciality")
    private String speciality;
	
	@Column(name="experience_years")
    private int experienceYears;
	
	@Column(name="qualification")
    private String qualification;
	
	@Column(name="designation")
    private String designation;
	
	@Column(name="phone")
    private String phone;


    public Doctor() {}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Specialization getSpecialization() {
		return specialization;
	}


	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public int getExperienceYears() {
		return experienceYears;
	}


	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

    
}
