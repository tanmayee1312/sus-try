package com.tsl.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business_travel_rail")
public class BusinessTravelRail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private String year;

    @Column(name = "arrival")
    private String arrival;

    @Column(name = "departure")
    private String departure;

    @Column(name = "distance_per_trip")
    private double distancePerTrip;

    @Column(name = "trip")
    private String trip;

    @Column(name = "no_of_passengers")
    private double numberOfPassengers;

    @Column(name = "rail_fare")
    private double railFare;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
