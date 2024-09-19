package com.tsl.BRSR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsl.BRSR.dto.OperationsDTO;
import com.tsl.pojo.Operations;
import com.tsl.BRSR.service.OperationsService;

@RestController
@RequestMapping("/api/location-info")

public class OperationsController {

	 @Autowired
	    private OperationsService operationsService;

	    // Save new operations (POST)
	    @PostMapping("/save/{userId}")
	    public ResponseEntity<List<Operations>> saveOperations(
	            @PathVariable Long userId,
	            @RequestBody List<OperationsDTO> operationsDTOList) {

	        List<Operations> savedOperations = operationsService.saveAll(userId, operationsDTOList);

	        return ResponseEntity.status(HttpStatus.CREATED).body(savedOperations);
	    }

	    // Update existing operations (PUT)
	    @PutMapping("/update/{userId}")
	    public ResponseEntity<List<Operations>> updateOperations(
	            @PathVariable Long userId,
	            @RequestBody List<OperationsDTO> operationsDTOList) {

	        List<Operations> updatedOperations = operationsService.updateOperations(userId, operationsDTOList);

	        return ResponseEntity.ok(updatedOperations);
	    }

	    // Fetch operations by userId and year (GET)
	    @GetMapping("/user/{userId}/year/{year}")
	    public ResponseEntity<List<Operations>> getOperationsByUserIdAndYear(
	            @PathVariable Long userId,
	            @PathVariable String year) {

	        List<Operations> operationsList = operationsService.getOperationsByUserIdAndYear(userId, year);
	        return ResponseEntity.ok(operationsList);
	    }

	    // Fetch operations by userId (GET)
	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Operations>> getOperationsByUserId(@PathVariable Long userId) {
	        List<Operations> operationsList = operationsService.getOperationsByUserId(userId);
	        return ResponseEntity.ok(operationsList);
	    }

	    // Fetch all operations (GET)
	    @GetMapping("/all")
	    public ResponseEntity<List<Operations>> getAllOperations() {
	        List<Operations> operationsList = operationsService.getAllOperations();
	        return ResponseEntity.ok(operationsList);
	    }

	    // Fetch operation by id (GET)
	    @GetMapping("/{id}")
	    public ResponseEntity<Operations> getOperationById(@PathVariable Long id) {
	        Operations operation = operationsService.getOperationById(id);
	        return ResponseEntity.ok(operation);
	    }
}
