package com.tsl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class GeneralInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String location;

    private double totalOfficeFootprintArea;


    private double noOfEmployeeContractual;


    private double noOfEmployeePermanent;
    
    private String year;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore // Ignore this field during serialization
    private Login login;
}
