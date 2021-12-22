package com.brawlstars.asylum.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EpicrisisCreationDto {

    @NotNull
    String patientEmail;
}
