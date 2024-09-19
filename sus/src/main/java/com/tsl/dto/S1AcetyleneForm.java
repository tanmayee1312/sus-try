package com.tsl.dto;

import com.tsl.pojo.Login;
import com.tsl.pojo.S1Acetylene;
import lombok.Getter;
import lombok.Setter;

/*
@Getter
@Setter
public class S1AcetyleneForm {
    private Long userId;
    private String year;

    private Double aprAcetyleneCylinderPurchased;
    private Double aprCylinderCapacity;
    private Double aprMaterialCost;

    private Double mayAcetyleneCylinderPurchased;
    private Double mayCylinderCapacity;
    private Double mayMaterialCost;

    private Double junAcetyleneCylinderPurchased;
    private Double junCylinderCapacity;
    private Double junMaterialCost;

    private Double julAcetyleneCylinderPurchased;
    private Double julCylinderCapacity;
    private Double julMaterialCost;

    private Double augAcetyleneCylinderPurchased;
    private Double augCylinderCapacity;
    private Double augMaterialCost;

    private Double sepAcetyleneCylinderPurchased;
    private Double sepCylinderCapacity;
    private Double sepMaterialCost;

    private Double octAcetyleneCylinderPurchased;
    private Double octCylinderCapacity;
    private Double octMaterialCost;

    private Double novAcetyleneCylinderPurchased;
    private Double novCylinderCapacity;
    private Double novMaterialCost;

    private Double decAcetyleneCylinderPurchased;
    private Double decCylinderCapacity;
    private Double decMaterialCost;

    private Double janAcetyleneCylinderPurchased;
    private Double janCylinderCapacity;
    private Double janMaterialCost;

    private Double febAcetyleneCylinderPurchased;
    private Double febCylinderCapacity;
    private Double febMaterialCost;

    private Double marAcetyleneCylinderPurchased;
    private Double marCylinderCapacity;
    private Double marMaterialCost;

    public S1Acetylene toS1Acetylene(String month, Double acetyleneCylinderPurchased, Double cylinderCapacity, Double materialCost, Long loginId) {
        S1Acetylene acetylene = new S1Acetylene();
        acetylene.setYear(year);
        acetylene.setMonth(month);
        acetylene.setAcetyleneCylinderPurchased(acetyleneCylinderPurchased);
        acetylene.setCylinderCapacity(cylinderCapacity);
        acetylene.setMaterialCost(materialCost);

        Login login = new Login(); // Replace with actual fetching logic
        login.setId(loginId);
        acetylene.setLogin(login);

        return acetylene;
    }
}
*/

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S1AcetyleneForm {

    private Long userId;  // Represents the login ID
    private String year;  // The year is entered once

    private String cylinderCapacityUOM; // Unit of measurement for cylinder capacity

    // Monthly data
    private Double aprAcetyleneCylinderPurchased;
    private Double aprCylinderCapacity;
    private Double aprMaterialCost;

    private Double mayAcetyleneCylinderPurchased;
    private Double mayCylinderCapacity;
    private Double mayMaterialCost;

    private Double junAcetyleneCylinderPurchased;
    private Double junCylinderCapacity;
    private Double junMaterialCost;

    private Double julAcetyleneCylinderPurchased;
    private Double julCylinderCapacity;
    private Double julMaterialCost;

    private Double augAcetyleneCylinderPurchased;
    private Double augCylinderCapacity;
    private Double augMaterialCost;

    private Double sepAcetyleneCylinderPurchased;
    private Double sepCylinderCapacity;
    private Double sepMaterialCost;

    private Double octAcetyleneCylinderPurchased;
    private Double octCylinderCapacity;
    private Double octMaterialCost;

    private Double novAcetyleneCylinderPurchased;
    private Double novCylinderCapacity;
    private Double novMaterialCost;

    private Double decAcetyleneCylinderPurchased;
    private Double decCylinderCapacity;
    private Double decMaterialCost;

    private Double janAcetyleneCylinderPurchased;
    private Double janCylinderCapacity;
    private Double janMaterialCost;

    private Double febAcetyleneCylinderPurchased;
    private Double febCylinderCapacity;
    private Double febMaterialCost;

    private Double marAcetyleneCylinderPurchased;
    private Double marCylinderCapacity;
    private Double marMaterialCost;

    // Method to convert DTO to S1Acetylene entity
    public S1Acetylene toS1Acetylene(String month, Double acetyleneCylinderPurchased, Double cylinderCapacity,
                                     Double materialCost, Double monthlyEmission, Long loginId) {
        S1Acetylene data = new S1Acetylene();
        data.setMonth(month);
        data.setYear(year);
        data.setAcetyleneCylinderPurchased(acetyleneCylinderPurchased);
        data.setCylinderCapacity(cylinderCapacity);
        data.setCylinderCapacityUOM(cylinderCapacityUOM);
        data.setMaterialCost(materialCost);
        data.setMonthlyEmission(monthlyEmission);

        Login login = new Login();
        login.setId(loginId);
        data.setLogin(login);

        return data;
    }
}
