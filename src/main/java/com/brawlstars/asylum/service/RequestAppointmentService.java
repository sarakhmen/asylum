package com.brawlstars.asylum.service;

import com.brawlstars.asylum.model.AppointmentStatus;
import com.brawlstars.asylum.model.RequestAppointment;
import com.brawlstars.asylum.repository.RequestAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestAppointmentService {

    private RequestAppointmentRepository requestAppointmentRepository;

    @Autowired
    RequestAppointmentService(RequestAppointmentRepository requestAppointmentRepository){
        this.requestAppointmentRepository = requestAppointmentRepository;
    }
    public List<RequestAppointment> getAllRequestAppointments() {
        return requestAppointmentRepository.findAll();
    }

    public List<RequestAppointment> getAllRequestAppointmentsByPatientEmail(String email) {
        return requestAppointmentRepository.findAllByUserEmail(email);
    }
    public void declineRequestAppointment(long id){
        RequestAppointment requestAppointment = requestAppointmentRepository.getById((int) id);
        requestAppointmentRepository.delete(requestAppointment);
        requestAppointment.setStatus(AppointmentStatus.DECLINED);
        requestAppointmentRepository.save(requestAppointment);
    }
    public void deleteRequestAppointmentById(int appointmentId){
        requestAppointmentRepository.deleteById(appointmentId);
    }
    public RequestAppointment getById(int requestAppointmentId){
        return requestAppointmentRepository.getById(requestAppointmentId);
    }

    public void save(RequestAppointment requestAppointment){
        requestAppointmentRepository.save(requestAppointment);
    }
}
