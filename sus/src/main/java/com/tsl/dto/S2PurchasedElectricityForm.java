//package com.tsl.dto;
//
//import com.tsl.pojo.Login;
//import com.tsl.pojo.S2PurchasedElectricity;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class S2PurchasedElectricityForm {
//    private Long userId;
//    private String year;
//
//    private Double aprElectricityImported;
//    private Double aprImportedCharges;
//    private Double aprElectricityExported;
//    private String aprFuelUsed;
//    private Double aprFuelQuantity;
//
//    private Double mayElectricityImported;
//    private Double mayImportedCharges;
//    private Double mayElectricityExported;
//    private String mayFuelUsed;
//    private Double mayFuelQuantity;
//
//    private Double junElectricityImported;
//    private Double junImportedCharges;
//    private Double junElectricityExported;
//    private String junFuelUsed;
//    private Double junFuelQuantity;
//
//    private Double julElectricityImported;
//    private Double julImportedCharges;
//    private Double julElectricityExported;
//    private String julFuelUsed;
//    private Double julFuelQuantity;
//
//    private Double augElectricityImported;
//    private Double augImportedCharges;
//    private Double augElectricityExported;
//    private String augFuelUsed;
//    private Double augFuelQuantity;
//
//    private Double sepElectricityImported;
//    private Double sepImportedCharges;
//    private Double sepElectricityExported;
//    private String sepFuelUsed;
//    private Double sepFuelQuantity;
//
//    private Double octElectricityImported;
//    private Double octImportedCharges;
//    private Double octElectricityExported;
//    private String octFuelUsed;
//    private Double octFuelQuantity;
//
//    private Double novElectricityImported;
//    private Double novImportedCharges;
//    private Double novElectricityExported;
//    private String novFuelUsed;
//    private Double novFuelQuantity;
//
//    private Double decElectricityImported;
//    private Double decFuelQuantity;
//	private Double decImportedCharges;
//    private Double decElectricityExported;
//    private String decFuelUsed;
//    private Double janElectricityImported;
//    private Double janImportedCharges;
//    private Double janElectricityExported;
//    private String janFuelUsed;
//    private Double janFuelQuantity;
//
//    private Double febElectricityImported;
//    private Double febImportedCharges;
//    private Double febElectricityExported;
//    private String febFuelUsed;
//    private Double febFuelQuantity;
//
//    private Double marElectricityImported;
//    private Double marImportedCharges;
//    private Double marElectricityExported;
//    private String marFuelUsed;
//    private Double marFuelQuantity;
//
//    public S2PurchasedElectricity toS2PurchasedElectricity(String month, Double electricityImported, Double importedCharges, Double electricityExported, String fuelUsed, Double fuelQuantity, Long loginId) {
//        S2PurchasedElectricity data = new S2PurchasedElectricity();
//        data.setYear(year);
//        data.setMonth(month);
//        data.setElectricityImported(electricityImported);
//        data.setImportedCharges(importedCharges);
//        data.setElectricityExported(electricityExported);
//        data.setFuelUsed(fuelUsed);
//        data.setFuelQuantity(fuelQuantity);
//        
//        // Assuming you have a method to fetch Login by loginId
//        Login login = new Login(); // Replace with actual fetching logic
//        login.setId(loginId);
//        data.setLogin(login);
//        
//        return data;
//    }
//}





///-----------------------------------------------done calculations--------------------------------------------------------------------

/*
package com.tsl.dto;

import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.pojo.Login;

import lombok.Getter;
import lombok.Setter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S2PurchasedElectricityForm {
    private Long userId;  // Represents the login ID
    private String year;  // The year is entered once

    private String electricityImportedUOM;  // Unit of measurement for all months
    private String electricityExportedUOM;  // Unit of measurement for all months
    private String fuelUOM;  // Unit of measurement for fuel for all months

    // April data
    private Double aprElectricityImported;
    private Double aprImportedCharges;
    private Double aprElectricityExported;
    private Double aprExportedCharges;
    private String aprFuelUsed;
    private Double aprFuelQuantity;
    private Double aprImportedEmission;
    private Double aprExportedEmission;

    // May data
    private Double mayElectricityImported;
    private Double mayImportedCharges;
    private Double mayElectricityExported;
    private Double mayExportedCharges;
    private String mayFuelUsed;
    private Double mayFuelQuantity;
    private Double mayImportedEmission;
    private Double mayExportedEmission;

    // June data
    private Double junElectricityImported;
    private Double junImportedCharges;
    private Double junElectricityExported;
    private Double junExportedCharges;
    private String junFuelUsed;
    private Double junFuelQuantity;
    private Double junImportedEmission;
    private Double junExportedEmission;

    // July data
    private Double julElectricityImported;
    private Double julImportedCharges;
    private Double julElectricityExported;
    private Double julExportedCharges;
    private String julFuelUsed;
    private Double julFuelQuantity;
    private Double julImportedEmission;
    private Double julExportedEmission;

    // August data
    private Double augElectricityImported;
    private Double augImportedCharges;
    private Double augElectricityExported;
    private Double augExportedCharges;
    private String augFuelUsed;
    private Double augFuelQuantity;
    private Double augImportedEmission;
    private Double augExportedEmission;

    // September data
    private Double sepElectricityImported;
    private Double sepImportedCharges;
    private Double sepElectricityExported;
    private Double sepExportedCharges;
    private String sepFuelUsed;
    private Double sepFuelQuantity;
    private Double sepImportedEmission;
    private Double sepExportedEmission;

    // October data
    private Double octElectricityImported;
    private Double octImportedCharges;
    private Double octElectricityExported;
    private Double octExportedCharges;
    private String octFuelUsed;
    private Double octFuelQuantity;
    private Double octImportedEmission;
    private Double octExportedEmission;

    // November data
    private Double novElectricityImported;
    private Double novImportedCharges;
    private Double novElectricityExported;
    private Double novExportedCharges;
    private String novFuelUsed;
    private Double novFuelQuantity;
    private Double novImportedEmission;
    private Double novExportedEmission;

    // December data
    private Double decElectricityImported;
    private Double decImportedCharges;
    private Double decElectricityExported;
    private Double decExportedCharges;
    private String decFuelUsed;
    private Double decFuelQuantity;
    private Double decImportedEmission;
    private Double decExportedEmission;

    // January data
    private Double janElectricityImported;
    private Double janImportedCharges;
    private Double janElectricityExported;
    private Double janExportedCharges;
    private String janFuelUsed;
    private Double janFuelQuantity;
    private Double janImportedEmission;
    private Double janExportedEmission;

    // February data
    private Double febElectricityImported;
    private Double febImportedCharges;
    private Double febElectricityExported;
    private Double febExportedCharges;
    private String febFuelUsed;
    private Double febFuelQuantity;
    private Double febImportedEmission;
    private Double febExportedEmission;

    // March data
    private Double marElectricityImported;
    private Double marImportedCharges;
    private Double marElectricityExported;
    private Double marExportedCharges;
    private String marFuelUsed;
    private Double marFuelQuantity;
    private Double marImportedEmission;
    private Double marExportedEmission;

    // Method to convert DTO to Entity
    public S2PurchasedElectricity toS2PurchasedElectricity(String month, Double electricityImported, Double importedCharges,
                                                          Double electricityExported, Double exportedCharges,
                                                          String fuelUsed, Double fuelQuantity, Long loginId,
                                                          Double importedEmission, Double exportedEmission) {
        S2PurchasedElectricity data = new S2PurchasedElectricity();
        data.setYear(year);
        data.setMonth(month);
        data.setElectricityImported(electricityImported);
        data.setImportedCharges(importedCharges);
        data.setElectricityExported(electricityExported);
        data.setExportedCharges(exportedCharges);
        data.setFuelUsed(fuelUsed);
        data.setFuelQuantity(fuelQuantity);
        data.setElectricityImportedUOM(electricityImportedUOM);
        data.setElectricityExportedUOM(electricityExportedUOM);
        data.setFuelUOM(fuelUOM);
        data.setImportedEmission(importedEmission);
        data.setExportedEmission(exportedEmission);
        
        Login login = new Login();
        login.setId(loginId);
        data.setLogin(login);
        
        return data;
    }
}
*/

///-----------------------------------------------done calculations wiith to add total emission--------------------------------------------------------------------
package com.tsl.dto;

import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.pojo.Login;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class S2PurchasedElectricityForm {
    private Long userId;  // Represents the login ID
    private String year;  // The year is entered once

    private String electricityImportedUOM;  // Unit of measurement for all months
    private String electricityExportedUOM;  // Unit of measurement for all months
    private String fuelUOM;  // Unit of measurement for fuel for all months
    private Double totalEmission;


    // April data
    private Double aprElectricityImported;
    private Double aprImportedCharges;
    private Double aprElectricityExported;
    private Double aprExportedCharges;
    private String aprFuelUsed;
    private Double aprFuelQuantity;
    private Double aprImportedEmission;
    private Double aprExportedEmission;

    // May data
    private Double mayElectricityImported;
    private Double mayImportedCharges;
    private Double mayElectricityExported;
    private Double mayExportedCharges;
    private String mayFuelUsed;
    private Double mayFuelQuantity;
    private Double mayImportedEmission;
    private Double mayExportedEmission;

    // June data
    private Double junElectricityImported;
    private Double junImportedCharges;
    private Double junElectricityExported;
    private Double junExportedCharges;
    private String junFuelUsed;
    private Double junFuelQuantity;
    private Double junImportedEmission;
    private Double junExportedEmission;

    // July data
    private Double julElectricityImported;
    private Double julImportedCharges;
    private Double julElectricityExported;
    private Double julExportedCharges;
    private String julFuelUsed;
    private Double julFuelQuantity;
    private Double julImportedEmission;
    private Double julExportedEmission;

    // August data
    private Double augElectricityImported;
    private Double augImportedCharges;
    private Double augElectricityExported;
    private Double augExportedCharges;
    private String augFuelUsed;
    private Double augFuelQuantity;
    private Double augImportedEmission;
    private Double augExportedEmission;

    // September data
    private Double sepElectricityImported;
    private Double sepImportedCharges;
    private Double sepElectricityExported;
    private Double sepExportedCharges;
    private String sepFuelUsed;
    private Double sepFuelQuantity;
    private Double sepImportedEmission;
    private Double sepExportedEmission;

    // October data
    private Double octElectricityImported;
    private Double octImportedCharges;
    private Double octElectricityExported;
    private Double octExportedCharges;
    private String octFuelUsed;
    private Double octFuelQuantity;
    private Double octImportedEmission;
    private Double octExportedEmission;

    // November data
    private Double novElectricityImported;
    private Double novImportedCharges;
    private Double novElectricityExported;
    private Double novExportedCharges;
    private String novFuelUsed;
    private Double novFuelQuantity;
    private Double novImportedEmission;
    private Double novExportedEmission;

    // December data
    private Double decElectricityImported;
    private Double decImportedCharges;
    private Double decElectricityExported;
    private Double decExportedCharges;
    private String decFuelUsed;
    private Double decFuelQuantity;
    private Double decImportedEmission;
    private Double decExportedEmission;

    // January data
    private Double janElectricityImported;
    private Double janImportedCharges;
    private Double janElectricityExported;
    private Double janExportedCharges;
    private String janFuelUsed;
    private Double janFuelQuantity;
    private Double janImportedEmission;
    private Double janExportedEmission;

    // February data
    private Double febElectricityImported;
    private Double febImportedCharges;
    private Double febElectricityExported;
    private Double febExportedCharges;
    private String febFuelUsed;
    private Double febFuelQuantity;
    private Double febImportedEmission;
    private Double febExportedEmission;

    // March data
    private Double marElectricityImported;
    private Double marImportedCharges;
    private Double marElectricityExported;
    private Double marExportedCharges;
    private String marFuelUsed;
    private Double marFuelQuantity;
    private Double marImportedEmission;
    private Double marExportedEmission;

    // Method to convert DTO to Entity
    public S2PurchasedElectricity toS2PurchasedElectricity(String month, Double electricityImported, Double importedCharges,
                                                          Double electricityExported, Double exportedCharges,
                                                          String fuelUsed, Double fuelQuantity, Long loginId,
                                                          Double importedEmission, Double exportedEmission) {
        S2PurchasedElectricity data = new S2PurchasedElectricity();
        data.setYear(year);
        data.setMonth(month);
        data.setElectricityImported(electricityImported);
        data.setImportedCharges(importedCharges);
        data.setElectricityExported(electricityExported);
        data.setExportedCharges(exportedCharges);
        data.setFuelUsed(fuelUsed);
        data.setFuelQuantity(fuelQuantity);
        data.setElectricityImportedUOM(electricityImportedUOM);
        data.setElectricityExportedUOM(electricityExportedUOM);
        data.setFuelUOM(fuelUOM);
        data.setImportedEmission(importedEmission);
        data.setExportedEmission(exportedEmission);
        
        Login login = new Login();
        login.setId(loginId);
        data.setLogin(login);
        
        return data;
    }
}
