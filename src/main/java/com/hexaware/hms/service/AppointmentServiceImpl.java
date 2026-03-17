package com.hexaware.hms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hms.dao.IAppointmentDAO;
import com.hexaware.hms.dto.AppointmentRequestDTO;
import com.hexaware.hms.dto.AppointmentResponseDTO;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.AppointmentStatus;
import com.hexaware.hms.entity.Doctor;
import com.hexaware.hms.entity.Patient;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    private IAppointmentDAO appointmentDAO;

    // =========================
    // ENTITY → DTO
    // =========================

    public AppointmentResponseDTO convertToDTO(Appointment appointment) {

        AppointmentResponseDTO dto = new AppointmentResponseDTO();

        dto.setAppointmentId(appointment.getAppointmentId());
        dto.setPatientId(appointment.getPatient().getPatientId());
        dto.setDoctorId(appointment.getDoctor().getDoctorId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setSymptoms(appointment.getSymptoms());
        dto.setVisitType(appointment.getVisitType());
        dto.setStatus(appointment.getStatus());

        return dto;
    }

    // =========================
    // DTO → ENTITY
    // =========================

    public Appointment convertToEntity(AppointmentRequestDTO dto) {

        Appointment appointment = new Appointment();

        Patient patient = new Patient();
        patient.setPatientId(dto.getPatientId());

        Doctor doctor = new Doctor();
        doctor.setDoctorId(dto.getDoctorId());

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setSymptoms(dto.getSymptoms());
        appointment.setVisitType(dto.getVisitType());
        appointment.setStatus(dto.getStatus());

        return appointment;
    }

    // =========================
    // CRUD OPERATIONS
    // =========================

    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO dto) {

        Appointment appointment = convertToEntity(dto);
        appointment.setStatus(AppointmentStatus.CONFIRMED);

        Appointment saved = appointmentDAO.save(appointment);

        return convertToDTO(saved);
    }

    @Override
    public AppointmentResponseDTO getAppointmentById(int id) {

        Appointment appointment = appointmentDAO.findById(id).orElse(null);

        if (appointment != null) {
            return convertToDTO(appointment);
        }

        return null;
    }

    @Override
    public List<AppointmentResponseDTO> getAllAppointments() {

        List<Appointment> list = appointmentDAO.findAll();

        return list.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentResponseDTO updateAppointment(int id, AppointmentRequestDTO dto) {

        Optional<Appointment> optional = appointmentDAO.findById(id);

        if (optional.isPresent()) {

            Appointment appointment = optional.get();

            appointment.setAppointmentDate(dto.getAppointmentDate());
            appointment.setSymptoms(dto.getSymptoms());
            appointment.setVisitType(dto.getVisitType());
            appointment.setStatus(dto.getStatus());

            Appointment updated = appointmentDAO.save(appointment);

            return convertToDTO(updated);
        }

        return null;
    }

    @Override
    public void cancelAppointment(int id) {

        Optional<Appointment> optional = appointmentDAO.findById(id);

        if (optional.isPresent()) {

            Appointment appointment = optional.get();
            appointment.setStatus(AppointmentStatus.CANCELLED);

            appointmentDAO.save(appointment);
        }
    }

    // =========================
    // FILTER METHODS
    // =========================

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByPatient(int patientId) {

        return appointmentDAO.findByPatient_PatientId(patientId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByDoctor(int doctorId) {

        return appointmentDAO.findByDoctor_DoctorId(doctorId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByStatus(AppointmentStatus status) {

        return appointmentDAO.findByStatus(status)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // =========================
    // DATE METHODS
    // =========================

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByDate(LocalDate date) {

        return appointmentDAO.findByAppointmentDate(date)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponseDTO> getUpcomingAppointments() {

        return appointmentDAO.findByAppointmentDateAfter(LocalDateTime.now())
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponseDTO> getPastAppointments() {

        return appointmentDAO.findByAppointmentDateBefore(LocalDateTime.now())
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // =========================
    // BUSINESS LOGIC
    // =========================

    @Override
    public boolean rescheduleAppointment(int id, LocalDateTime newDate) {

        Optional<Appointment> optional = appointmentDAO.findById(id);

        if (optional.isPresent()) {

            Appointment appointment = optional.get();

            if (appointment.getStatus() != AppointmentStatus.CANCELLED) {

                appointment.setAppointmentDate(newDate);
                appointment.setStatus(AppointmentStatus.CONFIRMED);

                appointmentDAO.save(appointment);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean changeStatus(int id, AppointmentStatus status) {

        Optional<Appointment> optional = appointmentDAO.findById(id);

        if (optional.isPresent()) {

            Appointment appointment = optional.get();

            appointment.setStatus(status);

            appointmentDAO.save(appointment);

            return true;
        }

        return false;
    }

    // =========================
    // DASHBOARD
    // =========================

    @Override
    public int getTotalAppointments() {
        return (int) appointmentDAO.count();
    }
}