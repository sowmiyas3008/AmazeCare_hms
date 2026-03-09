package com.hexaware.hms.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.entity.Patient;
import com.hexaware.hms.service.IPatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @PostMapping
    public Patient addPatient(@RequestBody Patient p) {
        return patientService.addPatient(p);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable int id,
                                 @RequestBody Patient p) {
        return patientService.updatePatient(id, p);
    }

    @GetMapping("/{id}")
    public Patient getByPatientId(@PathVariable int id) {
        return patientService.getByPatientId(id);
    }

    @GetMapping("/user/{userId}")
    public Patient getByUserId(@PathVariable int userId) {
        return patientService.getByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return "Patient deleted";
    }

    @GetMapping("/age/{id}")
    public int calculateAge(@PathVariable int id) {
        return patientService.calculateAge(id);
    }

    @GetMapping("/above-age/{age}")
    public List<Patient> getPatientsAboveAge(@PathVariable int age) {
        return patientService.getPatientsAboveAge(age);
    }

    @GetMapping("/search/{name}")
    public List<Patient> searchPatientsByName(@PathVariable String name) {
        return patientService.searchPatientsByName(name);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
}
