package com.hexaware.hms.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.entity.ConsultationTest;
import com.hexaware.hms.service.IConsultationTestService;

@RestController
@RequestMapping("/consultationTests")
public class ConsultationTestController {

    @Autowired
    private IConsultationTestService consultationTestService;

    @PostMapping
    public ConsultationTest addTest(@RequestBody ConsultationTest ct) {
        return consultationTestService.addTestToConsultation(ct);
    }

    @GetMapping("/{consultationId}")
    public List<ConsultationTest> getTestsByConsultation(@PathVariable int consultationId) {
        return consultationTestService.getTestsByConsultation(consultationId);
    }
}