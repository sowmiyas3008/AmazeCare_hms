package com.hexaware.hms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.AppointmentStatus;
import com.hexaware.hms.entity.Patient;
import com.hexaware.hms.entity.Doctor;

@SpringBootTest
class AppointmentServiceImplTest {

    @Autowired
    private IAppointmentService service;

    @Test
    void testBookAppointment() {

        Appointment appt = new Appointment();
        appt.setAppointmentDate(LocalDateTime.now().plusDays(1));
        appt.setStatus(AppointmentStatus.CONFIRMED);

        Appointment saved = service.bookAppointment(appt);

        assertNotNull(saved);
        assertTrue(saved.getAppointmentId() > 0);
    }

    @Test
    void testGetAppointmentById() {

        Appointment appt = service.getAppointmentById(1);

        assertNotNull(appt);
    }

    @Test
    void testUpdateAppointment() {

        Appointment appt = service.getAppointmentById(1);

        appt.setStatus(AppointmentStatus.COMPLETED);

        Appointment updated = service.updateAppointment(1,appt);

        assertEquals("Completed", updated.getStatus());
    }

    @Test
    void testCancelAppointment() {

        service.cancelAppointment(1);

        Appointment appt = service.getAppointmentById(1);

        assertEquals("Cancelled", appt.getStatus());
    }

    @Test
    void testGetAppointmentsByPatient() {

        List<Appointment> list = service.getAppointmentsByPatient(1);

        assertNotNull(list);
    }

    @Test
    void testGetAppointmentsByDoctor() {

        List<Appointment> list = service.getAppointmentsByDoctor(1);

        assertNotNull(list);
    }

    @Test
    void testGetAppointmentsByStatus() {

        List<Appointment> list = service.getAppointmentsByStatus(AppointmentStatus.CONFIRMED);

        assertNotNull(list);
    }

    @Test
    void testGetAppointmentsByDate() {

        List<Appointment> list = service.getAppointmentsByDate(LocalDateTime.now().toLocalDate());

        assertNotNull(list);
    }

    @Test
    void testGetUpcomingAppointments() {

        List<Appointment> list = service.getUpcomingAppointments();

        assertNotNull(list);
    }

    @Test
    void testGetPastAppointments() {

        List<Appointment> list = service.getPastAppointments();

        assertNotNull(list);
    }

    @Test
    void testRescheduleAppointment() {

        boolean appt = service.rescheduleAppointment(1, LocalDateTime.now().plusDays(3));

        assertEquals(true, appt);
    }

    @Test
    void testChangeStatus() {

        boolean appt = service.changeStatus(1, AppointmentStatus.COMPLETED);

        assertEquals(true, appt);
    }

}