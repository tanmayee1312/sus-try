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
@Table(name = "business_travel_road")
public class BusinessTravelRoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private String year;

    @Column(name = "type_of_vehicle")
    private String typeOfVehicle;

    @Column(name = "type_of_fuel")
    private String typeOfFuel;

    @Column(name = "distance_travelled_per_trip")
    private String distanceTravelledPerTrip;

    @Column(name = "trip")
    private Double trip;

    @Column(name = "number_of_passengers")
    private Double numberOfPassengers;

    @Column(name = "fare")
    private Double fare;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
