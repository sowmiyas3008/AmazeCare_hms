package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.DoctorRequestDTO;
import com.hexaware.hms.dto.DoctorResponseDTO;

@SpringBootTest
class DoctorServiceImplTest {

    @Autowired
    private IDoctorService service;

    @Test
    void testAddDoctor() {

        DoctorRequestDTO d = new DoctorRequestDTO();

        d.setName("Dr Rina");
        d.setSpeciality("Cardiology");
        d.setExperienceYears(10);
        d.setQualification("MD");
        d.setDesignation("Consultant");
        d.setPhone("1234567890");

        DoctorResponseDTO saved = service.addDoctor(d);

        assertNotNull(saved);
    }

    @Test
    void testGetDoctorById() {

        DoctorResponseDTO doctor = service.getDoctorById(1);

        assertNotNull(doctor);
    }

    @Test
    void testUpdateDoctor() {

        DoctorRequestDTO updated = new DoctorRequestDTO();
        updated.setName("updated doctor");

        DoctorResponseDTO res = service.updateDoctor(1, updated);

        assertEquals("updated doctor", res.getName());
    }

    @Test
    void testDeleteDoctor() {

        service.deleteDoctor(4);

        DoctorResponseDTO del = service.getDoctorById(4);

        assertNull(del);
    }

    @Test
    void testGetDoctorByUserId() {

        DoctorResponseDTO d = service.getDoctorByUserId(2);

        assertNotNull(d);
    }

    @Test
    void testGetDoctorsBySpecialtiy() {

        List<DoctorResponseDTO> d = service.getDoctorsBySpeciality("Cardiology");

        assertNotNull(d);
    }

    @Test
    void testGetDoctorsByQualification() {

        List<DoctorResponseDTO> list = service.getDoctorsByQualification("MD");

        assertNotNull(list);
    }

    @Test
    void testGetExperiencedDoctors() {

        List<DoctorResponseDTO> list = service.getExperiencedDoctors(5);

        assertNotNull(list);
    }

    @Test
    void testGetDoctorsByDesignation() {

        List<DoctorResponseDTO> list = service.getDoctorsByDesignation("Consultant");

        assertNotNull(list);
    }

    @Test
    void testGetDoctorCount() {

        int count = service.getDoctorCount();

        assertTrue(count >= 0);
    }

}