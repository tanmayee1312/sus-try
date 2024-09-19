package com.tsl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "s1_fire_extinguisher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class S1FireExtinguisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String year;
    private double annualRefillingQuantity;
    private int cylindersPurchased;
    private double capacityOfCylinder;
    private double totalKg;     
    private double totalTonnes; 
    private double aggregateTotalKg;     
    private double aggregateTotalTonnes; 
    
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "login_id")
    private Login login;
    @PrePersist
    @PreUpdate
    public void calculateTotals() {
        if ("CO2".equalsIgnoreCase(this.type)) {
            this.totalKg = this.annualRefillingQuantity + (this.cylindersPurchased * this.capacityOfCylinder);
            this.totalTonnes = this.totalKg / 1000; // Convert kg to tonnes
        } else {
            this.totalKg = 0;
            this.totalTonnes = 0;
        }
    }
}