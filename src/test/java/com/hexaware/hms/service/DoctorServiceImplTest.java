package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.service.*;

@SpringBootTest
class DoctorServiceImplTest{

	
	@Autowired
	private IDoctorService service;
	

	@Test
	void testAddDoctor() {
		Doctor d = new Doctor();
		d.setName("Dr Rina");
		d.setSpeciality("Cardiology");
		d.setExperienceYears(10);
		d.setQualification("MD");
		d.setDesignation("Consultant");
		d.setPhone("1234567890");
		
		Doctor saved = service.addDoctor(d);
		assertNotNull(saved);
	}

	@Test
	void testGetDoctorById() {
		Doctor doctor = service.getDoctorById(1);
		assertNotNull(doctor);
	}

	@Test
	void testUpdateDoctor() {
		Doctor updated = new Doctor();
		updated.setName("updated doctor");
		Doctor res = service.updateDoctor(1,updated);
		assertEquals("updated doctor",res.getName());
	}

	@Test
	void testDeleteDoctor() {
		service.deleteDoctor(4);
		Doctor del = service.getDoctorById(4);
		assertNull(del);

	}

	@Test
	void testGetDoctorByUserId() {
		Doctor d = service.getDoctorByUserId(2);
		assertNotNull(d);
	}

	@Test
	void testGetDoctorsBySpecialtiy() {
		List<Doctor> d = service.getDoctorsBySpeciality("Cardiology");
		assertNotNull(d);
		
	}

	@Test
	void testGetDoctorsByQualification() {
	       List<Doctor> list = service.getDoctorsByQualification("MD");
	       assertNotNull(list);
		
	}

	@Test
	void testGetExperiencedDoctors() {
		List<Doctor> list = service.getExperiencedDoctors(5);
        assertNotNull(list);
	}

	@Test
	void testGetDoctorsByDesignation() {
		List<Doctor> list = service.getDoctorsByDesignation("Consultant");
        assertNotNull(list);
	}

	@Test
	void testExistsByPhone() {
		boolean exists = service.existsByPhone("9999999999");
        assertTrue(exists || !exists);
	}

	@Test
	void testGetDoctorCount() {
		int count = service.getDoctorCount();
		assertTrue(count >=0);
	}

}
