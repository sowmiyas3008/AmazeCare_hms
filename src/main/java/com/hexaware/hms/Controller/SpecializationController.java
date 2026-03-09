package com.hexaware.hms.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.entity.Specialization;
import com.hexaware.hms.service.ISpecializationService;

@RestController
@RequestMapping("/specializations")
public class SpecializationController {

    @Autowired
    private ISpecializationService specializationService;

    @PostMapping
    public Specialization addSpecialization(@RequestBody Specialization specialization) {
        return specializationService.addSpecialization(specialization);
    }

    @GetMapping("/{id}")
    public Specialization getById(@PathVariable int id) {
        return specializationService.getById(id);
    }

    @GetMapping
    public List<Specialization> getAll() {
        return specializationService.getAll();
    }

    @PutMapping
    public Specialization updateSpecialization(@RequestBody Specialization specialization) {
        return specializationService.updateSpecialization(specialization);
    }

    @DeleteMapping("/{id}")
    public String deleteSpecialization(@PathVariable int id) {
        specializationService.deleteSpecialization(id);
        return "Specialization deleted";
    }

    @GetMapping("/doctor-count/{id}")
    public int getDoctorCount(@PathVariable int id) {
        return specializationService.getDoctorCount(id);
    }
}
