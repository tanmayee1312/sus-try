package com.tsl.dto;

import lombok.Data;

@Data
public class S3PurchasedGoodsAndServicesDTO {
    private String nameOfGoodsServices;
    private String year;
    private String classificationOfGoodsServices;
    private double quantityUnitPurchasedAnnually;
    private String unitOfMeasurement;
}
