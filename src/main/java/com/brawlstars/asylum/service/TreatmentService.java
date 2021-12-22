package com.brawlstars.asylum.service;

import com.brawlstars.asylum.model.Appointment;
import com.brawlstars.asylum.model.AppointmentStatus;
import com.brawlstars.asylum.model.Diagnose;
import com.brawlstars.asylum.model.Treatment;
import com.brawlstars.asylum.repository.AppointmentRepository;
import com.brawlstars.asylum.repository.DiagnoseRepository;
import com.brawlstars.asylum.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DiagnoseRepository diagnoseRepository;

    public List<Treatment> getAllTreatmentsForPatient(String email) {
        return treatmentRepository.findAllByPatientEmail(email);
    }

    public List<Treatment> getAllTreatmentsForDoctor(String email) {
        return treatmentRepository.findAllByDoctorUserEmail(email);
    }

    public void deleteTreatmentById(int id) {
        treatmentRepository.deleteById(id);
    }

    public Treatment getLastTreatmentForPatient(String email) {
        var temp = treatmentRepository.findAllByPatientEmail(email);
        if (temp.size() == 0) {
            return null;
        }
        return temp.get(temp.size() - 1);
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

    @Transactional
    public void deleteDiagnoseForTreatment(int treatmentId, int diagnoseId) {
        Treatment treatment = treatmentRepository.findById(treatmentId);
        treatment.setDiagnoses(treatment.getDiagnoses().stream().filter(x -> x.getId() != diagnoseId).collect(Collectors.toSet()));
    }

    public Treatment getTreatmentById(int treatmentId) {
        return treatmentRepository.findById(treatmentId);
    }

    public void saveTreatment(Treatment treatmentModel) {
        treatmentRepository.save(treatmentModel);
    }

    @Transactional
    public void addDiagnose(Diagnose diagnose, int treatmentId) {
        Optional<Diagnose> existingDiagnose = diagnoseRepository.findByNameAndDescription(diagnose.getName(),
                Optional.ofNullable(diagnose.getDescription()).orElse(""));
        Treatment treatment = treatmentRepository.findById(treatmentId);
        treatment.getDiagnoses().add(existingDiagnose.orElseGet(() -> diagnoseRepository.save(diagnose)));
    }
}
