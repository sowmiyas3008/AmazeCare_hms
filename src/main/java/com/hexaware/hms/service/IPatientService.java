package com.hexaware.hms.service;
import java.util.*;

import com.hexaware.hms.entity.Patient;

public interface IPatientService {
	public Patient addPatient(Patient p);
	public Patient updatePatient(int id,Patient p);
	
	public Patient getByUserId(int userId);
	public Patient getByPatientId(int pid);
	
	public void deletePatient(int id);
	
	int calculateAge(int patientId);
	List<Patient> getPatientsAboveAge(int age);
	
	List<Patient> searchPatientsByName(String name);
	 
	List<Patient> getAllPatients();

}
