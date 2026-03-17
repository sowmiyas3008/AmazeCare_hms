package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.ConsultationRequestDTO;
import com.hexaware.hms.dto.ConsultationResponseDTO;

@SpringBootTest
class ConsultationServiceImplTest {

    @Autowired
    private IConsultationService service;

    @Test
    void testAddConsultation() {

        ConsultationRequestDTO c = new ConsultationRequestDTO();

        c.setDiagnosis("Flu");
        c.setPhysicalExam("tests done");
        c.setSymptoms("high fever, cold");
        c.setTreatmentPlan("weekly consultations");
        c.setAppointmentId(1);

        ConsultationResponseDTO res = service.addConsultation(c);

        assertNotNull(res);
        assertTrue(res.getConsultationId() > 0);
    }

    @Test
    void testGetConsultationById() {

        ConsultationResponseDTO c = service.getConsultationById(1);

        assertNotNull(c);
    }

    @Test
    void testUpdateConsultation() {

        ConsultationRequestDTO c = new ConsultationRequestDTO();
        c.setSymptoms("high fever, cold, diarrhoea");

        ConsultationResponseDTO res = service.updateConsultation(1, c);

        assertNotNull(res);
    }

    @Test
    void testDeleteConsultation() {

        service.deleteConsultation(1);

        ConsultationResponseDTO c = service.getConsultationById(1);

        assertNotNull(c);
    }

    @Test
    void testGetConsultationHistoryByPatient() {

        List<ConsultationResponseDTO> list =
                service.getConsultationHistoryByPatient(1);

        assertNotNull(list);
    }

}