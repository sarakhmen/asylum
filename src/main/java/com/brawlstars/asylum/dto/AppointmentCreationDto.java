package com.brawlstars.asylum.dto;

import lombok.Data;

import java.util.Calendar;

@Data
public class AppointmentCreationDto {
    String patientEmail;
    String doctorEmail;
    Calendar appointmentDate;
}
