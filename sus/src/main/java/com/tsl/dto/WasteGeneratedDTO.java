package com.tsl.dto;

import lombok.Data;

@Data
public class WasteGeneratedDTO {
    private String year;
    private String typeOfWaste;
    private String unitOfMeasurement;
    private double annualQuantity;
    private String wasteDisposalMethod;
    private double amountSpentForWasteDisposal;
    private double amountReceived;
}
