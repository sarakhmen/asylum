package com.brawlstars.asylum.repository;

import com.brawlstars.asylum.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    void deleteById(int id);
    List<Appointment> findAllByDoctorUserEmail(String doctorEmail);
    List<Appointment> findAllByPatientEmail(String doctorEmail);
    List<Appointment> findAll();
    Optional<Appointment> findAppointmentByDoctor_UserEmailAndDate(String email, Calendar date);
}
