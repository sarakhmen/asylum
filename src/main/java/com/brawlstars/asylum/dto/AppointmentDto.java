package com.brawlstars.asylum.dto;

import lombok.Data;

import java.util.Calendar;

@Data
public class AppointmentDto {

    int id;

    Calendar dateOfAppointment;

    DoctorDto doctor;

    UserDto patient;
}
