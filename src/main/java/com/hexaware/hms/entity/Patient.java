package com.hexaware.hms.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name="patients")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
    private int patientId;
	
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
	
	@Column(name="full_name")
    private String fullName;
	
	@Column(name="dob")
    private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender")
    private Gender gender;
	
	@Column(name="phone")
    private String phone;
	
	@Column(name="address")
    private String address;
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments;

    public Patient() {}

	public Patient(int patientId, User user, String fullName, LocalDate dob, Gender gender, String phone,
			String address, List<Appointment> appointments) {
		super();
		this.patientId = patientId;
		this.user = user;
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.appointments = appointments;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

    
}