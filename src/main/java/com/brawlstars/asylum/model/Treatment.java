package com.brawlstars.asylum.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "methods_of_treatment")
    private String methodsOfTreatment;

    @Temporal(TemporalType.DATE)
    @Column(name = "treatment_start")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Calendar startOfTreatment;

    @Temporal(TemporalType.DATE)
    @Column(name = "treatment_end")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Calendar endOfTreatment;

    @Column(name = "chamber")
    private Integer chamber;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "user_id")
    private User patient;

    @ManyToMany(cascade = CascadeType.MERGE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(name = "treatment_diagnose",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id"))
    private Set<Diagnose> diagnoses;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
