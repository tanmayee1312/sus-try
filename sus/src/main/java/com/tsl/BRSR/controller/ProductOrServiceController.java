package com.tsl.BRSR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsl.BRSR.dto.ProductOrServiceDTO;
import com.tsl.pojo.ProductOrService;
import com.tsl.BRSR.service.ProductOrServiceService;

@RestController
@RequestMapping("/api/product-or-service")
public class ProductOrServiceController {

	 @Autowired
	    private ProductOrServiceService productOrServiceService;

	    // Create or update multiple products or services for a user
	    @PostMapping("/user/{userId}")
	    public ResponseEntity<?> createOrUpdateProductsOrServices(@PathVariable Long userId, @RequestBody List<ProductOrServiceDTO> productsOrServicesDTO) {
	        try {
	            List<ProductOrService> savedProductsOrServices = productOrServiceService.saveAll(userId, productsOrServicesDTO);
	            return ResponseEntity.ok(savedProductsOrServices);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Error processing request: " + e.getMessage());
	        }
	    }

	    // Get products or services by user ID
	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<ProductOrService>> getProductsOrServicesByUserId(@PathVariable Long userId) {
	        List<ProductOrService> productsOrServices = productOrServiceService.getProductsOrServicesByUserId(userId);
	        return ResponseEntity.ok(productsOrServices);
	    }

	    // Get products or services by user ID and year
	    @GetMapping("/user/{userId}/year/{year}")
	    public ResponseEntity<List<ProductOrService>> getProductsOrServicesByUserIdAndYear(@PathVariable Long userId, @PathVariable String year) {
	        List<ProductOrService> productsOrServices = productOrServiceService.getProductsOrServicesByUserIdAndYear(userId, year);
	        return ResponseEntity.ok(productsOrServices);
	    }

	    // Get a specific product or service by ID and user ID
	    @GetMapping("/{id}/user/{userId}")
	    public ResponseEntity<ProductOrService> getProductOrServiceByIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
	        ProductOrService productOrService = productOrServiceService.getProductOrServiceByIdAndUserId(id, userId);
	        return productOrService != null ? ResponseEntity.ok(productOrService) : ResponseEntity.notFound().build();
	    }

	    // Update a specific product or service
	    @PutMapping("/user/{userId}/product/{id}")
	    public ResponseEntity<?> updateProductOrService(@PathVariable Long userId, @PathVariable Long id, @RequestBody ProductOrServiceDTO dto) {
	        try {
	            ProductOrService updatedProductOrService = productOrServiceService.updateProductOrService(userId, id, dto);
	            return ResponseEntity.ok(updatedProductOrService);
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Error processing request: " + e.getMessage());
	        }
	    }
}