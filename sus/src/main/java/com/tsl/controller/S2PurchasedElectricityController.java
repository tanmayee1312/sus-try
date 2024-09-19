//package com.tsl.controller;
//
//import com.tsl.pojo.S2PurchasedElectricity;
//import com.tsl.dto.S2PurchasedElectricityForm;
//import com.tsl.service.S2PurchasedElectricityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/s2-purchased-electricity")
//public class S2PurchasedElectricityController {
//
//    @Autowired
//    private S2PurchasedElectricityService service;
//
//    @PostMapping("/save")
//    public ResponseEntity<List<S2PurchasedElectricity>> saveOrUpdate(@RequestBody S2PurchasedElectricityForm form) {
//        List<S2PurchasedElectricity> savedData = service.saveOrUpdate(form);
//        return ResponseEntity.ok(savedData);
//    }
//
//    @GetMapping("/by-login/{loginId}")
//    public ResponseEntity<List<S2PurchasedElectricity>> getByLoginId(@PathVariable Long loginId) {
//        List<S2PurchasedElectricity> data = service.getByLoginId(loginId);
//        return ResponseEntity.ok(data);
//    }
//
//    @GetMapping("/by-login/{loginId}/year/{year}")
//    public ResponseEntity<List<S2PurchasedElectricity>> getByLoginIdAndYear(@PathVariable Long loginId, @PathVariable String year) {
//        List<S2PurchasedElectricity> data = service.getByLoginIdAndYear(loginId, year);
//        return ResponseEntity.ok(data);
//    }
//}

//---------------------------------only for posting -------------------------------
/*
package com.tsl.controller;

import com.tsl.dto.S2PurchasedElectricityForm;
import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.service.S2PurchasedElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/s2-purchased-electricity")
public class S2PurchasedElectricityController {

    @Autowired
    private S2PurchasedElectricityService service;

    @PostMapping("/save/{loginId}")
    public ResponseEntity<String> saveS2PurchasedElectricity(@PathVariable Long loginId, @RequestBody S2PurchasedElectricityForm form) {
        form.setUserId(loginId);
        service.saveS2PurchasedElectricity(form);
        return ResponseEntity.ok("S2 Purchased Electricity data saved successfully.");
    }


    @GetMapping("/get/{loginId}/{year}")
    public ResponseEntity<List<S2PurchasedElectricity>> getS2PurchasedElectricityByLoginIdAndYear(@PathVariable Long loginId, @PathVariable String year) {
        List<S2PurchasedElectricity> records = service.getS2PurchasedElectricityByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(records);
    }
}
*/


//-------------------------done calculations---------------
package com.tsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsl.dto.S2PurchasedElectricityForm;
import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.service.S2PurchasedElectricityService;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/s2-purchased-electricity")
public class S2PurchasedElectricityController {

    @Autowired
    private S2PurchasedElectricityService s2PurchasedElectricityService;

    @PostMapping("/save")
    public ResponseEntity<String> saveS2PurchasedElectricity(@RequestBody S2PurchasedElectricityForm form) {
        try {
            s2PurchasedElectricityService.saveS2PurchasedElectricity(form);
            return ResponseEntity.status(HttpStatus.CREATED).body("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while saving data");
        }
    }

    @GetMapping("/get/{loginId}/{year}")
    public ResponseEntity<List<S2PurchasedElectricity>> getS2PurchasedElectricityByLoginIdAndYear(
            @PathVariable Long loginId, @PathVariable String year) {
        try {
            List<S2PurchasedElectricity> records = s2PurchasedElectricityService.getS2PurchasedElectricityByLoginIdAndYear(loginId, year);
            if (records.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(records);
            }
            return ResponseEntity.ok(records);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
