package com.tsl.dto;

import lombok.Data;

@Data
public class BusinessTravelRoadDTO {
    private String year;
    private String typeOfVehicle;
    private String typeOfFuel;
    private String distanceTravelledPerTrip;
    private Double trip;
    private Double numberOfPassengers;
    private Double fare;
}
