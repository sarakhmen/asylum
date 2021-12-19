package com.brawlstars.asylum.service;

import com.brawlstars.asylum.model.RequestAppointment;
import com.brawlstars.asylum.repository.RequestAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestAppointmentService {

    private RequestAppointmentRepository requestAppointmentRepository;

    @Autowired
    RequestAppointmentService(RequestAppointmentRepository requestAppointmentRepository){
        this.requestAppointmentRepository = requestAppointmentRepository;
    }

    public void save(RequestAppointment requestAppointment){
        requestAppointmentRepository.save(requestAppointment);
    }
}
