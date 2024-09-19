package com.tsl.controller;

import com.tsl.form.BusinessTravelAirForm;
import com.tsl.pojo.BusinessTravelAir;
import com.tsl.service.BusinessTravelAirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business-travel-air")
public class BusinessTravelAirController {

    @Autowired
    private BusinessTravelAirService businessTravelAirService;

    @PostMapping("/save/{loginId}")
    public ResponseEntity<Void> saveBusinessTravelAir(@PathVariable Long loginId, @RequestBody BusinessTravelAirForm form) {
        form.setLoginId(loginId);
        businessTravelAirService.saveBusinessTravelAir(form);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-login/{loginId}")
    public ResponseEntity<List<BusinessTravelAir>> getBusinessTravelAirByLoginId(@PathVariable Long loginId) {
        List<BusinessTravelAir> result = businessTravelAirService.getBusinessTravelAirByLoginId(loginId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/by-login/{loginId}/year/{year}")
    public ResponseEntity<List<BusinessTravelAir>> getBusinessTravelAirByLoginIdAndYear(@PathVariable Long loginId, @PathVariable String year) {
        List<BusinessTravelAir> result = businessTravelAirService.getBusinessTravelAirByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(result);
    }
}
