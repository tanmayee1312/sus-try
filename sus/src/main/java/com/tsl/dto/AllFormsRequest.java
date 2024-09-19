package com.tsl.dto;

import com.tsl.pojo.S1FireExtinguisher;

import lombok.Data;

@Data
public class AllFormsRequest {

    private S1CoalUsedForm s1CoalUsedForm;
    private S1FireExtinguisher s1FireExtinguisher;
    private S2PurchasedElectricityForm s2PurchasedElectricityForm;
    private S1SpentWashForm s1SpentWashDataForm;



    public S1CoalUsedForm getS1CoalUsedForm() {
        return s1CoalUsedForm;
    }

    public void setS1CoalUsedForm(S1CoalUsedForm s1CoalUsedForm) {
        this.s1CoalUsedForm = s1CoalUsedForm;
    }

    public S1FireExtinguisher getS1FireExtinguisher() {
        return s1FireExtinguisher;
    }

    public void setS1FireExtinguisher(S1FireExtinguisher s1FireExtinguisher) {
        this.s1FireExtinguisher = s1FireExtinguisher;
    }

    public S2PurchasedElectricityForm getS2PurchasedElectricityForm() {
        return s2PurchasedElectricityForm;
    }

    public void setS2PurchasedElectricityForm(S2PurchasedElectricityForm s2PurchasedElectricityForm) {
        this.s2PurchasedElectricityForm = s2PurchasedElectricityForm;
    }
    
    
}
