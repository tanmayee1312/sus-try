package com.tsl.dto;

import lombok.Data;

@Data
public class EmployeeCommuteDTO {
    private String name;
    private String year;
    private String modeOfCommute;
    private String fuelType;
    private double distanceTravelledPerDay;
    private double noOfWorkingDaysPerYear;
}
