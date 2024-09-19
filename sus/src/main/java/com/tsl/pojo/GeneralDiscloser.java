package com.tsl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralDiscloser {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String cin; // Corporate Identity Number (CIN) of the Listed Entity
	    private String name; // Name of the Listed Entity
	    private int yearOfIncorporation; // Year of incorporation
	    private String registeredOfficeAddress; // Registered office address
	    private String corporateAddress; // Corporate address
	    private String email; // E-mail
	    private String telephone; // Telephone
	    private String website; // Website
	    private String financialYear; // Financial year for which reporting is being done
	    private String stockExchanges; // Name of the Stock Exchange(s) where shares are listed
	    private String paidUpCapital; // Paid-up Capital
	    private String contactName; // Name of the contact person for BRSR queries
	    private String contactTelephone; // Contact telephone
	    private String contactEmail; // Contact email
	    private String reportingBoundary; // Reporting boundary (Standalone/Consolidated)
	    private String assuranceProvider; // Name of assurance provider
	    private String typeOfAssurance; // Type of assurance obtained
	    private String year;

	    
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonIgnore // This will prevent the user object from being serialized

	    private Login user; // Map to the Login entity
	    
}
