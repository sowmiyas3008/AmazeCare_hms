package com.hexaware.hms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IAppointmentDAO;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.AppointmentStatus;
import com.hexaware.hms.service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private IAppointmentDAO appointmentDAO;

    // ========================
    // CRUD OPERATIONS
    // ========================

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.CONFIRMED);
        return appointmentDAO.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(int id) {
        Optional<Appointment> optional = appointmentDAO.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.findAll();
    }

    @Override
    public Appointment updateAppointment(int id, Appointment appointment) {
        Optional<Appointment> existing = appointmentDAO.findById(id);

        if (existing.isPresent()) {
            Appointment appt = existing.get();
            appt.setAppointmentDate(appointment.getAppointmentDate());
            appt.setStatus(appointment.getStatus());
            return appointmentDAO.save(appt);
        }

        return null;
    }

    @Override
    public void cancelAppointment(int id) {
        Optional<Appointment> optional = appointmentDAO.findById(id);
        if (optional.isPresent()) {
            Appointment appt = optional.get();
            appt.setStatus(AppointmentStatus.CANCELLED);
            appointmentDAO.save(appt);
        }
    }

    // ========================
    // FILTER METHODS
    // ========================

    @Override
    public List<Appointment> getAppointmentsByPatient(int patientId) {
        return appointmentDAO.findByPatient_PatientId(patientId);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        return appointmentDAO.findByDoctor_DoctorId(doctorId);
    }

    @Override
    public List<Appointment> getAppointmentsByStatus(AppointmentStatus status) {
        return appointmentDAO.findByStatus(status);
    }

    // ========================
    // TIME BASED METHODS
    // ========================

    @Override
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointmentDAO.findByAppointmentDate(date);
    }

    @Override
    public List<Appointment> getUpcomingAppointments() {
        return appointmentDAO.findByAppointmentDateAfter(LocalDateTime.now());
    }

    @Override
    public List<Appointment> getPastAppointments() {
        return appointmentDAO.findByAppointmentDateBefore(LocalDateTime.now());
    }

    // ========================
    // BUSINESS LOGIC
    // ========================

    @Override
    public boolean rescheduleAppointment(int id, LocalDateTime newDate) {
        Optional<Appointment> optional = appointmentDAO.findById(id);

        if (optional.isPresent()) {
            Appointment appt = optional.get();

            if (appt.getStatus() != AppointmentStatus.CANCELLED) {
                appt.setAppointmentDate(newDate);
                appt.setStatus(AppointmentStatus.CONFIRMED);
                appointmentDAO.save(appt);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeStatus(int id, AppointmentStatus status) {
        Optional<Appointment> optional = appointmentDAO.findById(id);

        if (optional.isPresent()) {
            Appointment appt = optional.get();
            appt.setStatus(status);
            appointmentDAO.save(appt);
            return true;
        }
        return false;
    }

    // ========================
    // DASHBOARD
    // ========================

    @Override
    public int getTotalAppointments() {
        return (int) appointmentDAO.count();
    }
}