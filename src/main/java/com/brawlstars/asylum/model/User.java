package com.brawlstars.asylum.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Calendar;
import java.util.Set;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    @NotEmpty(message = "*First name cannot be empty")
    private String firstname;

    @Column(name = "secondname")
    @NotEmpty(message = "*Second name cannot be empty")
    private String secondname;

    @Column(name = "patronymic")
    @NotEmpty(message = "*Patronymic name cannot be empty")
    private String patronymic;

    @Column(name = "firstname")
    @NotEmpty(message = "*First name cannot be empty")
    private String address;

    @Column(name = "phone")
    @NotEmpty(message = "*Phone name cannot be empty")
    private String phone;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    @NotEmpty(message = "*Birth date name cannot be empty")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Calendar dateOfBirth;

    @Column(name = "active")
    @ColumnDefault(value = "true")
    private Boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
