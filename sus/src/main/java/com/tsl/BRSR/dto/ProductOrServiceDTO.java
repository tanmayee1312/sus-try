package com.tsl.BRSR.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrServiceDTO {

    private String productOrService;
    private String nicCode;
    private Double revenueFromProductOrService;
    private Double percentageOfTotalTurnover;
    private Double totalRevenueForProductOrService;
    private Long userId; // Include userId in the DTO
    private String year;

}
