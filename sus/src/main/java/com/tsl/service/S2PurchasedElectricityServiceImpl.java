//package com.tsl.service;
//
//import com.tsl.pojo.S2PurchasedElectricity;
//import com.tsl.pojo.Login;
//import com.tsl.dto.S2PurchasedElectricityForm;
//import com.tsl.repository.S2PurchasedElectricityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class S2PurchasedElectricityServiceImpl implements S2PurchasedElectricityService {
//
//    @Autowired
//    private S2PurchasedElectricityRepository repository;
//
//    @Override
//    public List<S2PurchasedElectricity> saveOrUpdate(S2PurchasedElectricityForm form) {
//        List<S2PurchasedElectricity> dataList = new ArrayList<>();
//
//
//        dataList.add(createOrUpdateEntity("Apr", form.getAprElectricityImported(), form.getAprImportedCharges(), form.getAprElectricityExported(), form.getAprFuelUsed(), form.getAprFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("May", form.getMayElectricityImported(), form.getMayImportedCharges(), form.getMayElectricityExported(), form.getMayFuelUsed(), form.getMayFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Jun", form.getJunElectricityImported(), form.getJunImportedCharges(), form.getJunElectricityExported(), form.getJunFuelUsed(), form.getJunFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Jul", form.getJulElectricityImported(), form.getJulImportedCharges(), form.getJulElectricityExported(), form.getJulFuelUsed(), form.getJulFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Aug", form.getAugElectricityImported(), form.getAugImportedCharges(), form.getAugElectricityExported(), form.getAugFuelUsed(), form.getAugFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Sep", form.getSepElectricityImported(), form.getSepImportedCharges(), form.getSepElectricityExported(), form.getSepFuelUsed(), form.getSepFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Oct", form.getOctElectricityImported(), form.getOctImportedCharges(), form.getOctElectricityExported(), form.getOctFuelUsed(), form.getOctFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Nov", form.getNovElectricityImported(), form.getNovImportedCharges(), form.getNovElectricityExported(), form.getNovFuelUsed(), form.getNovFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Dec", form.getDecElectricityImported(), form.getDecImportedCharges(), form.getDecElectricityExported(), form.getDecFuelUsed(), form.getDecFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Jan", form.getJanElectricityImported(), form.getJanImportedCharges(), form.getJanElectricityExported(), form.getJanFuelUsed(), form.getJanFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Feb", form.getFebElectricityImported(), form.getFebImportedCharges(), form.getFebElectricityExported(), form.getFebFuelUsed(), form.getFebFuelQuantity(), form.getUserId(), form.getYear()));
//        dataList.add(createOrUpdateEntity("Mar", form.getMarElectricityImported(), form.getMarImportedCharges(), form.getMarElectricityExported(), form.getMarFuelUsed(), form.getMarFuelQuantity(), form.getUserId(), form.getYear()));
//        return repository.saveAll(dataList);
//    }
//
//
//    private S2PurchasedElectricity createOrUpdateEntity(String month, Double electricityImported, Double importedCharges, Double electricityExported, String fuelUsed, Double fuelQuantity, Long loginId, String year) {
//        S2PurchasedElectricity entity = new S2PurchasedElectricity();
//        entity.setMonth(month);
//        entity.setElectricityImported(electricityImported);
//        entity.setImportedCharges(importedCharges);
//        entity.setElectricityExported(electricityExported);
//        entity.setFuelUsed(fuelUsed);
//        entity.setFuelQuantity(fuelQuantity);
//        entity.setYear(year);
//        // Set Login
//        Login login = new Login();
//        login.setId(loginId);
//        entity.setLogin(login);
//        return entity;
//    }
//
//    @Override
//    public List<S2PurchasedElectricity> getByLoginId(Long loginId) {
//        return repository.findByLoginId(loginId);
//    }
//
//    @Override
//    public List<S2PurchasedElectricity> getByLoginIdAndYear(Long loginId, String year) {
//        return repository.findByLoginIdAndYear(loginId, year);
//    }
//}


//----------------------------------------------only for posting -------------------------------------------------------

/*
package com.tsl.service;

import com.tsl.dto.S2PurchasedElectricityForm;
import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.repository.S2PurchasedElectricityRepository;
import com.tsl.service.S2PurchasedElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S2PurchasedElectricityServiceImpl implements S2PurchasedElectricityService {

    @Autowired
    private S2PurchasedElectricityRepository repository;

    @Override
    public void saveS2PurchasedElectricity(S2PurchasedElectricityForm form) {
        List<S2PurchasedElectricity> records = new ArrayList<>();

        // Adding each month's data to the list
        records.add(form.toS2PurchasedElectricity("April", form.getAprElectricityImported(), form.getAprImportedCharges(), form.getAprElectricityExported(), form.getAprExportedCharges(), form.getAprFuelUsed(), form.getAprFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("May", form.getMayElectricityImported(), form.getMayImportedCharges(), form.getMayElectricityExported(), form.getMayExportedCharges(), form.getMayFuelUsed(), form.getMayFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("June", form.getJunElectricityImported(), form.getJunImportedCharges(), form.getJunElectricityExported(), form.getJunExportedCharges(), form.getJunFuelUsed(), form.getJunFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("July", form.getJulElectricityImported(), form.getJulImportedCharges(), form.getJulElectricityExported(), form.getJulExportedCharges(), form.getJulFuelUsed(), form.getJulFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("August", form.getAugElectricityImported(), form.getAugImportedCharges(), form.getAugElectricityExported(), form.getAugExportedCharges(), form.getAugFuelUsed(), form.getAugFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("September", form.getSepElectricityImported(), form.getSepImportedCharges(), form.getSepElectricityExported(), form.getSepExportedCharges(), form.getSepFuelUsed(), form.getSepFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("October", form.getOctElectricityImported(), form.getOctImportedCharges(), form.getOctElectricityExported(), form.getOctExportedCharges(), form.getOctFuelUsed(), form.getOctFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("November", form.getNovElectricityImported(), form.getNovImportedCharges(), form.getNovElectricityExported(), form.getNovExportedCharges(), form.getNovFuelUsed(), form.getNovFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("December", form.getDecElectricityImported(), form.getDecImportedCharges(), form.getDecElectricityExported(), form.getDecExportedCharges(), form.getDecFuelUsed(), form.getDecFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("January", form.getJanElectricityImported(), form.getJanImportedCharges(), form.getJanElectricityExported(), form.getJanExportedCharges(), form.getJanFuelUsed(), form.getJanFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("February", form.getFebElectricityImported(), form.getFebImportedCharges(), form.getFebElectricityExported(), form.getFebExportedCharges(), form.getFebFuelUsed(), form.getFebFuelQuantity(), form.getUserId()));
        records.add(form.toS2PurchasedElectricity("March", form.getMarElectricityImported(), form.getMarImportedCharges(), form.getMarElectricityExported(), form.getMarExportedCharges(), form.getMarFuelUsed(), form.getMarFuelQuantity(), form.getUserId()));

        // Save all records to the repository
        repository.saveAll(records);
    }

    @Override
    public List<S2PurchasedElectricity> getS2PurchasedElectricityByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }
}
*/



//-----------------------------------trying calculations------------------------------------------------------------------
/*
package com.tsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsl.dto.S2PurchasedElectricityForm;
import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.repository.S2PurchasedElectricityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class S2PurchasedElectricityServiceImpl implements S2PurchasedElectricityService {

    @Autowired
    private S2PurchasedElectricityRepository repository;

    private static final double EMISSION_FACTOR = 0.5;

    @Override
    public void saveS2PurchasedElectricity(S2PurchasedElectricityForm form) {
        List<S2PurchasedElectricity> records = new ArrayList<>();

        // Process each month
        for (String month : List.of("April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March")) {
            try {
                // Use reflection to get the values for the current month
                String methodNamePrefix = month.substring(0, 3).toLowerCase(); // e.g., "apr", "may"
                Double electricityImported = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "ElectricityImported").invoke(form);
                Double electricityExported = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "ElectricityExported").invoke(form);
                Double importedCharges = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "ImportedCharges").invoke(form);
                Double exportedCharges = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "ExportedCharges").invoke(form);
                String fuelUsed = (String) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "FuelUsed").invoke(form);
                Double fuelQuantity = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "FuelQuantity").invoke(form);
                String importedUOM = form.getElectricityImportedUOM();
                String exportedUOM = form.getElectricityExportedUOM();

                double importedMWh = convertToMWh(electricityImported, importedUOM);
                double exportedMWh = convertToMWh(electricityExported, exportedUOM);

                double importedEmission = calculateEmission(importedMWh);
                double exportedEmission = calculateEmission(exportedMWh);

                S2PurchasedElectricity record = form.toS2PurchasedElectricity(
                    month, electricityImported, importedCharges,
                    electricityExported, exportedCharges,
                    fuelUsed, fuelQuantity,
                    form.getUserId(), importedEmission, exportedEmission
                );
                records.add(record);
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        // Save all records to the repository
        repository.saveAll(records);
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    public List<S2PurchasedElectricity> getS2PurchasedElectricityByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }

    // Helper method to convert UOM to MWh
    private double convertToMWh(double value, String uom) {
        switch (uom) {
            case "kWh":
                return value / 1000;
            case "MU":
                return value * 1000;
            case "MWh":
                return value;
            default:
                throw new IllegalArgumentException("Unsupported UOM: " + uom);
        }
    }

    // Helper method to calculate emissions
    private double calculateEmission(double value) {
        return value * EMISSION_FACTOR;
    }
}
*/

//-----------------------------------done calculations and  added total emission--------------------------------------------------------------------------
package com.tsl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsl.dto.S2PurchasedElectricityForm;
import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.repository.S2PurchasedElectricityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class S2PurchasedElectricityServiceImpl implements S2PurchasedElectricityService {

    @Autowired
    private S2PurchasedElectricityRepository repository;

    private static final double EMISSION_FACTOR = 0.716;

    @Override
    public void saveS2PurchasedElectricity(S2PurchasedElectricityForm form) {
        List<S2PurchasedElectricity> records = new ArrayList<>();
        double totalImportedEmission = 0.0;
        double totalExportedEmission = 0.0;

        // Process each month
        for (String month : List.of("April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March")) {
            try {
                // Use reflection to get the values for the current month
                String methodNamePrefix = month.substring(0, 3).toLowerCase(); // e.g., "apr", "may"
                Double electricityImported = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "ElectricityImported").invoke(form);
                Double electricityExported = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "ElectricityExported").invoke(form);
                Double importedCharges = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "ImportedCharges").invoke(form);
                Double exportedCharges = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "ExportedCharges").invoke(form);
                String fuelUsed = (String) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "FuelUsed").invoke(form);
                Double fuelQuantity = (Double) S2PurchasedElectricityForm.class.getMethod("get" + capitalize(methodNamePrefix) + "FuelQuantity").invoke(form);
                String importedUOM = form.getElectricityImportedUOM();
                String exportedUOM = form.getElectricityExportedUOM();

                double importedMWh = convertToMWh(electricityImported, importedUOM);
                double exportedMWh = convertToMWh(electricityExported, exportedUOM);

                double importedEmission = calculateEmission(importedMWh);
                double exportedEmission = calculateEmission(exportedMWh);

                totalImportedEmission += importedEmission;
                totalExportedEmission += exportedEmission;

                S2PurchasedElectricity record = form.toS2PurchasedElectricity(
                    month, electricityImported, importedCharges,
                    electricityExported, exportedCharges,
                    fuelUsed, fuelQuantity,
                    form.getUserId(), importedEmission, exportedEmission
                );
                records.add(record);
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        // Set the total emission for all records
        double totalEmission = totalImportedEmission + totalExportedEmission;
        for (S2PurchasedElectricity record : records) {
            record.setTotalEmission(totalEmission);
        }

        // Save all records to the repository
        repository.saveAll(records);
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    public List<S2PurchasedElectricity> getS2PurchasedElectricityByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }

    // Helper method to convert UOM to MWh
    private double convertToMWh(double value, String uom) {
        switch (uom) {
            case "kWh":
                return value / 1000;
            case "MU":
                return value * 1000;
            case "MWh":
                return value;
            default:
                throw new IllegalArgumentException("Unsupported UOM: " + uom);
        }
    }
    

    // Helper method to calculate emissions
    private double calculateEmission(double value) {
        return value * EMISSION_FACTOR;
    }
}
