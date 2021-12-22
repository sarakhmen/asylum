package com.brawlstars.asylum.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "diagnose")
public class Diagnose {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
