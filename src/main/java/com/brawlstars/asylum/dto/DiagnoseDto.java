package com.brawlstars.asylum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnoseDto {
    private Integer id;

    private String name;

    private String description;
}
