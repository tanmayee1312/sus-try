package com.tsl.dto;

import lombok.Data;

@Data
public class BusinessTravelAirDTO {
    private String year;
    private String arrival;
    private String departure;
    private String travelClass;  // Renamed to avoid conflict with Java keyword
    private String trip;
    private double numberOfPassengers;
    private double airFare;
}
