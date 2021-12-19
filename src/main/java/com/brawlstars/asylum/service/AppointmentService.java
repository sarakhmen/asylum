package com.brawlstars.asylum.service;

import com.brawlstars.asylum.model.Appointment;
import com.brawlstars.asylum.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointmentsByDoctorEmail(String email) {
        return appointmentRepository.findAllByDoctorUserEmail(email);
    }

    public List<Appointment> getAllAppointmentsByPatientEmail(String email) {
        return appointmentRepository.findAllByPatientEmail(email);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentByDate(String doctorEmail, Calendar date) {
        return appointmentRepository.findAppointmentByDoctor_UserEmailAndDate(doctorEmail, date);
    }

    public void deleteAppointmentById(int appointmentId){
        appointmentRepository.deleteById(appointmentId);
    }

}
