package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.MedicineRequestDTO;
import com.hexaware.hms.dto.MedicineResponseDTO;

@SpringBootTest
class MedicineServiceImplTest {

    @Autowired
    private IMedicineService service;

    @Test
    void testAddMedicine() {

        // Request DTO
        MedicineRequestDTO request = new MedicineRequestDTO();
        request.setName("Paracetamol");

        // Service Call
        MedicineResponseDTO response = service.addMedicine(request);

        // Assertions
        assertNotNull(response);
        assertEquals("Paracetamol", response.getName());
    }
}