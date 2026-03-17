package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.SpecializationRequestDTO;
import com.hexaware.hms.dto.SpecializationResponseDTO;

@SpringBootTest
class SpecializationServiceImplTest {

    @Autowired
    private ISpecializationService service;

    @Test
    void testAddSpecialization() {

        SpecializationRequestDTO dto = new SpecializationRequestDTO();
        dto.setName("Cardiology");

        SpecializationResponseDTO result = service.addSpecialization(dto);

        assertNotNull(result);
        assertEquals("Cardiology", result.getName());
    }

    @Test
    void testGetById() {

        SpecializationResponseDTO s = service.getById(1);

        assertNotNull(s);
    }
}