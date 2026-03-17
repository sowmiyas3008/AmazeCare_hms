package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.PrescriptionRequestDTO;
import com.hexaware.hms.dto.PrescriptionResponseDTO;

@SpringBootTest
class PrescriptionServiceImplTest {

    @Autowired
    private IPrescriptionService service;

    @Test
    void testAddPrescription() {

        PrescriptionRequestDTO dto = new PrescriptionRequestDTO();

        dto.setConsultationId(1);
        dto.setMedicineId(1);
        dto.setDosage("1 tablet");
        dto.setInstructions("After food");
        dto.setDurationDays(5);

        PrescriptionResponseDTO result = service.addPrescription(dto);

        assertNotNull(result);
        assertEquals("1 tablet", result.getDosage());
    }

    @Test
    void testGetByConsultation() {

        List<PrescriptionResponseDTO> prescriptions =
                service.getByConsultation(1);

        assertNotNull(prescriptions);
    }
}