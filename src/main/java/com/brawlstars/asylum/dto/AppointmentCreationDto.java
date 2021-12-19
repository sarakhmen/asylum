package com.brawlstars.asylum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentCreationDto {

    @NotNull(message = "*Please provide a patient's email")
    String patientEmail;

    @NotNull(message = "*Please provide a patient's email")
    String doctorEmail;

    @NotNull(message = "*Please provide a date of birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    Calendar dateOfAppointment;
}
