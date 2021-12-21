package com.brawlstars.asylum.repository;

import com.brawlstars.asylum.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    List<Treatment> findAllByPatientEmail(String email);
    void deleteById(int id);
    Treatment findById(int id);
}
