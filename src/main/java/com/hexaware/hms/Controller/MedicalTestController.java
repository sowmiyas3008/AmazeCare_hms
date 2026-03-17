package com.hexaware.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.MedicalTestRequestDTO;
import com.hexaware.hms.dto.MedicalTestResponseDTO;
import com.hexaware.hms.service.IMedicalTestService;

@RestController
@RequestMapping("/medicalTests")
public class MedicalTestController {

    @Autowired
    private IMedicalTestService medicalTestService;

    @PostMapping
    public MedicalTestResponseDTO addTest(@RequestBody MedicalTestRequestDTO test) {
        return medicalTestService.addTest(test);
    }

    @GetMapping
    public List<MedicalTestResponseDTO> getAllTests() {
        return medicalTestService.getAllTests();
    }
}