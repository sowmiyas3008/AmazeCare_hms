package com.hexaware.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.SpecializationRequestDTO;
import com.hexaware.hms.dto.SpecializationResponseDTO;
import com.hexaware.hms.service.ISpecializationService;

@RestController
@RequestMapping("/specializations")
public class SpecializationController {

    @Autowired
    private ISpecializationService specializationService;

    @PostMapping
    public SpecializationResponseDTO addSpecialization(@RequestBody SpecializationRequestDTO specialization) {
        return specializationService.addSpecialization(specialization);
    }

    @GetMapping("/{id}")
    public SpecializationResponseDTO getById(@PathVariable int id) {
        return specializationService.getById(id);
    }

    @GetMapping
    public List<SpecializationResponseDTO> getAll() {
        return specializationService.getAll();
    }

    @PutMapping("/{id}")
    public SpecializationResponseDTO updateSpecialization(
            @PathVariable int id,
            @RequestBody SpecializationRequestDTO specialization) {

        return specializationService.updateSpecialization(id, specialization);
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