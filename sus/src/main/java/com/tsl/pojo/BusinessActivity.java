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

public class BusinessActivity {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String mainActivityDescription;  // Description of Main Activity
	    private String businessActivityDescription;  // Description of Business Activity
	    private Double totalRevenue; // Total revenue
	    private Double revenueFromMainActivity; // Revenue from main activity
	    private Double turnoverPercentage; // Calculated turnover percentage
	    private String year;
//	 // New fields
//	    private String productOrService; // Product or Service description
//	    private String nicCode; // NIC code for the product or service
//	    private Double revenueFromProductOrService; // Revenue from each product/service
//	    private Double percentageOfTotalTurnover; // Calculated percentage of total turnover contributed by product/service
//	    private Double totalRevenueForProductOrService; // Total revenue for all products/services

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonIgnore  // Ignore this field in JSON serialization/deserialization

	    private Login user;  // Map to the Login entity
}
