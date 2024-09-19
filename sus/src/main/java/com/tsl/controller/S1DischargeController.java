package com.tsl.controller;

import com.tsl.dto.S1DischargeForm;
import com.tsl.exception.CustomException;
import com.tsl.exception.DataAlreadyExistsException;
import com.tsl.exception.DataNotFoundException;
import com.tsl.pojo.S1Discharge;
import com.tsl.service.S1DischargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
@CrossOrigin("*")
@RestController
@RequestMapping("/api/s1-discharge")
public class S1DischargeController {

    @Autowired
    private S1DischargeService s1DischargeService;

    @GetMapping("/get/{loginId}")
    public ResponseEntity<List<S1Discharge>> getDischargeData(@PathVariable Long loginId) {
        List<S1Discharge> dischargeData = s1DischargeService.getAllDischargeDataByLoginId(loginId);
        return ResponseEntity.ok(dischargeData);
    }

    @PostMapping("/save/{loginId}")
    public ResponseEntity<String> saveOrUpdateDischargeData(@RequestBody S1DischargeForm s1DischargeForm, @PathVariable Long loginId) {
        s1DischargeService.saveOrUpdateDischargeData(s1DischargeForm, loginId);
        return ResponseEntity.ok("Discharge data saved successfully!");
    }
//    @GetMapping("/by-login/{loginId}/year/{year}")
//    public ResponseEntity<List<S1Discharge>> getDischargeDataByLoginIdAndYear(@PathVariable Long loginId, @PathVariable String year) {
//        List<S1Discharge> dischargeData = s1DischargeService.getDischargeDataByLoginIdAndYear(loginId, year);
//        return ResponseEntity.ok(dischargeData);
//    }
//    
    @GetMapping("/by-login")
    public ResponseEntity<List<S1Discharge>> getDischargeDataByLoginIdAndYear(@RequestParam Long loginId, @RequestParam String year) {
        List<S1Discharge> dischargeData = s1DischargeService.getDischargeDataByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(dischargeData);
    }
    
    @PutMapping("/update/by-login/{loginId}/year/{year}")
    public ResponseEntity<String> updateDischargeDataByLoginIdAndYear(
            @PathVariable Long loginId,
            @PathVariable String year,
            @RequestBody S1DischargeForm s1DischargeForm) {
        try {
            s1DischargeService.updateDischargeDataByLoginIdAndYear(s1DischargeForm, loginId, year);
            return ResponseEntity.ok("Data updated successfully.");
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating data.");
        }
    }

}
*/


@RestController
@RequestMapping("/api/s1-discharge")
public class S1DischargeController {

    @Autowired
    private S1DischargeService s1DischargeService;

    @PostMapping("/save")
    public ResponseEntity<String> saveDischargeData(@RequestBody S1DischargeForm form) {
        try {
            s1DischargeService.saveDischargeData(form);
            return new ResponseEntity<>("Discharge data saved successfully", HttpStatus.OK);
        } catch (DataAlreadyExistsException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.CONFLICT);
        } catch (CustomException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving discharge data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{loginId}/{year}")
    public ResponseEntity<String> updateDischargeData(@PathVariable Long loginId, @PathVariable String year, @RequestBody S1DischargeForm form) {
        try {
            System.out.println("in update controller " + form.getMolasisUsedUOM());
            s1DischargeService.updateDischargeData(loginId, year, form);
            return new ResponseEntity<>("Discharge data updated successfully", HttpStatus.OK);
        } catch (DataNotFoundException e) {
            // Handle the case where no data is found
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle other exceptions
            return new ResponseEntity<>("Error updating discharge data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{loginId}/{year}")
    public ResponseEntity<List<S1Discharge>> getDischargeData(@PathVariable Long loginId, @PathVariable String year) {
        try {
            List<S1Discharge> discharges = s1DischargeService.findDischargesByLoginIdAndYear(loginId, year);
            return new ResponseEntity<>(discharges, HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // No body needed, just status
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // No body needed, just status
        }
    }
}
