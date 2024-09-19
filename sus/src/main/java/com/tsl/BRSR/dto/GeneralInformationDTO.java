package com.tsl.BRSR.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralInformationDTO {

    private Long id; // Use this for update operations
    private String location;
    private double totalOfficeFootprintArea;
    private double noOfEmployeeContractual;
    private double noOfEmployeePermanent;
    private String year;
    private Long user_id; // Include loginId to reference the associated Login entity
    
    
}
