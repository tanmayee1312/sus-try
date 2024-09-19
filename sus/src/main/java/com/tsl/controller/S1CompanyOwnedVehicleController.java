package com.tsl.controller;

import com.tsl.form.S1CompanyOwnedVehicleForm;
import com.tsl.pojo.S1CompanyOwnedVehicle;
import com.tsl.service.S1CompanyOwnedVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-owned-vehicles")
public class S1CompanyOwnedVehicleController {

    @Autowired
    private S1CompanyOwnedVehicleService service;

    @PostMapping("/save")
    public ResponseEntity<List<S1CompanyOwnedVehicle>> saveOrUpdateCompanyOwnedVehicles(
            @RequestParam("loginId") Long loginId, 
            @RequestBody S1CompanyOwnedVehicleForm form) {
        // Pass the loginId to the service method
        form.setLoginId(loginId);
        List<S1CompanyOwnedVehicle> savedData = service.saveOrUpdateCompanyOwnedVehicles(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }
    
    @GetMapping("/get-by-login-id-and-year")
    public ResponseEntity<List<S1CompanyOwnedVehicle>> getCompanyOwnedVehiclesByLoginIdAndYear(
            @RequestParam("loginId") Long loginId,
            @RequestParam("year") String year) {
        List<S1CompanyOwnedVehicle> vehicles = service.getCompanyOwnedVehiclesByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(vehicles);
    }
}
