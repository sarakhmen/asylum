package com.brawlstars.asylum.dtos;

import com.brawlstars.asylum.model.Doctor;

import java.util.Calendar;

public class AppointmentDto {

    Calendar dateOfAppointment;

    DoctorDto doctor;

    UserDto patient;
}
