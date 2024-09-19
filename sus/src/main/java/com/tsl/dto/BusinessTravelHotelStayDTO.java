package com.tsl.dto;

import lombok.Data;

@Data
public class BusinessTravelHotelStayDTO {
    private String year;
    private Double numberOfRoomsOccupied;
    private Double numberOfNights;
    private String locationOfHotel;
    private Double cost;
}
