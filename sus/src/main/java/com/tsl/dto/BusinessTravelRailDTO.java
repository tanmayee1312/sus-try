package com.tsl.dto;

import lombok.Data;

@Data
public class BusinessTravelRailDTO {
    private String year;
    private String arrival;
    private String departure;
    private double distancePerTrip;
    private String trip;
    private double numberOfPassengers;
    private double railFare;
}
