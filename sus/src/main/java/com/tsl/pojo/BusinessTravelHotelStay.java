package com.tsl.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



/**
 * @author Aditya Wakle
 * @version 1.0
 * @since 2024-08-30
 *
 */


@Data
@NoArgsConstructor
@Entity
@Table(name = "business_travel_hotel_stay")
public class BusinessTravelHotelStay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private String year;

    @Column(name = "number_of_rooms_occupied")
    private Double numberOfRoomsOccupied;

    @Column(name = "number_of_nights")
    private Double numberOfNights;

    @Column(name = "location_of_hotel")
    private String locationOfHotel;

    @Column(name = "cost")
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
