package com.hexaware.hms.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hms.dto.AppointmentRequestDTO;
import com.hexaware.hms.dto.AppointmentResponseDTO;
import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.entity.AppointmentStatus;
import com.hexaware.hms.service.IAppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private IAppointmentService service;
	
	@PostMapping
	public AppointmentResponseDTO bookAppointment(@RequestBody AppointmentRequestDTO appointment) {
		return service.bookAppointment(appointment);
	}
	
	@GetMapping("/{id}")
	public AppointmentResponseDTO getAppointmentById(@PathVariable int id) {
		return service.getAppointmentById(id);
	}
	
	@GetMapping
	public List<AppointmentResponseDTO> getAllAppointments(){
		return service.getAllAppointments();
	}
	
	@PutMapping("/{id}")
	public AppointmentResponseDTO updateAppointment(@PathVariable int id, @RequestBody AppointmentRequestDTO appointment) {
		return service.updateAppointment(id, appointment);
	}
	
	@DeleteMapping("/{id}")
	public String cancelAppointment(@PathVariable int id) {
		service.cancelAppointment(id);
		return "Appointment cancelled successfully";
		
	}
	
	@GetMapping("/patients/{id}")
	public List<AppointmentResponseDTO> getAppointmentByPatient(@PathVariable int id){
		return service.getAppointmentsByPatient(id);
	}
	
	@GetMapping("/doctors/{id}")
	public List<AppointmentResponseDTO> getAppointmentByDoctor(@PathVariable int id){
		return service.getAppointmentsByDoctor(id);
	}
	
    @GetMapping("/date/{date}")
    public List<AppointmentResponseDTO> getAppointmentsByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return service.getAppointmentsByDate(localDate);
    }

 
    @GetMapping("/upcoming")
    public List<AppointmentResponseDTO> getUpcomingAppointments() {
        return service.getUpcomingAppointments();
    }


    @GetMapping("/past")
    public List<AppointmentResponseDTO> getPastAppointments() {
        return service.getPastAppointments();
    }
	
    @PutMapping("/reschedule/{id}")
    public String rescheduleAppointment(@PathVariable int id,
                                        @RequestParam String newDate) {

        LocalDateTime dateTime = LocalDateTime.parse(newDate);

        boolean result =service.rescheduleAppointment(id, dateTime);

        if (result)
            return "Appointment rescheduled successfully";
        else
            return "Reschedule failed";
    }
    
    @PutMapping("/status/{id}")
    public String changeStatus(@PathVariable int id,
                               @RequestParam AppointmentStatus status) {

        boolean result =service.changeStatus(id, status);

        if (result)
            return "Status updated";
        else
            return "Update failed";
    }
    
    @GetMapping("/count")
    public int getTotalAppointments() {
        return service.getTotalAppointments();
    }
	
	
	

}
