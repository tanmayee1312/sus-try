package com.tsl.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class DownstreamLeasedAssets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String month;
    private String year;
    private double areaOfLeasedAssets;
    private String scope1DieselInDGSets; 
    private String scope2ElectricityConsumption; 
    private double totalBuiltUpAreaOfBuilding;
    private double totalBuildingOccupancyRate;
    
    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
