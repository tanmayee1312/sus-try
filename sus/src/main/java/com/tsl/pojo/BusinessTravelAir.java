package com.tsl.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Entity
@Table(name = "business_travel_air")
public class BusinessTravelAir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private String year;

    @Column(name = "arrival")
    private String arrival;

    @Column(name = "departure", nullable = false)
    private String departure;

    @Column(name = "class")
    private String travelClass;  // "class" is a reserved keyword in Java, so using "travelClass" instead

    @Column(name = "trip")
    private String trip;

    @Column(name = "no_of_passengers")
    private double numberOfPassengers;

    @Column(name = "air_fare")
    private double airFare;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
