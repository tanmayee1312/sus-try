package com.tsl.controller;

import com.tsl.pojo.S1LPGConsumption;
import com.tsl.dto.S1LPGConsumptionForm;
import com.tsl.service.S1LPGConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
@CrossOrigin("*")
@RestController
@RequestMapping("/api/s1-LPG-consumption")
public class S1LPGConsumptionController {

    @Autowired
    private S1LPGConsumptionService service;

    @PostMapping("/save")
    public ResponseEntity<List<S1LPGConsumption>> saveOrUpdateS1CompanyOwnedVehicles(
            @RequestBody S1LPGConsumptionForm form,
            @RequestParam Long loginId) {
        List<S1LPGConsumption> savedData = service.createOrUpdateS1CompanyOwnedVehicles(form, loginId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }

    @GetMapping("/list")
    public ResponseEntity<List<S1LPGConsumption>> getAllS1CompanyOwnedVehicles(
            @RequestParam Long loginId) {
        List<S1LPGConsumption> data = service.getAllS1CompanyOwnedVehicles(loginId);
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/fetch")
    public List<S1LPGConsumption> getS1CompanyOwnedVehiclesByYear(
            @RequestParam Long loginId,
            @RequestParam String year) {
        return service.getS1CompanyOwnedVehiclesByYear(loginId, year);
    }
}
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/s1-lpg-consumption")
public class S1LPGConsumptionController {

    @Autowired
    private S1LPGConsumptionService s1LPGConsumptionService;

    // Save LPG consumption data
    @PostMapping("/save")
    public ResponseEntity<String> saveLPGConsumption(@RequestBody S1LPGConsumptionForm lpgConsumptionForm) {
        List<S1LPGConsumption> lpgConsumptionList = lpgConsumptionForm.toS1LPGConsumptionList();
        for (S1LPGConsumption lpgConsumption : lpgConsumptionList) {
            s1LPGConsumptionService.saveLPGConsumption(lpgConsumption);
        }
        return ResponseEntity.ok("LPG consumption data saved successfully.");
    }

    // Endpoint to get LPG consumption data by year and login ID
    @GetMapping("/by-year-and-login")
    public ResponseEntity<List<S1LPGConsumption>> getLPGConsumptionByYearAndLoginId(
            @RequestParam("loginId") Long loginId,
            @RequestParam("year") String year) {
        List<S1LPGConsumption> consumptionList = s1LPGConsumptionService.getLPGConsumptionByYearAndLoginId(loginId, year);
        if (consumptionList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(consumptionList);
        }
    }
}
