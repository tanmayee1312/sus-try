package com.tsl.pojo;
	
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

	
	
@Data
@Entity
@Table(name = "s1_arc_welding")
public class S1ArcWelding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private String year;
    private double electrodesPurchased;
    private String electrodePurpose;
    private double openCircuitVoltage;
    private double closeCircuitVoltage;
    private double electrodesCost;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;


}
