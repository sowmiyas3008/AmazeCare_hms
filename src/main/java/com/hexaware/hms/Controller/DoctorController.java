package com.hexaware.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.DoctorRequestDTO;
import com.hexaware.hms.dto.DoctorResponseDTO;
import com.hexaware.hms.service.IDoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private IDoctorService service;

    @PostMapping
    public DoctorResponseDTO addDoctor(@RequestBody DoctorRequestDTO doctor) {
        return service.addDoctor(doctor);
    }

    @GetMapping("/{id}")
    public DoctorResponseDTO getDoctorById(@PathVariable int id) {
        return service.getDoctorById(id);
    }

    @GetMapping
    public List<DoctorResponseDTO> getAllDoctors() {
        return service.getAllDoctors();
    }

    @PutMapping("/{id}")
    public DoctorResponseDTO updateDoctor(@PathVariable int id,
                                           @RequestBody DoctorRequestDTO doctor) {
        return service.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable int id) {
        service.deleteDoctor(id);
        return "Doctor deleted";
    }

    @GetMapping("/user/{userId}")
    public DoctorResponseDTO getDoctorByUserId(@PathVariable int userId) {
        return service.getDoctorByUserId(userId);
    }

    @GetMapping("/speciality/{speciality}")
    public List<DoctorResponseDTO> getDoctorsBySpeciality(@PathVariable String speciality) {
        return service.getDoctorsBySpeciality(speciality);
    }

    @GetMapping("/qualification/{qualification}")
    public List<DoctorResponseDTO> getDoctorsByQualification(@PathVariable String qualification) {
        return service.getDoctorsByQualification(qualification);
    }

    @GetMapping("/experience/{years}")
    public List<DoctorResponseDTO> getExperiencedDoctors(@PathVariable int years) {
        return service.getExperiencedDoctors(years);
    }

    @GetMapping("/designation/{designation}")
    public List<DoctorResponseDTO> getDoctorsByDesignation(@PathVariable String designation) {
        return service.getDoctorsByDesignation(designation);
    }

    @GetMapping("/count")
    public int getDoctorCount() {
        return service.getDoctorCount();
    }
}