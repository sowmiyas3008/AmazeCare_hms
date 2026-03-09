package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.entity.MedicalTest;

@SpringBootTest
class MedicalTestServiceImplTest {

    @Autowired
    private IMedicalTestService service;

    @Test
    void testAddTest() {

        MedicalTest test = new MedicalTest();
        test.setTestName("Blood Test");

        MedicalTest savedTest = service.addTest(test);

        assertNotNull(savedTest);
        assertEquals("Blood Test", savedTest.getTestName());
    }

}