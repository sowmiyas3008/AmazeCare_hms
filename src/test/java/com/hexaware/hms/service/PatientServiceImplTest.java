package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.PatientRequestDTO;
import com.hexaware.hms.dto.PatientResponseDTO;
import com.hexaware.hms.entity.Gender;

@SpringBootTest
class PatientServiceImplTest {

    @Autowired
    private IPatientService service;

    @Test
    void testAddPatient() {

        PatientRequestDTO dto = new PatientRequestDTO();
        dto.setUserId(1);
        dto.setFullName("John Doe");
        dto.setDob(LocalDate.of(1995, 5, 10));
        dto.setGender(Gender.MALE);
        dto.setPhone("9876543210");
        dto.setAddress("Chennai");

        PatientResponseDTO saved = service.addPatient(dto);

        assertNotNull(saved);
        assertEquals("John Doe", saved.getFullName());
    }

    @Test
    void testUpdatePatient() {

        PatientRequestDTO dto = new PatientRequestDTO();
        dto.setFullName("John Updated");
        dto.setPhone("9999999999");
        dto.setDob(LocalDate.of(1995, 5, 10));
        dto.setGender(Gender.MALE);
        dto.setAddress("Chennai");

        PatientResponseDTO updated = service.updatePatient(1, dto);

        assertNotNull(updated);
        assertEquals("9999999999", updated.getPhone());
    }

    @Test
    void testGetByUserId() {

        PatientResponseDTO p = service.getByUserId(1);

        assertNotNull(p);
    }

    @Test
    void testGetByPatientId() {

        PatientResponseDTO p = service.getByPatientId(1);

        assertNotNull(p);
    }

    @Test
    void testDeletePatient() {

        service.deletePatient(1);

        PatientResponseDTO p = service.getByPatientId(1);

        assertNull(p);
    }

    @Test
    void testCalculateAge() {

        int age = service.calculateAge(1);

        assertTrue(age >= 0);
    }

    @Test
    void testGetPatientsAboveAge() {

        List<PatientResponseDTO> list = service.getPatientsAboveAge(30);

        assertNotNull(list);
    }

    @Test
    void testSearchPatientsByName() {

        List<PatientResponseDTO> list = service.searchPatientsByName("John");

        assertNotNull(list);
    }
}