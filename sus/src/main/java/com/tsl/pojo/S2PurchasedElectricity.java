package com.tsl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Column;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Table(name = "s2_purchased_electricity")
//@Getter
//@Setter
//public class S2PurchasedElectricity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "month")
//    private String month;
//
//    private String year;
//    
//    @Column(name = "electricity_imported")
//    private double electricityImported;
//
//    @Column(name = "imported_charges")
//    private double importedCharges;
//
//    @Column(name = "electricity_exported")
//    private double electricityExported;
//
//    @Column(name = "fuel_used")
//    private String fuelUsed;
//
//    @Column(name = "fuel_quantity")
//    private double fuelQuantity;
//    
//
//    @ManyToOne
//    @JoinColumn(name = "login_id")
//  
//    private Login login;
//}





//----------------------------------------Done calculations------------------------------------------

/*
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s2_purchased_electricity")
@Getter
@Setter
public class S2PurchasedElectricity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    private String month;

    private String year;

    @Column(name = "electricity_imported")
    private double electricityImported;

    @Column(name = "electricity_imported_uom")
    private String electricityImportedUOM;

    @Column(name = "imported_charges")
    private double importedCharges;

    @Column(name = "electricity_exported")
    private double electricityExported;

    @Column(name = "exported_charges")
    private double exportedCharges;

    @Column(name = "electricity_exported_uom")
    private String electricityExportedUOM;

    @Column(name = "fuel_used")
    private String fuelUsed;

    @Column(name = "fuel_uom")
    private String fuelUOM;

    @Column(name = "fuel_quantity")
    private double fuelQuantity;

    @Column(name = "imported_emission")
    private double importedEmission;

    @Column(name = "exported_emission")
    private double exportedEmission;

    @ManyToOne
    @JoinColumn(name = "login_id")
    @JsonIgnore
    private Login login;
}
*/

//----------------------------------------------------done calculations with adding total emission----------------------------------

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s2_purchased_electricity")
@Getter
@Setter
public class S2PurchasedElectricity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    private String month;

    private String year;

    @Column(name = "electricity_imported")
    private double electricityImported;

    @Column(name = "electricity_imported_uom")
    private String electricityImportedUOM;

    @Column(name = "imported_charges")
    private double importedCharges;

    @Column(name = "electricity_exported")
    private double electricityExported;

    @Column(name = "exported_charges")
    private double exportedCharges;

    @Column(name = "electricity_exported_uom")
    private String electricityExportedUOM;

    @Column(name = "fuel_used")
    private String fuelUsed;

    @Column(name = "fuel_uom")
    private String fuelUOM;

    @Column(name = "fuel_quantity")
    private double fuelQuantity;

    @Column(name = "imported_emission")
    private double importedEmission;

    @Column(name = "exported_emission")
    private double exportedEmission;
    
    @Column(name = "total_emission")
    private double totalEmission;

    @ManyToOne
    @JoinColumn(name = "login_id")
    @JsonIgnore
    private Login login;
}
