package com.hexaware.hms.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.entity.MedicalTest;
import com.hexaware.hms.service.IMedicalTestService;

@RestController
@RequestMapping("/medicalTests")
public class MedicalTestController {

    @Autowired
    private IMedicalTestService medicalTestService;

    @PostMapping
    public MedicalTest addTest(@RequestBody MedicalTest test) {
        return medicalTestService.addTest(test);
    }

    @GetMapping
    public List<MedicalTest> getAllTests() {
        return medicalTestService.getAllTests();
    }
}
