package com.brawlstars.asylum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    @Size(min = 0)
    int id;

    @NotNull(message = "*Please provide a date of birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    Calendar dateOfAppointment;

    @Valid
    DoctorDto doctor;

    @Valid
    UserDto patient;
}
