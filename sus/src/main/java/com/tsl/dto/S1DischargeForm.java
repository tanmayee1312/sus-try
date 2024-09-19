package com.tsl.dto;

import com.tsl.pojo.Login;
import com.tsl.pojo.S1Discharge;
import lombok.Getter;
import lombok.Setter;
/*
@Getter
@Setter
public class S1DischargeForm {
    private Long userId;
    private String year;

    private Double aprMolasisUsed;
    private Double aprCo2ReleasedFermentation;

    private Double mayMolasisUsed;
    private Double mayCo2ReleasedFermentation;

    private Double junMolasisUsed;
    private Double junCo2ReleasedFermentation;

    private Double julMolasisUsed;
    private Double julCo2ReleasedFermentation;

    private Double augMolasisUsed;
    private Double augCo2ReleasedFermentation;

    private Double sepMolasisUsed;
    private Double sepCo2ReleasedFermentation;

    private Double octMolasisUsed;
    private Double octCo2ReleasedFermentation;

    private Double novMolasisUsed;
    private Double novCo2ReleasedFermentation;

    private Double decMolasisUsed;
    private Double decCo2ReleasedFermentation;

    private Double janMolasisUsed;
    private Double janCo2ReleasedFermentation;

    private Double febMolasisUsed;
    private Double febCo2ReleasedFermentation;

    private Double marMolasisUsed;
    private Double marCo2ReleasedFermentation;

    public S1Discharge toS1Discharge(String month, Double molasisUsed, Double co2ReleasedFermentation, Long loginId) {
        S1Discharge data = new S1Discharge();
        data.setYear(year);
        data.setMonth(month);
        data.setMolasisUsed(molasisUsed);
        data.setCo2ReleasedFermentation(co2ReleasedFermentation);
        
        // Assuming you have a method to fetch Login by loginId
        Login login = new Login(); // Replace with actual fetching logic
        login.setId(loginId);
        data.setLogin(login);
        
        return data;
    }
}
*/
@Getter
@Setter
public class S1DischargeForm {
    private Long userId;
    private String year;

    private Double percentageOfSugarInMolasis;
    private String molasisUsedUOM; // Add this field
    private String co2ReleasedFermentationUOM;
    private String ethanolProducedUOM;

    private Double aprMolasisUsed;
    private Double aprCo2ReleasedFermentation;
    private Double aprEthanolProduced;

    private Double mayMolasisUsed;
    private Double mayCo2ReleasedFermentation;
    private Double mayEthanolProduced;

    private Double junMolasisUsed;
    private Double junCo2ReleasedFermentation;
    private Double junEthanolProduced;

    private Double julMolasisUsed;
    private Double julCo2ReleasedFermentation;
    private Double julEthanolProduced;

    private Double augMolasisUsed;
    private Double augCo2ReleasedFermentation;
    private Double augEthanolProduced;

    private Double sepMolasisUsed;
    private Double sepCo2ReleasedFermentation;
    private Double sepEthanolProduced;

    private Double octMolasisUsed;
    private Double octCo2ReleasedFermentation;
    private Double octEthanolProduced;

    private Double novMolasisUsed;
    private Double novCo2ReleasedFermentation;
    private Double novEthanolProduced;

    private Double decMolasisUsed;
    private Double decCo2ReleasedFermentation;
    private Double decEthanolProduced;

    private Double janMolasisUsed;
    private Double janCo2ReleasedFermentation;
    private Double janEthanolProduced;

    private Double febMolasisUsed;
    private Double febCo2ReleasedFermentation;
    private Double febEthanolProduced;

    private Double marMolasisUsed;
    private Double marCo2ReleasedFermentation;
    private Double marEthanolProduced;

    // Method to convert to S1Discharge object
    public S1Discharge toS1Discharge(String month, Double molasisUsed, Double co2ReleasedFermentation, Double ethanolProduced, Long loginId) {
        S1Discharge data = new S1Discharge();
        data.setYear(year);
        data.setMonth(month);
        data.setMolasisUsed(molasisUsed);
        data.setCo2ReleasedFermentation(co2ReleasedFermentation);
        data.setEthanolProduced(ethanolProduced);
        data.setPercentageOfSugarInMolasis(percentageOfSugarInMolasis);
        data.setCo2ReleasedFermentationUOM(co2ReleasedFermentationUOM);
        data.setEthanolProducedUOM(ethanolProducedUOM);
        data.setMolasisUsedUOM(molasisUsedUOM); // Set the UOM for molasis
        
        Login login = new Login();
        login.setId(loginId);
        data.setLogin(login);
        
        return data;
    }
}
