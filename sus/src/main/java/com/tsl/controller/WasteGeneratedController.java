package com.tsl.controller;

import com.tsl.pojo.WasteGenerated;
import com.tsl.form.WasteGeneratedForm;
import com.tsl.service.WasteGeneratedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/waste-generated")
public class WasteGeneratedController {

    @Autowired
    private WasteGeneratedService wasteGeneratedService;

    // POST endpoint to save WasteGenerated data with loginId in path variable
    @PostMapping("/save/{loginId}")
    public ResponseEntity<Void> saveWasteGenerated(
            @PathVariable Long loginId,
            @RequestBody WasteGeneratedForm form) {
        form.setLoginId(loginId); // Ensure the loginId is set in the form
        wasteGeneratedService.saveWasteGenerated(form);
        return ResponseEntity.ok().build();
    }

    // GET endpoint to retrieve WasteGenerated data by loginId
    @GetMapping("/by-login/{loginId}")
    public ResponseEntity<List<WasteGenerated>> getWasteGeneratedByLoginId(@PathVariable Long loginId) {
        List<WasteGenerated> wasteGeneratedList = wasteGeneratedService.getWasteGeneratedByLoginId(loginId);
        return ResponseEntity.ok(wasteGeneratedList);
    }

    // GET endpoint to retrieve WasteGenerated data by loginId and year
    @GetMapping("/by-login/{loginId}/year/{year}")
    public ResponseEntity<List<WasteGenerated>> getWasteGeneratedByLoginIdAndYear(
            @PathVariable Long loginId,
            @PathVariable String year) {
        List<WasteGenerated> wasteGeneratedList = wasteGeneratedService.getWasteGeneratedByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(wasteGeneratedList);
    }
}
