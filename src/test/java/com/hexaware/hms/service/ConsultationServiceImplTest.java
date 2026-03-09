package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.hms.entity.Consultation;

class ConsultationServiceImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
    private IConsultationService service;

	@Test
	void testAddConsultation() {
		Consultation c = new Consultation();
		c.setDiagnosis("Flu");
		c.setPhysicalExam("tests done");
		c.setSymptoms(" high fever, cold");
		c.setTreatmentPlan("weekly consultations");
		Consultation res = service.addConsultation(c);
		assertNotNull(res);
	}

	@Test
	void testGetConsultationById() {
		Consultation c = service.getConsultationById(1);
		assertNotNull(c);
	}

	@Test
	void testUpdateConsultation() {
		Consultation c = new Consultation();
		c.setSymptoms("high fever, cold, diarhoea");
		Consultation res = service.updateConsultation(1,c);
		assertNotNull(res);
		
	}

	@Test
	void testDeleteConsultation() {
		
	}

}
