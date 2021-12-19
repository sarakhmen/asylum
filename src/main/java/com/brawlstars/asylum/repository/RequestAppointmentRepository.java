package com.brawlstars.asylum.repository;

import com.brawlstars.asylum.model.RequestAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestAppointmentRepository extends JpaRepository<RequestAppointment, Integer> {
}
