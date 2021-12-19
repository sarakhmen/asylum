package com.brawlstars.asylum.repository;

import com.brawlstars.asylum.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAll();
    List<Doctor> findAllByPositionName(String positionName);
    Doctor findDoctorByUserEmail(String email);
}
