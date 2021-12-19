package com.brawlstars.asylum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequestDto {
    @Min(value = 0)
    private Integer id;

    @NotNull(message = "*Doctor position cannot be empty")
    private String doctorPosition;
}
