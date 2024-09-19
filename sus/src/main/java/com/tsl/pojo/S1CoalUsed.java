package com.tsl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

//@Entity
//@Data
//@Table(name = "s1_coal_used")
//public class S1CoalUsed {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String year;
//    private String month;
//    
//    private double monthlyBagassePurchased;
//    private String typeOfBagasse;
//    private double monthlyBagasseUsed;
//    private double coalCost;
//    private double totalEmissions; // Field to store total emissions for the month
//    private double yearlyEmissions; // Field to store total emissions for the year
//
//    @ManyToOne
//    @JoinColumn(name = "login_id")
//    private Login login;
//}

@Entity
@Data
@Table(name = "s1_coal_used")
public class S1CoalUsed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String year;
    private String month;
    
    private double monthlyCoalPurchased; // Updated field name
    private String typeOfCoal;           // Updated field name
    private double monthlyCoalUsed;      // Updated field name
    private double coalCost;
    private double totalEmissions;       // Field to store total emissions for the month
    private double yearlyEmissions;      // Field to store total emissions for the year

    @ManyToOne
    @JoinColumn(name = "login_id")
    @JsonIgnore
    private Login login;
}
