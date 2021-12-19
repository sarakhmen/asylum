package com.brawlstars.asylum.repository;

import com.brawlstars.asylum.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//    @Query(value = "select A.date, (select secondName from User where D.id = id)," +
//            "U.secondName, D.position from Appointment as A inner join Doctor as D on D.id = A.id inner join User as U on U.id = A.id")

    List<Appointment> findAllByUserEmail(String email);
}
