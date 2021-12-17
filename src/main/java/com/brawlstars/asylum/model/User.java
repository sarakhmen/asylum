package com.brawlstars.asylum.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Calendar;
import java.util.Set;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email", unique = true)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 6 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "*First name cannot be empty")
    private String firstName;

    @Column(name = "second_name")
    @NotEmpty(message = "*Second name cannot be empty")
    private String secondName;

    @Column(name = "patronymic")
    @NotEmpty(message = "*Patronymic name cannot be empty")
    private String patronymic;

    @Column(name = "address")
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
