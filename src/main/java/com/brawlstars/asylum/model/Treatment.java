package com.brawlstars.asylum.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Data
@Entity
@Table(name = "treatment")
public class Treatment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "methods_of_treatment")
    private String methodsOfTreatment;

    @Temporal(TemporalType.DATE)
    @Column(name = "treatment_start")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Calendar startOfTreatment;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "chamber")
    private Integer chamber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private Set<Diagnos> diagnoses;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
