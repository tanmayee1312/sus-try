package com.tsl.controller;

import com.tsl.form.BusinessTravelRailForm;
import com.tsl.pojo.BusinessTravelRail;
import com.tsl.service.BusinessTravelRailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/business-travel-rail")
public class BusinessTravelRailController {

    @Autowired
    private BusinessTravelRailService businessTravelRailService;

    @PostMapping("/save/{loginId}")
    public ResponseEntity<String> saveBusinessTravelRail(@PathVariable Long loginId, @RequestBody BusinessTravelRailForm form) {
        try {
            form.setLoginId(loginId); // Ensure the loginId is set in the form
            businessTravelRailService.saveBusinessTravelRail(form);
            return ResponseEntity.ok("Business travel rail data saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving business travel rail data: " + e.getMessage());
        }
    }

    @GetMapping("/by-login/{loginId}")
    public ResponseEntity<List<BusinessTravelRail>> getBusinessTravelRailByLoginId(@PathVariable Long loginId) {
        try {
            List<BusinessTravelRail> data = businessTravelRailService.getBusinessTravelRailByLoginId(loginId);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/by-login/{loginId}/year/{year}")
    public ResponseEntity<List<BusinessTravelRail>> getBusinessTravelRailByLoginIdAndYear(
            @PathVariable Long loginId, @PathVariable String year) {
        try {
            List<BusinessTravelRail> data = businessTravelRailService.getBusinessTravelRailByLoginIdAndYear(loginId, year);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
