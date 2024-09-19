package com.tsl.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "waste_generated")
public class WasteGenerated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year")
    private String year;

    @Column(name = "type_of_waste")
    private String typeOfWaste;

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;

    @Column(name = "annual_quantity", nullable = false)
    private double annualQuantity;

    @Column(name = "waste_disposal_method", nullable = false)
    private String wasteDisposalMethod;

    @Column(name = "amount_spent_for_waste_disposal", nullable = false)
    private double amountSpentForWasteDisposal;

    @Column(name = "amount_received", nullable = false)
    private double amountReceived;

    @ManyToOne
    @JoinColumn(name = "login_id", nullable = false)
    private Login login;
}
