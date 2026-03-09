package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.hms.entity.Prescription;

class PrescriptionServiceImplTest {

	static PrescriptionServiceImpl service;

	@BeforeAll
	static void setUpBeforeClass() {
		service = new PrescriptionServiceImpl();
	}

	@Test
	void testAddPrescription() {

		Prescription p = new Prescription();
		p.setConsultationId(1);
		p.setMedicineId(1);
		p.setDosage("1 tablet");
		p.setInstructions("After food");
		p.setDurationDays(5);

		boolean result = service.addPrescription(p);

		assertTrue(result);
	}

	@Test
	void testGetByConsultation() {

		List<Prescription> prescriptions = service.getByConsultation(1);

		assertNotNull(prescriptions);
	}

}