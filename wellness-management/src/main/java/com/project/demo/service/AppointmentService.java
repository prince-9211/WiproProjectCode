package com.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entity.Appointment;
import com.project.demo.entity.User;
import com.project.demo.reposiotary.AppointmentRepository;
import com.project.demo.reposiotary.UserRepository;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    public Appointment bookAppointment(String email, Appointment appointment) {
        User user = userRepository.findById(email).orElseThrow(() -> new RuntimeException("User not found"));
        appointment.setUser(user);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByUserEmail(String email) {
        return appointmentRepository.findByUserEmail(email);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        if (appointmentRepository.existsById(id)) {
            appointment.setId(id);
            return appointmentRepository.save(appointment);
        }
        throw new RuntimeException("Appointment not found");
    }
}
