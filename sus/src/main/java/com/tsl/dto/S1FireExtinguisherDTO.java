package com.tsl.dto;
import lombok.Data;
@Data
public class S1FireExtinguisherDTO {
    private String year;
    private String type;
    private double annualRefillingQuantity;
    private int cylindersPurchased;
    private double capacityOfCylinder;
    private double totalKg;     // Total in kilograms
    private double totalTonnes; // Total in tonnes
}