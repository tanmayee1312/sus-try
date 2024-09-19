package com.tsl.BRSR.controller;

import com.tsl.BRSR.dto.BusinessActivityDTO;
import com.tsl.BRSR.service.BusinessActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business-activity")
public class BusinessActivityController {

    @Autowired
    private BusinessActivityService businessActivityService;

    @PostMapping("/create")
    public ResponseEntity<List<BusinessActivityDTO>> createBusinessActivities(@RequestBody List<BusinessActivityDTO> businessActivityDTOList) {
        List<BusinessActivityDTO> createdActivities = businessActivityService.createBusinessActivities(businessActivityDTOList);
        return ResponseEntity.ok(createdActivities);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BusinessActivityDTO>> getBusinessActivitiesByUserId(@PathVariable Long userId) {
        List<BusinessActivityDTO> businessActivities = businessActivityService.getBusinessActivitiesByUserId(userId);
        return ResponseEntity.ok(businessActivities);
    }

    @GetMapping("/user/{userId}/year/{year}")
    public ResponseEntity<List<BusinessActivityDTO>> getBusinessActivitiesByUserIdAndYear(@PathVariable Long userId, @PathVariable String year) {
        List<BusinessActivityDTO> businessActivities = businessActivityService.getBusinessActivitiesByUserIdAndYear(userId, year);
        return ResponseEntity.ok(businessActivities);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessActivityDTO> updateBusinessActivity(@PathVariable Long id, @RequestParam Long userId, @RequestBody BusinessActivityDTO businessActivityDTO) {
        BusinessActivityDTO updatedActivity = businessActivityService.updateBusinessActivity(id, userId, businessActivityDTO);
        return ResponseEntity.ok(updatedActivity);
    }

    @GetMapping("/{id}/user/{userId}")
    public ResponseEntity<BusinessActivityDTO> getBusinessActivityByIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
        BusinessActivityDTO businessActivity = businessActivityService.getBusinessActivityByIdAndUserId(id, userId);
        return ResponseEntity.ok(businessActivity);
    }
}
