package com.brawlstars.asylum.service;

import com.brawlstars.asylum.model.Appointment;
import com.brawlstars.asylum.model.AppointmentStatus;
import com.brawlstars.asylum.model.Treatment;
import com.brawlstars.asylum.repository.AppointmentRepository;
import com.brawlstars.asylum.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Treatment> getAllTreatmentsForPatient(String email) {
        return treatmentRepository.findAllByPatientEmail(email);
    }

    public List<Treatment> getAllTreatmentsForDoctor(String email) {
        return treatmentRepository.findAllByDoctorUserEmail(email);
    }

    public Treatment getLastTreatmentForPatient(String email) {
        var temp = treatmentRepository.findAllByPatientEmail(email);
        if (temp.size() == 0) {
            return null;
        }
        return temp.get(temp.size() - 1);
    }

    public void deleteTreatmentById(int id){
        treatmentRepository.deleteById(id);
    }

    @Transactional
    public Treatment createTreatment(int appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId);
        Treatment treatment = new Treatment();
        treatment.setPatient(appointment.getPatient());
        treatment.setDoctor(appointment.getDoctor());
        treatment.setStartOfTreatment(appointment.getDate());
        treatment.setEndOfTreatment(Calendar.getInstance());
        treatment = treatmentRepository.save(treatment);
        appointment.setStatus(AppointmentStatus.ACCEPTED);
        return treatment;
    }

    public Treatment getTreatmentById(int treatmentId) {
        return treatmentRepository.findById(treatmentId);
    }

    public void saveTreatment(Treatment treatmentModel) {
        treatmentRepository.save(treatmentModel);
    }
}
