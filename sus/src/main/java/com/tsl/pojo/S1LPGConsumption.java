package com.tsl.pojo;
/*
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "s1_LPG_consumption")
public class S1LPGConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private String year;
    private double consumption;
    private double cylindersPurchased;
    private double cylinderCapacity;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

/*
@Entity
@Getter
@Setter
@Data
@Table(name = "s1_lpg_consumption")
public class S1LPGConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private String year;
    private double consumption;

    @Column(name = "consumption_uom")
    private String consumptionUOM;

    private double cylindersPurchased;
    private double cylinderCapacity;

    @Column(name = "cylinder_capacity_uom")
    private String cylinderCapacityUOM;

    @Column(name = "co2_emission")
    private double co2Emission; // Field to store calculated CO2 emission

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
*/

@Entity
@Getter
@Setter
@Data
@Table(name = "s1_lpg_consumption")
public class S1LPGConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private String year;
    private double consumption;

    @Column(name = "consumption_uom")
    private String consumptionUOM;

    private double cylindersPurchased;
    private double cylinderCapacity;

    @Column(name = "cylinder_capacity_uom")
    private String cylinderCapacityUOM;

    @Column(name = "co2_emission")
    private double co2Emission; // Field to store calculated CO2 emission

    @Column(name = "total_co2_emission")
    private double totalCO2Emission; // Field to store total CO2 emission (same for all rows)

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
