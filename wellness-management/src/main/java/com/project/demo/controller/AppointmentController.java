package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.demo.entity.Appointment;
import com.project.demo.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestParam String email, @RequestBody Appointment appointment) {
        return appointmentService.bookAppointment(email, appointment);
    }

    @GetMapping("/user/{email}")
    public List<Appointment> getAppointmentsByUserEmail(@PathVariable String email) {
        return appointmentService.getAppointmentsByUserEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(id, appointment);
    }
}
