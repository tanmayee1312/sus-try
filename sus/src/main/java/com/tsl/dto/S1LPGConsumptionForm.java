package com.tsl.dto;
/*
import com.tsl.pojo.Login;
import com.tsl.pojo.S1LPGConsumption;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S1LPGConsumptionForm {
    private Long userId;
    private String year;

    private Double aprConsumption;
    private Double aprCylindersPurchased;
    private Double aprCylinderCapacity;

    private Double mayConsumption;
    private Double mayCylindersPurchased;
    private Double mayCylinderCapacity;

    private Double junConsumption;
    private Double junCylindersPurchased;
    private Double junCylinderCapacity;

    private Double julConsumption;
    private Double julCylindersPurchased;
    private Double julCylinderCapacity;

    private Double augConsumption;
    private Double augCylindersPurchased;
    private Double augCylinderCapacity;

    private Double sepConsumption;
    private Double sepCylindersPurchased;
    private Double sepCylinderCapacity;

    private Double octConsumption;
    private Double octCylindersPurchased;
    private Double octCylinderCapacity;

    private Double novConsumption;
    private Double novCylindersPurchased;
    private Double novCylinderCapacity;

    private Double decConsumption;
    private Double decCylindersPurchased;
    private Double decCylinderCapacity;

    private Double janConsumption;
    private Double janCylindersPurchased;
    private Double janCylinderCapacity;

    private Double febConsumption;
    private Double febCylindersPurchased;
    private Double febCylinderCapacity;

    private Double marConsumption;
    private Double marCylindersPurchased;
    private Double marCylinderCapacity;

    public S1LPGConsumption toS1CompanyOwnedVehicles(String month, Double consumption, Double cylindersPurchased, Double cylinderCapacity, Long loginId) {
        S1LPGConsumption data = new S1LPGConsumption();
        data.setYear(year);
        data.setMonth(month);
        data.setConsumption(consumption);
        data.setCylindersPurchased(cylindersPurchased);
        data.setCylinderCapacity(cylinderCapacity);
        
        // Assuming you have a method to fetch Login by loginId
        Login login = new Login(); // Replace with actual fetching logic
        login.setId(loginId);
        data.setLogin(login);
        
        return data;
    }
}
*/



import java.util.ArrayList;
import java.util.List;

import com.tsl.pojo.Login;
import com.tsl.pojo.S1LPGConsumption;
import lombok.Getter;
import lombok.Setter;


/*
@Getter
@Setter
public class S1LPGConsumptionForm {
    private Long userId;
    private String year;

    private String consumptionUOM; // Unit of measurement for consumption
    private String cylinderCapacityUOM; // Unit of measurement for cylinder capacity

    private Double aprConsumption;
    private Double aprCylindersPurchased;
    private Double aprCylinderCapacity;

    private Double mayConsumption;
    private Double mayCylindersPurchased;
    private Double mayCylinderCapacity;

    private Double junConsumption;
    private Double junCylindersPurchased;
    private Double junCylinderCapacity;

    private Double julConsumption;
    private Double julCylindersPurchased;
    private Double julCylinderCapacity;

    private Double augConsumption;
    private Double augCylindersPurchased;
    private Double augCylinderCapacity;

    private Double sepConsumption;
    private Double sepCylindersPurchased;
    private Double sepCylinderCapacity;

    private Double octConsumption;
    private Double octCylindersPurchased;
    private Double octCylinderCapacity;

    private Double novConsumption;
    private Double novCylindersPurchased;
    private Double novCylinderCapacity;

    private Double decConsumption;
    private Double decCylindersPurchased;
    private Double decCylinderCapacity;

    private Double janConsumption;
    private Double janCylindersPurchased;
    private Double janCylinderCapacity;

    private Double febConsumption;
    private Double febCylindersPurchased;
    private Double febCylinderCapacity;

    private Double marConsumption;
    private Double marCylindersPurchased;
    private Double marCylinderCapacity;

    
    
//    // Method to calculate CO2 emissions based on consumption and unit
//    public double calculateCO2Emission(double consumption, String unit) {
//        double emissionFactor = 0.0;
//        double adjustedConsumption = consumption;
//
//        // Convert units and apply emission factor
//        switch (unit.toLowerCase()) {
//            case "kg":
//                emissionFactor = 2939.36094899329; // for kg
//                adjustedConsumption = consumption / 1000; // Convert kg to tonnes
//                break;
//            case "litre":
//                emissionFactor = 1.55712778389262; // for litre
//                break;
//            case "m3":
//                emissionFactor = 1.55712778389262; // for m³, but needs conversion to litres first
//                adjustedConsumption = consumption * 1000; // Convert m³ to litres
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported unit: " + unit);
//        }
//
//        // Return the calculated CO2 emission
//        return adjustedConsumption * emissionFactor;
//    }

    
    public double calculateCO2Emission(double consumption, String unit) {
        double emissionFactor = 0.0;
        double adjustedConsumption = consumption;

        // Convert units and apply emission factor
        switch (unit.toLowerCase()) {
            case "kg":
                emissionFactor = 2939.36094899329; // for kg
                adjustedConsumption = consumption / 1000; // Convert kg to tonnes
                break;
            case "litre":
                emissionFactor = 1.55712778389262; // for litre
                break;
            case "meter cube":
                emissionFactor = 1.55712778389262; // for meter cube, but needs conversion to litres first
                adjustedConsumption = consumption * 1000; // Convert meter cube to litres
                break;
            case "tonnes":
                emissionFactor = 2939.36094899329; // for tonnes
                break;
            default:
                throw new IllegalArgumentException("Unsupported unit: " + unit);
        }

        // Return the calculated CO2 emission
        return adjustedConsumption * emissionFactor;
    }


    // Method to map to the S1LPGConsumption entity
    public S1LPGConsumption toS1LPGConsumption(String month, Double consumption, Double cylindersPurchased, Double cylinderCapacity, Long loginId) {
        S1LPGConsumption data = new S1LPGConsumption();
        data.setYear(year);
        data.setMonth(month);
        data.setConsumption(consumption);
        data.setCylindersPurchased(cylindersPurchased);
        data.setCylinderCapacity(cylinderCapacity);

        // Apply UOM
        data.setConsumptionUOM(consumptionUOM);
        data.setCylinderCapacityUOM(cylinderCapacityUOM);

        // Calculate CO2 emission for the month
        double co2Emission = calculateCO2Emission(consumption, consumptionUOM);
        data.setCo2Emission(co2Emission);

        // Set login data
        Login login = new Login();
        login.setId(loginId);
        data.setLogin(login);

        return data;
    }

    // Method to convert the form into a list of S1LPGConsumption entities
    public List<S1LPGConsumption> toS1LPGConsumptionList() {
        List<S1LPGConsumption> list = new ArrayList<>();
        Long loginId = userId; // Assuming userId is used as loginId
        list.add(toS1LPGConsumption("Apr", aprConsumption, aprCylindersPurchased, aprCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("May", mayConsumption, mayCylindersPurchased, mayCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Jun", junConsumption, junCylindersPurchased, junCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Jul", julConsumption, julCylindersPurchased, julCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Aug", augConsumption, augCylindersPurchased, augCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Sep", sepConsumption, sepCylindersPurchased, sepCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Oct", octConsumption, octCylindersPurchased, octCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Nov", novConsumption, novCylindersPurchased, novCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Dec", decConsumption, decCylindersPurchased, decCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Jan", janConsumption, janCylindersPurchased, janCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Feb", febConsumption, febCylindersPurchased, febCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Mar", marConsumption, marCylindersPurchased, marCylinderCapacity, loginId));
        return list;
    }
}
*/


@Getter
@Setter
public class S1LPGConsumptionForm {
    private Long userId;
    private String year;

    // UOM fields that are applied to all months
    private String consumptionUOM; // Unit of measurement for consumption
    private String cylinderCapacityUOM; // Unit of measurement for cylinder capacity

    // Monthly LPG consumption data
    private Double aprConsumption;
    private Double aprCylindersPurchased;
    private Double aprCylinderCapacity;

    private Double mayConsumption;
    private Double mayCylindersPurchased;
    private Double mayCylinderCapacity;

    private Double junConsumption;
    private Double junCylindersPurchased;
    private Double junCylinderCapacity;

    private Double julConsumption;
    private Double julCylindersPurchased;
    private Double julCylinderCapacity;

    private Double augConsumption;
    private Double augCylindersPurchased;
    private Double augCylinderCapacity;

    private Double sepConsumption;
    private Double sepCylindersPurchased;
    private Double sepCylinderCapacity;

    private Double octConsumption;
    private Double octCylindersPurchased;
    private Double octCylinderCapacity;

    private Double novConsumption;
    private Double novCylindersPurchased;
    private Double novCylinderCapacity;

    private Double decConsumption;
    private Double decCylindersPurchased;
    private Double decCylinderCapacity;

    private Double janConsumption;
    private Double janCylindersPurchased;
    private Double janCylinderCapacity;

    private Double febConsumption;
    private Double febCylindersPurchased;
    private Double febCylinderCapacity;

    private Double marConsumption;
    private Double marCylindersPurchased;
    private Double marCylinderCapacity;

    // Total CO2 emission for all months
    private double totalCO2Emission;

    // Method to calculate CO2 emissions based on consumption and unit
    public double calculateCO2Emission(double consumption, String unit) {
        double emissionFactor = 0.0;
        double adjustedConsumption = consumption;

        switch (unit.toLowerCase()) {
            case "kg":
                emissionFactor = 2939.36094899329; // for kg
                adjustedConsumption = consumption / 1000; // Convert kg to tonnes
                break;
            case "litre":
                emissionFactor = 1.55712778389262; // for litre
                break;
            case "meter cube":
                emissionFactor = 1.55712778389262; // for meter cube
                adjustedConsumption = consumption * 1000; // Convert meter cube to litres
                break;
            case "tonnes":
                emissionFactor = 2939.36094899329; // for tonnes
                break;
            default:
                throw new IllegalArgumentException("Unsupported unit: " + unit);
        }

        return adjustedConsumption * emissionFactor;
    }

    // Method to calculate total CO2 emission for the entire year
    public void calculateTotalCO2Emission() {
        totalCO2Emission = 0.0;
        
        totalCO2Emission += calculateCO2Emission(aprConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(mayConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(junConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(julConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(augConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(sepConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(octConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(novConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(decConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(janConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(febConsumption, consumptionUOM);
        totalCO2Emission += calculateCO2Emission(marConsumption, consumptionUOM);
    }

    // Method to map to the S1LPGConsumption entity
    public S1LPGConsumption toS1LPGConsumption(String month, Double consumption, Double cylindersPurchased, Double cylinderCapacity, Long loginId) {
        S1LPGConsumption data = new S1LPGConsumption();
        data.setYear(year);
        data.setMonth(month);
        data.setConsumption(consumption);
        data.setCylindersPurchased(cylindersPurchased);
        data.setCylinderCapacity(cylinderCapacity);

        // Apply UOM
        data.setConsumptionUOM(consumptionUOM);
        data.setCylinderCapacityUOM(cylinderCapacityUOM);

        // Calculate CO2 emission for the month
        double co2Emission = calculateCO2Emission(consumption, consumptionUOM);
        data.setCo2Emission(co2Emission);

        // Set total CO2 emission (same for all months)
        data.setTotalCO2Emission(totalCO2Emission);

        // Set login data
        Login login = new Login();
        login.setId(loginId);
        data.setLogin(login);

        return data;
    }

    // Method to convert the form into a list of S1LPGConsumption entities
    public List<S1LPGConsumption> toS1LPGConsumptionList() {
        calculateTotalCO2Emission(); // Calculate the total CO2 emission once for all months

        List<S1LPGConsumption> list = new ArrayList<>();
        Long loginId = userId; // Assuming userId is used as loginId
        list.add(toS1LPGConsumption("Apr", aprConsumption, aprCylindersPurchased, aprCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("May", mayConsumption, mayCylindersPurchased, mayCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Jun", junConsumption, junCylindersPurchased, junCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Jul", julConsumption, julCylindersPurchased, julCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Aug", augConsumption, augCylindersPurchased, augCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Sep", sepConsumption, sepCylindersPurchased, sepCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Oct", octConsumption, octCylindersPurchased, octCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Nov", novConsumption, novCylindersPurchased, novCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Dec", decConsumption, decCylindersPurchased, decCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Jan", janConsumption, janCylindersPurchased, janCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Feb", febConsumption, febCylindersPurchased, febCylinderCapacity, loginId));
        list.add(toS1LPGConsumption("Mar", marConsumption, marCylindersPurchased, marCylinderCapacity, loginId));
        return list;
    }
}
