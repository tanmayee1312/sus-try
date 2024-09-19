package com.tsl.controller;

import com.tsl.form.BusinessTravelRoadForm;
import com.tsl.pojo.BusinessTravelRoad;
import com.tsl.service.BusinessTravelRoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/business-travel-road")
public class BusinessTravelRoadController {

    @Autowired
    private BusinessTravelRoadService businessTravelRoadService;


    @PostMapping("/save/{loginId}")
    public ResponseEntity<String> saveBusinessTravelRoad(@PathVariable Long loginId, @RequestBody BusinessTravelRoadForm form) {
        form.setLoginId(loginId); // Set the loginId in the form
        businessTravelRoadService.saveBusinessTravelRoad(form);
        return ResponseEntity.ok("Business Travel Road data saved successfully.");
    }


    @GetMapping("/get-by-login/{loginId}")
    public ResponseEntity<List<BusinessTravelRoad>> getBusinessTravelRoadByLoginId(@PathVariable Long loginId) {
        List<BusinessTravelRoad> businessTravelRoadList = businessTravelRoadService.getBusinessTravelRoadByLoginId(loginId);
        return ResponseEntity.ok(businessTravelRoadList);
    }


    @GetMapping("/get-by-login-and-year/{loginId}/{year}")
    public ResponseEntity<List<BusinessTravelRoad>> getBusinessTravelRoadByLoginIdAndYear(@PathVariable Long loginId, @PathVariable String year) {
        List<BusinessTravelRoad> businessTravelRoadList = businessTravelRoadService.getBusinessTravelRoadByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(businessTravelRoadList);
    }
}
