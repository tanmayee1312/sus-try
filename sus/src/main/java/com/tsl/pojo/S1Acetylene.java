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
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/*
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s1_acetylene")
public class S1Acetylene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private String year;
    private Double acetyleneCylinderPurchased;
    private Double cylinderCapacity;
    private Double materialCost;

    @ManyToOne
    @JoinColumn(name = "login_id")
    @JsonIgnore
    private Login login;
}
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s1_acetylene")
public class S1Acetylene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private String year;
    private Double acetyleneCylinderPurchased;
    private Double cylinderCapacity;
    
    private String cylinderCapacityUOM; // Added UOM for cylinder capacity

    private Double materialCost;

    private Double monthlyEmission; // Added monthly emission field
    private Double yearlyEmission;  // Added yearly emission field

    @ManyToOne
    @JoinColumn(name = "login_id")
    @JsonIgnore
    private Login login;
}
