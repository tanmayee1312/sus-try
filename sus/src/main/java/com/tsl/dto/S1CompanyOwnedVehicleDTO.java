package com.tsl.dto;

import lombok.Data;

@Data
public class S1CompanyOwnedVehicleDTO {
    private String year;
    private String typeOfVehicleFuel;
    private double consumption;
    private double cost;
    private String vehicleNameAndModel;
    private double mileage;
    private double engineCapacityCC;
    private double yearlyDistanceTravelled;
    private double averageMonthlyDistanceTravelled;
    private double noOfTravelDays;
}
