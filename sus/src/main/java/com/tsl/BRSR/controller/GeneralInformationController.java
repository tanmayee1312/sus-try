package com.tsl.BRSR.controller;

import com.tsl.BRSR.dto.GeneralInformationDTO;
import com.tsl.BRSR.service.GeneralInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/general-information")
public class GeneralInformationController {

    @Autowired
    private GeneralInformationService service;

    // Create new GeneralInformation entries (POST)
    @PostMapping("/create")
    public ResponseEntity<List<GeneralInformationDTO>> createGeneralInformation(@RequestBody List<GeneralInformationDTO> generalInformationDTOList) {
        List<GeneralInformationDTO> createdInfoList = service.createGeneralInformation(generalInformationDTOList);
        return ResponseEntity.ok(createdInfoList);
    }

    // Update existing GeneralInformation entries (PUT)
    @PutMapping("/update/{userId}")
    public ResponseEntity<List<GeneralInformationDTO>> updateGeneralInformation(
            @PathVariable Long userId,
            @RequestBody List<GeneralInformationDTO> generalInformationDTOList) {
        List<GeneralInformationDTO> updatedInfoList = service.updateGeneralInformation(userId, generalInformationDTOList);
        return ResponseEntity.ok(updatedInfoList);
    }

    // Get GeneralInformation by userId and year (GET)
    @GetMapping("/user/{userId}/year/{year}")
    public ResponseEntity<List<GeneralInformationDTO>> getGeneralInformationByUserIdAndYear(
            @PathVariable Long userId,
            @PathVariable String year) {
        List<GeneralInformationDTO> generalInfoList = service.getGeneralInformationByUserIdAndYear(userId, year);
        return ResponseEntity.ok(generalInfoList);
    }

    // Get GeneralInformation by userId (GET)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GeneralInformationDTO>> getGeneralInformationByUserId(
            @PathVariable Long userId) {
        List<GeneralInformationDTO> generalInfoList = service.getGeneralInformationByUserId(userId);
        return ResponseEntity.ok(generalInfoList);
    }

    // Get GeneralInformation by id and userId (GET)
    @GetMapping("/id/{id}/user/{userId}")
    public ResponseEntity<GeneralInformationDTO> getGeneralInformationByIdAndUserId(
            @PathVariable Long id,
            @PathVariable Long userId) {
        GeneralInformationDTO generalInfo = service.getGeneralInformationByIdAndUserId(id, userId);
        return ResponseEntity.ok(generalInfo);
    }

    // Get all GeneralInformation entries (GET)
    @GetMapping
    public ResponseEntity<List<GeneralInformationDTO>> getAllGeneralInformation() {
        List<GeneralInformationDTO> generalInfoList = service.getAllGeneralInformation();
        return ResponseEntity.ok(generalInfoList);
    }

    // Get GeneralInformation by id (GET)
    @GetMapping("/{id}")
    public ResponseEntity<GeneralInformationDTO> getGeneralInformationById(
            @PathVariable Long id) {
        GeneralInformationDTO generalInfo = service.getGeneralInformationById(id);
        return ResponseEntity.ok(generalInfo);
    }
}
