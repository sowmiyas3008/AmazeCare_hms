package com.hexaware.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.PrescriptionRequestDTO;
import com.hexaware.hms.dto.PrescriptionResponseDTO;
import com.hexaware.hms.service.IPrescriptionService;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private IPrescriptionService prescriptionService;

    @PostMapping
    public PrescriptionResponseDTO addPrescription(@RequestBody PrescriptionRequestDTO prescription) {
        return prescriptionService.addPrescription(prescription);
    }

    @GetMapping("/{consultationId}")
    public List<PrescriptionResponseDTO> getByConsultation(@PathVariable int consultationId) {
        return prescriptionService.getByConsultation(consultationId);
    }
}