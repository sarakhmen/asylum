package com.brawlstars.asylum.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Position {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "position")
    private Set<Doctor> doctors;
}
