package com.tsl.dto;

import com.tsl.pojo.Login;
import com.tsl.pojo.S1ArcWelding;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S1ArcWeldingForm {
    private Long userId;
    private String year;

    private double janElectrodesPurchased;
    private String janElectrodePurpose;
    private double janOpenCircuitVoltage;
    private double janCloseCircuitVoltage;
    private double janElectrodesCost;

    private double febElectrodesPurchased;
    private String febElectrodePurpose;
    private double febOpenCircuitVoltage;
    private double febCloseCircuitVoltage;
    private double febElectrodesCost;

    private double marElectrodesPurchased;
    private String marElectrodePurpose;
    private double marOpenCircuitVoltage;
    private double marCloseCircuitVoltage;
    private double marElectrodesCost;

    private double aprElectrodesPurchased;
    private String aprElectrodePurpose;
    private double aprOpenCircuitVoltage;
    private double aprCloseCircuitVoltage;
    private double aprElectrodesCost;

    private double mayElectrodesPurchased;
    private String mayElectrodePurpose;
    private double mayOpenCircuitVoltage;
    private double mayCloseCircuitVoltage;
    private double mayElectrodesCost;

    private double junElectrodesPurchased;
    private String junElectrodePurpose;
    private double junOpenCircuitVoltage;
    private double junCloseCircuitVoltage;
    private double junElectrodesCost;

    private double julElectrodesPurchased;
    private String julElectrodePurpose;
    private double julOpenCircuitVoltage;
    private double julCloseCircuitVoltage;
    private double julElectrodesCost;

    private double augElectrodesPurchased;
    private String augElectrodePurpose;
    private double augOpenCircuitVoltage;
    private double augCloseCircuitVoltage;
    private double augElectrodesCost;

    private double sepElectrodesPurchased;
    private String sepElectrodePurpose;
    private double sepOpenCircuitVoltage;
    private double sepCloseCircuitVoltage;
    private double sepElectrodesCost;

    private double octElectrodesPurchased;
    private String octElectrodePurpose;
    private double octOpenCircuitVoltage;
    private double octCloseCircuitVoltage;
    private double octElectrodesCost;

    private double novElectrodesPurchased;
    private String novElectrodePurpose;
    private double novOpenCircuitVoltage;
    private double novCloseCircuitVoltage;
    private double novElectrodesCost;

    private double decElectrodesPurchased;
    private String decElectrodePurpose;
    private double decOpenCircuitVoltage;
    private double decCloseCircuitVoltage;
    private double decElectrodesCost;

    public S1ArcWelding toS1ArcWelding(String month, double electrodesPurchased, String electrodePurpose,
                                       double openCircuitVoltage, double closeCircuitVoltage, double electrodesCost, Long loginId) {
        S1ArcWelding welding = new S1ArcWelding();
        welding.setYear(year);
        welding.setMonth(month);
        welding.setElectrodesPurchased(electrodesPurchased);
        welding.setElectrodePurpose(electrodePurpose);
        welding.setOpenCircuitVoltage(openCircuitVoltage);
        welding.setCloseCircuitVoltage(closeCircuitVoltage);
        welding.setElectrodesCost(electrodesCost);
        
        // Assuming you have a method to fetch Login by loginId
        Login login = new Login(); // Replace with actual fetching logic
        login.setId(loginId);
        welding.setLogin(login);
        
        return welding;
    }
}
