package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.entity.Patient;
import com.hexaware.hms.entity.Gender;

@SpringBootTest
class PatientServiceImplTest {

    @Autowired
    private IPatientService service;

    @Test
    void testAddPatient() {

        Patient p = new Patient();
        p.setFullName("John Doe");
        p.setDob(LocalDate.of(1995, 5, 10));
        p.setGender(Gender.MALE);
        p.setPhone("9876543210");
        p.setAddress("Chennai");

        Patient saved = service.addPatient(p);

        assertNotNull(saved);
        assertEquals("John Doe", saved.getFullName());
    }

    @Test
    void testUpdatePatient() {

        Patient p = service.getByPatientId(1);
        p.setPhone("9999999999");

        Patient updated = service.updatePatient(p);

        assertEquals("9999999999", updated.getPhone());
    }

    @Test
    void testGetByUserId() {

        Patient p = service.getByUserId(1);

        assertNotNull(p);
    }

    @Test
    void testGetByPatientId() {

        Patient p = service.getByPatientId(1);

        assertNotNull(p);
    }

    @Test
    void testDeletePatient() {

        service.deletePatient(1);

        Patient p = service.getByPatientId(1);

        assertNull(p);
    }

    @Test
    void testCalculateAge() {

        Patient p = new Patient();
        p.setDob(LocalDate.of(2000, 1, 1));

        int age = service.calculateAge(p);

        assertTrue(age > 0);
    }

    @Test
    void testGetPatientsAboveAge() {

        List<Patient> list = service.getPatientsAboveAge(30);

        assertNotNull(list);
    }

    @Test
    void testSearchPatientsByName() {

        List<Patient> list = service.searchPatientsByName("John");

        assertNotNull(list);
    }
}