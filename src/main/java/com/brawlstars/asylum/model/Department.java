package com.brawlstars.asylum.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Doctor> doctors;
}
