package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.dto.AppointmentRequestDTO;
import com.hexaware.hms.dto.AppointmentResponseDTO;
import com.hexaware.hms.entity.AppointmentStatus;

@SpringBootTest
class AppointmentServiceImplTest {

    @Autowired
    private IAppointmentService service;

    @Test
    void testBookAppointment() {

        AppointmentRequestDTO appt = new AppointmentRequestDTO();
        appt.setAppointmentDate(LocalDateTime.now().plusDays(1));
        appt.setStatus(AppointmentStatus.CONFIRMED);
        appt.setDoctorId(1);
        appt.setPatientId(1);

        AppointmentResponseDTO saved = service.bookAppointment(appt);

        assertNotNull(saved);
        assertTrue(saved.getAppointmentId() > 0);
    }

    @Test
    void testGetAppointmentById() {

        AppointmentResponseDTO appt = service.getAppointmentById(1);

        assertNotNull(appt);
    }

    @Test
    void testUpdateAppointment() {

        AppointmentRequestDTO appt = new AppointmentRequestDTO();
        appt.setAppointmentDate(LocalDateTime.now().plusDays(2));
        appt.setStatus(AppointmentStatus.COMPLETED);
        appt.setDoctorId(1);
        appt.setPatientId(1);

        AppointmentResponseDTO updated = service.updateAppointment(1, appt);

        assertEquals(AppointmentStatus.COMPLETED, updated.getStatus());
    }

    @Test
    void testCancelAppointment() {

        service.cancelAppointment(1);

        AppointmentResponseDTO appt = service.getAppointmentById(1);

        assertEquals(AppointmentStatus.CANCELLED, appt.getStatus());
    }

    @Test
    void testGetAppointmentsByPatient() {

        List<AppointmentResponseDTO> list = service.getAppointmentsByPatient(1);

        assertNotNull(list);
    }

    @Test
    void testGetAppointmentsByDoctor() {

        List<AppointmentResponseDTO> list = service.getAppointmentsByDoctor(1);

        assertNotNull(list);
    }

    @Test
    void testGetAppointmentsByDate() {

        List<AppointmentResponseDTO> list =
                service.getAppointmentsByDate(LocalDate.now());

        assertNotNull(list);
    }

    @Test
    void testGetUpcomingAppointments() {

        List<AppointmentResponseDTO> list = service.getUpcomingAppointments();

        assertNotNull(list);
    }

    @Test
    void testGetPastAppointments() {

        List<AppointmentResponseDTO> list = service.getPastAppointments();

        assertNotNull(list);
    }

    @Test
    void testRescheduleAppointment() {

        boolean appt =
                service.rescheduleAppointment(1, LocalDateTime.now().plusDays(3));

        assertTrue(appt);
    }

    @Test
    void testChangeStatus() {

        boolean appt = service.changeStatus(1, AppointmentStatus.COMPLETED);

        assertTrue(appt);
    }

}