package com.brawlstars.asylum.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "diagnos")
public class Diagnos {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

}
