package com.tsl.BRSR.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsl.BRSR.dto.OperationsDTO;
import com.tsl.pojo.BusinessActivity;
import com.tsl.pojo.Login;
import com.tsl.pojo.Operations;
import com.tsl.BRSR.repository.BusinessActivityRepository;
import com.tsl.repository.LoginRepository;
import com.tsl.BRSR.repository.OperationsRepository;

@Service
public class OperationsService {
	 @Autowired
	    private OperationsRepository operationsRepository;

	    @Autowired
	    private LoginRepository loginRepository;

	    // Save operation for creating new entries
	    public List<Operations> saveAll(Long userId, List<OperationsDTO> operationsDTOList) {
	        // Fetch the user by userId
	        Login user = loginRepository.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

	        // Convert DTOs to Entities
	        List<Operations> operationsList = operationsDTOList.stream().map(dto -> {
	            Operations operation = new Operations();
	            operation.setLocation(dto.getLocation());
	            operation.setNumberOfPlants(dto.getNumberOfPlants());
	            operation.setNumberOfOffices(dto.getNumberOfOffices());
	            operation.setTotal(dto.getTotal());
	            operation.setYear(dto.getYear());  // Set the year
	            operation.setNumberOfStatesOrCountries(dto.getNumberOfStatesOrCountries());
	            operation.setCustomerBrief(dto.getCustomerBrief());
	            operation.setUser(user);
	            return operation;
	        }).collect(Collectors.toList());

	        // Save all Operations entries
	        return operationsRepository.saveAll(operationsList);
	    }

	    // Update operation for editing existing entries
	    public List<Operations> updateOperations(Long userId, List<OperationsDTO> operationsDTOList) {
	        return operationsDTOList.stream().map(dto -> {
	            // Fetch the operation by id and userId
	            Operations operation = operationsRepository.findByIdAndUserId(dto.getId(), userId);
	            if (operation != null) {
	                operation.setLocation(dto.getLocation());
	                operation.setNumberOfPlants(dto.getNumberOfPlants());
	                operation.setNumberOfOffices(dto.getNumberOfOffices());
	                operation.setTotal(dto.getTotal());
	                operation.setYear(dto.getYear());
	                operation.setNumberOfStatesOrCountries(dto.getNumberOfStatesOrCountries());
	                operation.setCustomerBrief(dto.getCustomerBrief());
	                return operationsRepository.save(operation);
	            } else {
	                throw new RuntimeException("Operation not found for id: " + dto.getId() + " and userId: " + userId);
	            }
	        }).collect(Collectors.toList());
	    }

	    // Fetch operations by userId and year
	    public List<Operations> getOperationsByUserIdAndYear(Long userId, String year) {
	        return operationsRepository.findByUserIdAndYear(userId, year);
	    }

	    // Fetch operations by userId
	    public List<Operations> getOperationsByUserId(Long userId) {
	        return operationsRepository.findByUserId(userId);
	    }

	    // Fetch all operations
	    public List<Operations> getAllOperations() {
	        return operationsRepository.findAll();
	    }

	    // Fetch operation by id
	    public Operations getOperationById(Long id) {
	        return operationsRepository.findById(id).orElse(null);
	    }
}
