package com.tsl.BRSR.controller;

import com.tsl.BRSR.dto.GeneralDiscloserRequest;
import com.tsl.pojo.GeneralDiscloser;
import com.tsl.BRSR.service.GeneralDiscloserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/general-discloser")
public class GeneralDiscloserController {

    @Autowired
    private GeneralDiscloserService generalDiscloserService;

    // Save new GeneralDiscloser entries (POST)
    @PostMapping("/save/{userId}")
    public ResponseEntity<List<GeneralDiscloser>> saveGeneralDisclosers(
            @PathVariable Long userId,
            @RequestBody List<GeneralDiscloserRequest> generalDiscloserRequestList) {

        List<GeneralDiscloser> savedGeneralDisclosers = generalDiscloserService.saveAll(userId, generalDiscloserRequestList);
        return new ResponseEntity<>(savedGeneralDisclosers, HttpStatus.CREATED);
    }

    // Update existing GeneralDiscloser entries (PUT)
    @PutMapping("/update/{userId}")
    public ResponseEntity<List<GeneralDiscloser>> updateGeneralDisclosers(
            @PathVariable Long userId,
            @RequestBody List<GeneralDiscloserRequest> generalDiscloserRequestList) {

        List<GeneralDiscloser> updatedGeneralDisclosers = generalDiscloserService.updateGeneralDisclosers(userId, generalDiscloserRequestList);
        return new ResponseEntity<>(updatedGeneralDisclosers, HttpStatus.OK);
    }

    // Get GeneralDiscloser by userId and year
    @GetMapping("/user/{userId}/year/{year}")
    public ResponseEntity<List<GeneralDiscloser>> getGeneralDisclosersByUserIdAndYear(
            @PathVariable Long userId,
            @PathVariable String year) {

        List<GeneralDiscloser> generalDisclosers = generalDiscloserService.getGeneralDisclosersByUserIdAndYear(userId, year);
        return new ResponseEntity<>(generalDisclosers, HttpStatus.OK);
    }

    // Get GeneralDiscloser by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GeneralDiscloser>> getGeneralDisclosersByUserId(
            @PathVariable Long userId) {

        List<GeneralDiscloser> generalDisclosers = generalDiscloserService.getGeneralDisclosersByUserId(userId);
        return new ResponseEntity<>(generalDisclosers, HttpStatus.OK);
    }

    // Get all GeneralDiscloser entries
    @GetMapping
    public ResponseEntity<List<GeneralDiscloser>> getAllGeneralDisclosers() {
        List<GeneralDiscloser> generalDisclosers = generalDiscloserService.getAllGeneralDisclosers();
        return new ResponseEntity<>(generalDisclosers, HttpStatus.OK);
    }

    // Get GeneralDiscloser by id
    @GetMapping("/{id}")
    public ResponseEntity<GeneralDiscloser> getGeneralDiscloserById(
            @PathVariable Long id) {

        GeneralDiscloser generalDiscloser = generalDiscloserService.getGeneralDiscloserById(id);
        return new ResponseEntity<>(generalDiscloser, HttpStatus.OK);
    }
}
