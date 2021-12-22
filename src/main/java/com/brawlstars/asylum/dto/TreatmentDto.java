package com.brawlstars.asylum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.util.Calendar;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDto {
    private Integer id;

    private String methodsOfTreatment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar startOfTreatment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar endOfTreatment;

    @Min(value = 1)
    private Integer chamber;

    private UserDto patient;

    private Set<DiagnoseDto> diagnoses;

    private DoctorDto doctor;
}
