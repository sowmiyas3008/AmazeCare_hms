package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.MedicalTestRequestDTO;
import com.hexaware.hms.dto.MedicalTestResponseDTO;

@SpringBootTest
class MedicalTestServiceImplTest {

    @Autowired
    private IMedicalTestService service;

    @Test
    void testAddTest() {

        // Request DTO
        MedicalTestRequestDTO request = new MedicalTestRequestDTO();
        request.setTestName("Blood Test");

        // Service call
        MedicalTestResponseDTO response = service.addTest(request);

        // Assertions
        assertNotNull(response);
        assertEquals("Blood Test", response.getTestName());
    }

}