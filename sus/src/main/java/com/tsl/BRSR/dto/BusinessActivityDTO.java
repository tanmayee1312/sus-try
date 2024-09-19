package com.tsl.BRSR.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessActivityDTO {

    private Long id; // Add id for update operations

    private String mainActivityDescription;
    private String businessActivityDescription;
    private Double totalRevenue;
    private Double revenueFromMainActivity;
    private Double turnoverPercentage;
    private String year;
    private Long userId; // Include userId in the DTO

}
