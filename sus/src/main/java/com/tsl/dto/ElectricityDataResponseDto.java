package com.tsl.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectricityDataResponseDto {
    private String year;
    private String month;
    private Integer importedUnits;
    private Double importedCharges;
    private Double exportedCharges;

    // Constructor, getters, and setters if not using Lombok
}

