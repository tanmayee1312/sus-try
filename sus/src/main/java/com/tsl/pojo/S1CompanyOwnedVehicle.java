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

@Data
@NoArgsConstructor
@Entity
@Table(name = "s1_company_owned_vehicle")
public class S1CompanyOwnedVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;

    @Column(name = "type_of_vehicle_fuel")
    private String typeOfVehicleFuel;

    private double consumption;

    private double cost;

    @Column(name = "vehicle_name_and_model")
    private String vehicleNameAndModel;

    private double mileage;

    @Column(name = "engine_capacity_cc")
    private double engineCapacityCC;

    @Column(name = "yearly_distance_travelled")
    private double yearlyDistanceTravelled;

    @Column(name = "average_monthly_distance_travelled")
    private double averageMonthlyDistanceTravelled;

    @Column(name = "no_of_travel_days")
    private double noOfTravelDays;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
