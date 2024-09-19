package com.tsl.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "employee_commute")

public class EmployeeCommute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private String year;

    @Column(name = "mode_of_commute")
    private String modeOfCommute;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "distance_travelled_per_day")
    private double distanceTravelledPerDay;

    @Column(name = "no_of_working_days_per_year")
    private double noOfWorkingDaysPerYear;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
