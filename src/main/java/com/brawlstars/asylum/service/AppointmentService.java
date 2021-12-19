package com.brawlstars.asylum.service;

import com.brawlstars.asylum.model.Appointment;
import com.brawlstars.asylum.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointmentsByUserEmail(String email) {
        return appointmentRepository.findAllByUserEmail(email);
    }
    public void deleteAppointmentById(long appointmentId){
        Appointment appointment = appointmentRepository.getById((int)appointmentId);
        this.appointmentRepository.delete(appointment);

    }

}
