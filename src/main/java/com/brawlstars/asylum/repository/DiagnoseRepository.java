package com.brawlstars.asylum.repository;

import com.brawlstars.asylum.model.Diagnose;
import com.brawlstars.asylum.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiagnoseRepository extends JpaRepository<Diagnose, Integer> {
    Optional<Diagnose> findByName(String name);
    Optional<Diagnose> findByNameAndDescription(String name, String description);

}
