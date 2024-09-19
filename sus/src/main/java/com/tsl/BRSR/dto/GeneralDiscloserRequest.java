package com.tsl.BRSR.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralDiscloserRequest {
    private Long id;  // Add id for update operations

	 private String cin;
	    private String name;
	    private int yearOfIncorporation;
	    private String registeredOfficeAddress;
	    private String corporateAddress;
	    private String email;
	    private String telephone;
	    private String website;
	    private String financialYear;
	    private String stockExchanges;
	    private String paidUpCapital;
	    private String contactName;
	    private String contactTelephone;
	    private String contactEmail;
	    private String reportingBoundary;
	    private String assuranceProvider;
	    private String typeOfAssurance;
	    private Long userId; // Add this field to the DTO
	    private String year;

}
