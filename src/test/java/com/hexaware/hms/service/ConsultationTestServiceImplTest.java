package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.ConsultationTestRequestDTO;
import com.hexaware.hms.dto.ConsultationTestResponseDTO;

@SpringBootTest
class ConsultationTestServiceImplTest {

    @Autowired
    private IConsultationTestService service;

    @Test
    void testAddTestToConsultation() {

        ConsultationTestRequestDTO ct = new ConsultationTestRequestDTO();
        ct.setConsultationId(1);
        ct.setTestId(2);

        ConsultationTestResponseDTO saved = service.addTestToConsultation(ct);

        assertNotNull(saved);
    }

    @Test
    void testGetTestsByConsultation() {

        List<ConsultationTestResponseDTO> tests = service.getTestsByConsultation(1);

        assertNotNull(tests);
    }

}