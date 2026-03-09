package com.hexaware.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.service.IDoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	
	@Autowired
	private IDoctorService service;
	
	@PostMapping
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return service.addDoctor(doctor);
	}
	
	@GetMapping("/{id}")
	public Doctor getDoctoById(@PathVariable int id) {
		return service.getDoctorById(id);
	}
	
	@GetMapping
	public List<Doctor> getAllDoctors(){
		return service.getAllDoctors();
	}
	
	@PutMapping("/{id}")
	public Doctor updateDoctor(@PathVariable int id,@RequestBody Doctor doctor) {
		return service.updateDoctor(id, doctor);
	}
	
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable int id) {
        service.deleteDoctor(id);
        return "Doctor deleted";
    }

    @GetMapping("/user/{userId}")
    public Doctor getDoctorByUserId(@PathVariable int userId) {
        return service.getDoctorByUserId(userId);
    }

    @GetMapping("/speciality/{speciality}")
    public List<Doctor> getDoctorsBySpeciality(@PathVariable String speciality) {
        return service.getDoctorsBySpeciality(speciality);
    }

    @GetMapping("/qualification/{qualification}")
    public List<Doctor> getDoctorsByQualification(@PathVariable String qualification) {
        return service.getDoctorsByQualification(qualification);
    }

    @GetMapping("/experience/{years}")
    public List<Doctor> getExperiencedDoctors(@PathVariable int years) {
        return service.getExperiencedDoctors(years);
    }

    @GetMapping("/designation/{designation}")
    public List<Doctor> getDoctorsByDesignation(@PathVariable String designation) {
        return service.getDoctorsByDesignation(designation);
    }

    @GetMapping("/count")
    public int getDoctorCount() {
        return service.getDoctorCount();
    }
	
	
}
