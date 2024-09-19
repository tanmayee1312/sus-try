package com.tsl.controller;

import com.tsl.pojo.EmployeeCommute;
import com.tsl.form.EmployeeCommuteForm;
import com.tsl.service.EmployeeCommuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee-commute")
public class EmployeeCommuteController {

    @Autowired
    private EmployeeCommuteService service;

    @PostMapping("/save")
    public ResponseEntity<List<EmployeeCommute>> saveOrUpdateEmployeeCommutes(
            @RequestParam Long loginId, @RequestBody EmployeeCommuteForm form) {
        
        form.setLoginId(loginId);
        
        List<EmployeeCommute> savedData = service.saveOrUpdateEmployeeCommutes(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeCommute>> getEmployeeCommutesByLoginId(
            @RequestParam Long loginId) {
        List<EmployeeCommute> data = service.getEmployeeCommutesByLoginId(loginId);
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<List<EmployeeCommute>> getEmployeeCommutesByLoginIdAndYear(
            @RequestParam Long loginId,
            @RequestParam String year) {
        List<EmployeeCommute> data = service.getEmployeeCommutesByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(data);
    }
}
