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

    //    @Query(value = "select A.date, (select secondName from User where D.id = id)," +
    //            "U.secondName, D.position from Appointment as A inner join Doctor as D on D.id = A.id inner join User as U on U.id = A.id")
    List<Appointment> findAllByUserEmail(String email);

    Optional<Appointment> findAppointmentByDoctor_UserEmailAndDate(String email, Calendar date);
}
