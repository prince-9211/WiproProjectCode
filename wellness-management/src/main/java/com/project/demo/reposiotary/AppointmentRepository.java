package com.project.demo.reposiotary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByUserEmail(String email);
	}

