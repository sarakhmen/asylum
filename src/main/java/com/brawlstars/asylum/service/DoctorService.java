package com.brawlstars.asylum.service;

import com.brawlstars.asylum.model.Doctor;
import com.brawlstars.asylum.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorByUserEmail(String email){
        return doctorRepository.findDoctorByUserEmail(email);
    }

    public List<Doctor> getAllDoctorsByPosition(String position){
        return doctorRepository.findAllByPositionName(position);
    }
}
