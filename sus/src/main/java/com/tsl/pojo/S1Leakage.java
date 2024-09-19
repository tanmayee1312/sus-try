package com.tsl.pojo;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "s1_leakage")
public class S1Leakage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_name")
    private String sourceName;

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;

    @Column(name = "gas_leakage_incidents")
    private Double gasLeakageIncidents;

    @Column(name = "gas_leakage_amount")
    private Double gasLeakageAmount;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
