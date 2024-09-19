package com.tsl.BRSR.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationsDTO {
	
    private Long id; 
	 private String location; 
		
	    private int numberOfPlants;
	    private int numberOfOffices;
	    private int total;
	    private String year;


	    private int numberOfStatesOrCountries; 
	    private String customerBrief; 
	    private Long userId; 

}
