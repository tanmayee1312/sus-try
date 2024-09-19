package com.tsl.service;

import com.tsl.dto.S1DischargeForm;
import com.tsl.exception.CustomException;
import com.tsl.exception.DataAlreadyExistsException;
import com.tsl.exception.DataNotFoundException;
import com.tsl.pojo.S1Discharge;
import com.tsl.pojo.Login;

import com.tsl.repository.S1DischargeRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/*
@Service
public class S1DischargeServiceImpl implements S1DischargeService {

    @Autowired
    private S1DischargeRepository s1DischargeRepository;

    @Override
    public List<S1Discharge> getAllDischargeDataByLoginId(Long loginId) {
        return s1DischargeRepository.findByLoginId(loginId);
    }

    @Override
    public void saveOrUpdateDischargeData(S1DischargeForm s1DischargeForm, Long loginId) {
        List<S1Discharge> dischargeList = new ArrayList<>();

        // Mapping each month data to S1Discharge entity with updated month names
//        dischargeList.add(s1DischargeForm.toS1Discharge("Apr", s1DischargeForm.getAprMolasisUsed(), s1DischargeForm.getAprCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("May", s1DischargeForm.getMayMolasisUsed(), s1DischargeForm.getMayCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Jun", s1DischargeForm.getJunMolasisUsed(), s1DischargeForm.getJunCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Jul", s1DischargeForm.getJulMolasisUsed(), s1DischargeForm.getJulCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Aug", s1DischargeForm.getAugMolasisUsed(), s1DischargeForm.getAugCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Sep", s1DischargeForm.getSepMolasisUsed(), s1DischargeForm.getSepCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Oct", s1DischargeForm.getOctMolasisUsed(), s1DischargeForm.getOctCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Nov", s1DischargeForm.getNovMolasisUsed(), s1DischargeForm.getNovCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Dec", s1DischargeForm.getDecMolasisUsed(), s1DischargeForm.getDecCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Jan", s1DischargeForm.getJanMolasisUsed(), s1DischargeForm.getJanCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Feb", s1DischargeForm.getFebMolasisUsed(), s1DischargeForm.getFebCo2ReleasedFermentation(), loginId));
//        dischargeList.add(s1DischargeForm.toS1Discharge("Mar", s1DischargeForm.getMarMolasisUsed(), s1DischargeForm.getMarCo2ReleasedFermentation(), loginId));

        
        s1DischargeRepository.saveAll(dischargeList);
    }
    @Override
    public List<S1Discharge> getDischargeDataByLoginIdAndYear(Long loginId, String year) {
        return s1DischargeRepository.findByLogin_IdAndYear(loginId, year);
    }
    
//    @Override
//    public void updateDischargeDataByLoginIdAndYear(S1DischargeForm s1DischargeForm, Long loginId, String year) {
//        List<S1Discharge> existingDischarges = s1DischargeRepository.findByLogin_IdAndYear(loginId, year);
//
//        // Delete the existing records for the given year and loginId
//        s1DischargeRepository.deleteAll(existingDischarges);
//
//        // Save the new data from the form
//        saveOrUpdateDischargeData(s1DischargeForm, loginId);
//    }
    
    @Override
    public void updateDischargeDataByLoginIdAndYear(S1DischargeForm s1DischargeForm, Long loginId, String year) {
        List<S1Discharge> existingDischarges = s1DischargeRepository.findByLogin_IdAndYear(loginId, year);

        if (existingDischarges.isEmpty()) {
            // If no existing records found, throw an exception or handle the case
            throw new DataNotFoundException("No data found to update for loginId: " + loginId + " and year: " + year);
        }

        // Delete the existing records for the given year and loginId
        s1DischargeRepository.deleteAll(existingDischarges);

        // Save the new data from the form
        saveOrUpdateDischargeData(s1DischargeForm, loginId);
    }


}
*/

@Service
public class S1DischargeServiceImpl implements S1DischargeService {

    @Autowired
    private S1DischargeRepository s1DischargeRepository;

    @Override
    public void saveDischargeData(S1DischargeForm form) {
        Long loginId = form.getUserId();
        String year = form.getYear();

        List<S1Discharge> dischargeData = new ArrayList<>();
        // Check if data already exists
        List<S1Discharge> existingData = s1DischargeRepository.findByLogin_IdAndYear(loginId, year);
        if (!existingData.isEmpty()) {
            throw new DataAlreadyExistsException("Data for loginId " + loginId + " and year " + year + " already exists.");
        }
        // Convert and calculate emissions for each month
        dischargeData.add(calculateAndConvert(form.toS1Discharge("April", form.getAprMolasisUsed(), form.getAprCo2ReleasedFermentation(), form.getAprEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("May", form.getMayMolasisUsed(), form.getMayCo2ReleasedFermentation(), form.getMayEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("June", form.getJunMolasisUsed(), form.getJunCo2ReleasedFermentation(), form.getJunEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("July", form.getJulMolasisUsed(), form.getJulCo2ReleasedFermentation(), form.getJulEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("August", form.getAugMolasisUsed(), form.getAugCo2ReleasedFermentation(), form.getAugEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("September", form.getSepMolasisUsed(), form.getSepCo2ReleasedFermentation(), form.getSepEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("October", form.getOctMolasisUsed(), form.getOctCo2ReleasedFermentation(), form.getOctEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("November", form.getNovMolasisUsed(), form.getNovCo2ReleasedFermentation(), form.getNovEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("December", form.getDecMolasisUsed(), form.getDecCo2ReleasedFermentation(), form.getDecEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("January", form.getJanMolasisUsed(), form.getJanCo2ReleasedFermentation(), form.getJanEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("February", form.getFebMolasisUsed(), form.getFebCo2ReleasedFermentation(), form.getFebEthanolProduced(), loginId)));
        dischargeData.add(calculateAndConvert(form.toS1Discharge("March", form.getMarMolasisUsed(), form.getMarCo2ReleasedFermentation(), form.getMarEthanolProduced(), loginId)));

        // Calculate total yearly emissions
        double totalYearlyEmission = dischargeData.stream().mapToDouble(S1Discharge::getMonthlyEmission).sum();
        dischargeData.forEach(discharge -> discharge.setYearlyEmission(totalYearlyEmission));

        // Save all the data
        s1DischargeRepository.saveAll(dischargeData);
    }

    @Override
    @Transactional
    public void updateDischargeData(Long loginId, String year, S1DischargeForm form) {
        System.out.println("in update service");

        // Verify if any data exists for the given loginId and year
        List<S1Discharge> existingDischargeData = s1DischargeRepository.findByLogin_IdAndYear(loginId, year);
        
        if (existingDischargeData.isEmpty()) {
            throw new DataNotFoundException("No discharge data found for loginId " + loginId + " and year " + year);
        }

        // Update month array to match field names in the DTO
        String[] monthFieldNames = {"apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", "jan", "feb", "mar"};
        String[] actualMonthNames = {"April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March"};

        for (int i = 0; i < monthFieldNames.length; i++) {
            String monthField = monthFieldNames[i];
            String actualMonth = actualMonthNames[i];

            // Retrieve values from form using reflection with corrected field names
            Double molasisUsed = getFieldValue(form, monthField + "MolasisUsed");
            Double co2ReleasedFermentation = getFieldValue(form, monthField + "Co2ReleasedFermentation");
            Double ethanolProduced = getFieldValue(form, monthField + "EthanolProduced");
            String molasisUsedUOM = form.getMolasisUsedUOM();
            String co2ReleasedFermentationUOM = form.getCo2ReleasedFermentationUOM();
            String ethanolProducedUOM = form.getEthanolProducedUOM();

            // Update or create S1Discharge entity for the actual month
            S1Discharge discharge = s1DischargeRepository.findByLogin_IdAndYearAndMonth(loginId, year, actualMonth)
                .orElse(new S1Discharge(actualMonth, year, molasisUsed, molasisUsedUOM, co2ReleasedFermentation, co2ReleasedFermentationUOM, form.getPercentageOfSugarInMolasis(), ethanolProduced, ethanolProducedUOM, 0, new Login(loginId)));

            discharge.setMolasisUsed(molasisUsed);
            discharge.setCo2ReleasedFermentation(co2ReleasedFermentation);
            discharge.setEthanolProduced(ethanolProduced);
            discharge.setMolasisUsedUOM(molasisUsedUOM);
            discharge.setCo2ReleasedFermentationUOM(co2ReleasedFermentationUOM);
            discharge.setEthanolProducedUOM(ethanolProducedUOM);

            // Calculate and update monthly emission
            discharge = calculateAndConvert(discharge);
            s1DischargeRepository.save(discharge);
        }

        // Recalculate total yearly emissions after the update
        recalculateTotalYearlyEmission(loginId, year);
    }




    private Double getFieldValue(S1DischargeForm form, String fieldName) {
        try {
            Field field = form.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(form);
            if (value == null) {
                return null; // Handle null cases
            }
            return (Double) value;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Field '" + fieldName + "' not found in form", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Field '" + fieldName + "' is not accessible", e);
        } catch (ClassCastException e) {
            throw new RuntimeException("Field '" + fieldName + "' is not of type Double", e);
        }
    }



    private void recalculateTotalYearlyEmission(Long loginId, String year) {
        List<S1Discharge> updatedData = s1DischargeRepository.findByLogin_IdAndYear(loginId, year);
        double totalYearlyEmission = updatedData.stream().mapToDouble(S1Discharge::getMonthlyEmission).sum();
        updatedData.forEach(discharge -> discharge.setYearlyEmission(totalYearlyEmission));
        s1DischargeRepository.saveAll(updatedData);
    }




    private S1Discharge calculateAndConvert(S1Discharge discharge) {
        // Convert molasis to tonnes
        double molasisInTonnes = convertToTonnes(discharge.getMolasisUsed(), discharge.getMolasisUsedUOM());

        // Calculate monthly emissions
        double monthlyEmission = 0.514 * discharge.getPercentageOfSugarInMolasis() * molasisInTonnes;
        discharge.setMonthlyEmission(monthlyEmission);

        return discharge;
    }

    private double convertToTonnes(double amount, String uom) {
        switch (uom.toLowerCase()) {
            case "tonne":
                return amount;
            case "kg":
                return amount / 1000.0; // kg to tonnes
            case "litre":
                return (amount * 1600) / 1_000_000.0; // litres to tonnes (1600 kg/m^3)
            case "kilolitre":
                return (amount * 1600) / 1000.0; // kilolitres to tonnes (1600 kg/m^3)
            case "meter cube":
                return amount * 1.6; // cubic meters to tonnes (1600 kg/m^3)
            default:
            	throw new CustomException("Invalid UOM: " + uom);      
        }
    }
    
    @Override
    public List<S1Discharge> findDischargesByLoginIdAndYear(Long loginId, String year) {
        List<S1Discharge> discharges = s1DischargeRepository.findByLogin_IdAndYear(loginId, year);
        if (discharges.isEmpty()) {
            throw new DataNotFoundException("No discharge data found for loginId: " + loginId + " and year: " + year);
        }
        return discharges;
    }
}

