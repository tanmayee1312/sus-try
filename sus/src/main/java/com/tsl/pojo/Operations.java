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
	public class Operations {
	
		 @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
	
		 private String location; // National or International
			
		    // Section 1
		    private int numberOfPlants;
		    private int numberOfOffices;
		    private int total;
		    private String year;

		    // Section 2
		    private int numberOfStatesOrCountries; // For "National (No. of states)" and "International (No. of countries)"
		    private String customerBrief; // A brief description of types of customers
	
		    @ManyToOne
		    @JoinColumn(name = "user_id", nullable = false)
		    @JsonIgnore
		    private Login user;  // Map to the Login entity
	}
