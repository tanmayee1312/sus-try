package com.tsl.controller;

import com.tsl.form.BusinessTravelHotelStayForm;
import com.tsl.pojo.BusinessTravelHotelStay;
import com.tsl.service.BusinessTravelHotelStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/business-travel-hotel-stay")
public class BusinessTravelHotelStayController {

    @Autowired
    private BusinessTravelHotelStayService service;

    // Save BusinessTravelHotelStay data
    @PostMapping("/save")
    public ResponseEntity<String> saveBusinessTravelHotelStays(
            @RequestParam Long loginId, 
            @RequestBody BusinessTravelHotelStayForm form) {
        
        // Set the loginId in the form object
        form.setLoginId(loginId);
        
        // Call the service method to save the data
        service.saveBusinessTravelHotelStays(form);
        
        return ResponseEntity.ok("Business Travel Hotel Stay data saved successfully.");
    }


    // Get BusinessTravelHotelStay data by loginId
    @GetMapping("/get-by-login-id")
    public ResponseEntity<List<BusinessTravelHotelStay>> getBusinessTravelHotelStaysByLoginId(
            @RequestParam Long loginId) {
        List<BusinessTravelHotelStay> stays = service.getBusinessTravelHotelStaysByLoginId(loginId);
        return ResponseEntity.ok(stays);
    }

    // Get BusinessTravelHotelStay data by loginId and year
    @GetMapping("/get-by-login-id-and-year")
    public ResponseEntity<List<BusinessTravelHotelStay>> getBusinessTravelHotelStaysByLoginIdAndYear(
            @RequestParam Long loginId, @RequestParam String year) {
        List<BusinessTravelHotelStay> stays = service.getBusinessTravelHotelStaysByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(stays);
    }
}
