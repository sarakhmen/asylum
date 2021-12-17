package com.brawlstars.asylum.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "experience")
    private Integer experience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "doctor")
    private Set<Treatment> treatments;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;

}
