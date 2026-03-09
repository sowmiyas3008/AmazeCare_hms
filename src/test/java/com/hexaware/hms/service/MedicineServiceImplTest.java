package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.entity.Medicine;

@SpringBootTest
class MedicineServiceImplTest {

    @Autowired
    private IMedicineService service;

    @Test
    void testAddMedicine() {

        Medicine med = new Medicine();
        med.setName("Paracetamol");

        Medicine saved = service.addMedicine(med);

        assertNotNull(saved);
        assertEquals("Paracetamol", saved.getName());
    }
}