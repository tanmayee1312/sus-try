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
public class ProductOrService {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String productOrService; // Product or Service description
	    private String nicCode; // NIC code for the product or service
	    private Double revenueFromProductOrService; // Revenue from each product/service
	    private Double percentageOfTotalTurnover; // Calculated percentage of total turnover
	    private Double totalRevenueForProductOrService; // Total revenue for all products/services
	    private String year;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonIgnore
	    private Login user; // Map to the Login entity
	}