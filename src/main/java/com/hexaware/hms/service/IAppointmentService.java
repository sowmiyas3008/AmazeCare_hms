package com.hexaware.hms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.AppointmentStatus;

public interface IAppointmentService {

    // CRUD
    Appointment bookAppointment(Appointment appointment);
    Appointment getAppointmentById(int id);
    List<Appointment> getAllAppointments();
    Appointment updateAppointment(int id, Appointment appointment);
    void cancelAppointment(int id);

    // Filters
    List<Appointment> getAppointmentsByPatient(int patientId);
    List<Appointment> getAppointmentsByDoctor(int doctorId);
    List<Appointment> getAppointmentsByStatus(AppointmentStatus status);

    // Time based
    List<Appointment> getAppointmentsByDate(LocalDate date);
    List<Appointment> getUpcomingAppointments();
    List<Appointment> getPastAppointments();

    // Business logic
    boolean rescheduleAppointment(int id, LocalDateTime newDate);
    boolean changeStatus(int id, AppointmentStatus status);

    // Dashboard
    int getTotalAppointments();
}