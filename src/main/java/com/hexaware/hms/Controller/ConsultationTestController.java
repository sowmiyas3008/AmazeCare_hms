package com.hexaware.hms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.ConsultationTestRequestDTO;
import com.hexaware.hms.dto.ConsultationTestResponseDTO;
import com.hexaware.hms.service.IConsultationTestService;

@RestController
@RequestMapping("/consultationTests")
public class ConsultationTestController {

    @Autowired
    private IConsultationTestService consultationTestService;

    @PostMapping
    public ConsultationTestResponseDTO addTest(@RequestBody ConsultationTestRequestDTO dto) {

        return consultationTestService.addTestToConsultation(dto);
    }

    @GetMapping("/{consultationId}")
    public List<ConsultationTestResponseDTO> getTestsByConsultation(@PathVariable int consultationId) {

        return consultationTestService.getTestsByConsultation(consultationId);
    }
}