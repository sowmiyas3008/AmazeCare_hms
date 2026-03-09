package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.hms.entity.Specialization;

class SpecializationServiceImplTest {

	static SpecializationServiceImpl service;

	@BeforeAll
	static void setUpBeforeClass() {
		service = new SpecializationServiceImpl();
	}

	@Test
	void testAddSpecialization() {

		Specialization s = new Specialization();
		s.setName("Cardiology");

		Specialization result = service.addSpecialization(s);

		assertNotNull(result);
	}

	@Test
	void testGetById() {

		Specialization s = service.getById(1);

		assertNotNull(s);
	}

	@Test
	void testUpdateSpecialization() {

		Specialization s = service.getById(1);

		if (s != null) {
			s.setName("Neurology");
			Specialization result = service.updateSpecialization(s);
			assertEquals("Neurology",result.getName());
		} else {
			fail("Specialization not found");
		}
	}


	@Test
	void testGetDoctorCount() {

		int count = service.getDoctorCount(1);

		assertTrue(count >= 0);
	}

}