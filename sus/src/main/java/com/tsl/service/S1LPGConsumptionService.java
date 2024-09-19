package com.tsl.service;

import com.tsl.pojo.S1LPGConsumption;
import com.tsl.dto.S1LPGConsumptionForm;

import java.util.List;

/*
public interface S1LPGConsumptionService {
    List<S1LPGConsumption> createOrUpdateS1CompanyOwnedVehicles(S1LPGConsumptionForm form, Long loginId);
    List<S1LPGConsumption> getAllS1CompanyOwnedVehicles(Long loginId);
    List<S1LPGConsumption> getS1CompanyOwnedVehiclesByYear(Long loginId, String year);
}
*/

import java.util.List;

public interface S1LPGConsumptionService {

    // Save a single LPG consumption entry
    S1LPGConsumption saveLPGConsumption(S1LPGConsumption lpgConsumption);

    

    // Retrieve all consumption data for a given year and loginId
    List<S1LPGConsumption> getLPGConsumptionByYearAndLoginId(Long loginId, String year);


}
