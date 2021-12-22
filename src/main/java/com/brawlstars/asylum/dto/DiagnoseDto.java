package com.brawlstars.asylum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnoseDto {
    private Integer id;

    @NotBlank(message = "*Diagnose name cannot be empty")
    private String name;

    private String description;
}
