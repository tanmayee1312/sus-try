package com.tsl.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/*
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s1_discharge")
public class S1Discharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private String year;

    @Column(name = "molasis_used")
    private double molasisUsed;

    @Column(name = "co2_released_fermentation")
    private double co2ReleasedFermentation;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s1_discharge_co2")
public class S1Discharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    private String month;

    @Column(name = "year")
    private String year;

    @Column(name = "molasis_used")
    private double molasisUsed;

    @Column(name = "molasis_used_uom")
    private String molasisUsedUOM;

    @Column(name = "co2_released_fermentation")
    private double co2ReleasedFermentation;

    @Column(name = "co2_released_fermentation_uom")
    private String co2ReleasedFermentationUOM;

    @Column(name = "percentage_of_sugar_in_molasis")
    private double percentageOfSugarInMolasis;

    @Column(name = "ethanol_produced")
    private double ethanolProduced;

    @Column(name = "ethanol_produced_uom")
    private String ethanolProducedUOM;

    @Column(name = "monthly_emission")
    private double monthlyEmission;

    @Column(name = "yearly_emission")
    private double yearlyEmission;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "login_id")
    private Login login;
    
    
    // Define the constructor you're trying to use
    public S1Discharge(String month, String year, Double molasisUsed, String molasisUsedUOM,
                       Double co2ReleasedFermentation, String co2ReleasedFermentationUOM,
                       Double percentageOfSugarInMolasis, Double ethanolProduced,
                       String ethanolProducedUOM, double monthlyEmission, Login login) {
        this.month = month;
        this.year = year;
        this.molasisUsed = molasisUsed;
        this.molasisUsedUOM = molasisUsedUOM;
        this.co2ReleasedFermentation = co2ReleasedFermentation;
        this.co2ReleasedFermentationUOM = co2ReleasedFermentationUOM;
        this.percentageOfSugarInMolasis = percentageOfSugarInMolasis;
        this.ethanolProduced = ethanolProduced;
        this.ethanolProducedUOM = ethanolProducedUOM;
        this.monthlyEmission = monthlyEmission;
        this.login = login;
    }
}

