package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.entity.ConsultationTest;

@SpringBootTest
class ConsultationTestServiceImplTest {

    @Autowired
    private IConsultationTestService service;

    @Test
    void testAddTestToConsultation() {

        ConsultationTest ct = new ConsultationTest();
        
        ct.setConsultationId(1);
        ct.setTestId(2);

        ConsultationTest saved = service.addTestToConsultation(ct);

        assertNotNull(saved);
        assertEquals(1, saved.getConsultationId());

    }

    @Test
    void testGetTestsByConsultation() {

        List<ConsultationTest> tests = service.getTestsByConsultation(1);

        assertNotNull(tests);
        assertTrue(tests.size() >= 0);
    }

}