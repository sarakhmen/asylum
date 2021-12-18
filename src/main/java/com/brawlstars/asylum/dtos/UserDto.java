package com.brawlstars.asylum.dtos;

import com.brawlstars.asylum.model.Appointment;
import com.brawlstars.asylum.model.Doctor;
import com.brawlstars.asylum.model.Treatment;
import lombok.Data;

import java.util.Calendar;
import java.util.Set;

@Data
public class UserDto {

    private Integer id;

    private String firstName;

    private String secondName;

    private String patronymic;

    private String email;

    private String address;

    private String phone;

    private Calendar dateOfBirth;

    private Boolean active;

    private DoctorDto doctor;

    private Set<TreatmentDto> treatments;

    private Set<AppointmentDto> appointments;
}
