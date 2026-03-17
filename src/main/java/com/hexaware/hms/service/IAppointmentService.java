package com.hexaware.hms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.hms.dto.AppointmentRequestDTO;
import com.hexaware.hms.dto.AppointmentResponseDTO;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.AppointmentStatus;

public interface IAppointmentService {

    // CRUD
    AppointmentResponseDTO bookAppointment(AppointmentRequestDTO dto);
    AppointmentResponseDTO getAppointmentById(int id);
    List<AppointmentResponseDTO> getAllAppointments();
    AppointmentResponseDTO updateAppointment(int id, AppointmentRequestDTO dto);
    void cancelAppointment(int id);

    // Filters
    List<AppointmentResponseDTO> getAppointmentsByPatient(int patientId);
    List<AppointmentResponseDTO> getAppointmentsByDoctor(int doctorId);
    List<AppointmentResponseDTO> getAppointmentsByStatus(AppointmentStatus status);

    // Time based
    List<AppointmentResponseDTO> getAppointmentsByDate(LocalDate date);
    List<AppointmentResponseDTO> getUpcomingAppointments();
    List<AppointmentResponseDTO> getPastAppointments();

    // Business logic
    boolean rescheduleAppointment(int id, LocalDateTime newDate);
    boolean changeStatus(int id, AppointmentStatus status);

    // Dashboard
    int getTotalAppointments();
}