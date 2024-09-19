package com.tsl.controller;

import com.tsl.dto.S1AcetyleneForm;
import com.tsl.exception.CustomException;
import com.tsl.exception.DataAlreadyExistsException;
import com.tsl.pojo.S1Acetylene;
import com.tsl.service.S1AcetyleneService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/s1-acetylene")
public class S1AcetyleneController {

    @Autowired
    private S1AcetyleneService s1AcetyleneService;

    @PostMapping("/save")
    public ResponseEntity<String> saveS1Acetylene(@RequestBody S1AcetyleneForm form) {
        try {
            s1AcetyleneService.saveOrUpdateS1Acetylene(form);
            return ResponseEntity.ok("Data saved successfully");
        } catch (DataAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (CustomException e) {
            // Return a response with bad request status and error messages
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

    
//    @PostMapping("/save")
//    public ResponseEntity<?> saveS1Acetylene(@RequestBody S1AcetyleneForm form) {
//        try {
//            s1AcetyleneService.saveS1Acetylene(form);
//            return ResponseEntity.ok("Data saved successfully");
//        } catch (DataAlreadyExistsException e) {
//            // Return a response with conflict status and error message
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        } catch (CustomException e) {
//            // Return a response with bad request status and error messages
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            // Handle other exceptions
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
//        }
//    }
    @GetMapping("/get/{loginId}/{year}")
    public ResponseEntity<List<S1Acetylene>> getS1Acetylene(@PathVariable Long loginId, @PathVariable String year) {
        List<S1Acetylene> records = s1AcetyleneService.getS1AcetyleneByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(records);
    }

//    @PutMapping("/update/{loginId}/{year}")
//    public ResponseEntity<String> updateS1Acetylene(@PathVariable Long loginId, @PathVariable String year, @RequestBody S1AcetyleneForm form) {
//        try {
//            s1AcetyleneService.updateS1Acetylene(form, loginId, year);
//            return ResponseEntity.ok("Data updated successfully");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
//        }
//    }
    @PutMapping("/update/{loginId}/{year}")
    public ResponseEntity<String> updateS1Acetylene(@PathVariable Long loginId, @PathVariable String year, @RequestBody S1AcetyleneForm form) {
        try {
            s1AcetyleneService.updateS1Acetylene(form, loginId, year);
            return ResponseEntity.ok("Data updated successfully");
        } catch (CustomException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
