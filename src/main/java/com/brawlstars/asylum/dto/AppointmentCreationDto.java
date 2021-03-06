package com.brawlstars.asylum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentCreationDto {

    Integer id;

    @NotNull(message = "*Please provide a patient's email")
    String patientEmail;

    @NotNull(message = "*Please provide a doctor's email")
    String doctorEmail;

    @NotNull(message = "*Please provide a date of birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    Calendar dateOfAppointment;

    String doctorPosition;
    List<DoctorDto> doctors;
}
