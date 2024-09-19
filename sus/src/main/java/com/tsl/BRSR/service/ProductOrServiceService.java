package com.tsl.BRSR.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsl.BRSR.dto.ProductOrServiceDTO;
import com.tsl.pojo.Login;
import com.tsl.pojo.ProductOrService;
import com.tsl.repository.LoginRepository;
import com.tsl.BRSR.repository.ProductOrServiceRepository;

@Service
public class ProductOrServiceService {

	@Autowired
    private ProductOrServiceRepository productOrServiceRepository;

    @Autowired
    private LoginRepository loginRepository;

    // Save multiple ProductOrService entries for a user
    public List<ProductOrService> saveAll(Long userId, List<ProductOrServiceDTO> productsOrServicesDTO) {
        Login user = loginRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        List<ProductOrService> productsOrServices = productsOrServicesDTO.stream().map(dto -> {
            ProductOrService productOrService = new ProductOrService();
            productOrService.setProductOrService(dto.getProductOrService());
            productOrService.setNicCode(dto.getNicCode());
            productOrService.setRevenueFromProductOrService(dto.getRevenueFromProductOrService());
            productOrService.setTotalRevenueForProductOrService(dto.getTotalRevenueForProductOrService());
            productOrService.setUser(user);
            productOrService.setYear(dto.getYear());

            // Calculate the percentage for each product/service
            if (productOrService.getTotalRevenueForProductOrService() != null 
                && productOrService.getRevenueFromProductOrService() != null 
                && productOrService.getTotalRevenueForProductOrService() > 0) {
                double percentage = (productOrService.getRevenueFromProductOrService() / productOrService.getTotalRevenueForProductOrService()) * 100;
                productOrService.setPercentageOfTotalTurnover(percentage);
            } else {
                productOrService.setPercentageOfTotalTurnover(0.0); // Handle division by zero or null values
            }

            return productOrService;
        }).collect(Collectors.toList());

        return productOrServiceRepository.saveAll(productsOrServices);
    }

    // Get all ProductOrService entries for a user
    public List<ProductOrService> getProductsOrServicesByUserId(Long userId) {
        return productOrServiceRepository.findByUserId(userId);
    }

    // Get all ProductOrService entries for a user in a specific year
    public List<ProductOrService> getProductsOrServicesByUserIdAndYear(Long userId, String year) {
        return productOrServiceRepository.findByUserIdAndYear(userId, year);
    }

    // Get a specific ProductOrService entry by id and userId
    public ProductOrService getProductOrServiceByIdAndUserId(Long id, Long userId) {
        return productOrServiceRepository.findByIdAndUserId(id, userId);
    }

    // Update a single ProductOrService entry
    public ProductOrService updateProductOrService(Long userId, Long id, ProductOrServiceDTO dto) {
        ProductOrService productOrService = productOrServiceRepository.findByIdAndUserId(id, userId);
        if (productOrService == null) {
            throw new RuntimeException("Product or Service not found for this user.");
        }

        productOrService.setProductOrService(dto.getProductOrService());
        productOrService.setNicCode(dto.getNicCode());
        productOrService.setRevenueFromProductOrService(dto.getRevenueFromProductOrService());
        productOrService.setTotalRevenueForProductOrService(dto.getTotalRevenueForProductOrService());
        productOrService.setYear(dto.getYear());

        // Calculate the percentage of turnover
        if (productOrService.getTotalRevenueForProductOrService() != null 
            && productOrService.getRevenueFromProductOrService() != null 
            && productOrService.getTotalRevenueForProductOrService() > 0) {
            double percentage = (productOrService.getRevenueFromProductOrService() / productOrService.getTotalRevenueForProductOrService()) * 100;
            productOrService.setPercentageOfTotalTurnover(percentage);
        } else {
            productOrService.setPercentageOfTotalTurnover(0.0); // Handle division by zero or null values
        }

        return productOrServiceRepository.save(productOrService);
    }
}