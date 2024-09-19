package com.tsl.controller;

import com.tsl.dto.S1ArcWeldingForm;
import com.tsl.pojo.S1ArcWelding;
import com.tsl.service.S1ArcWeldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/s1-arc-welding")
public class S1ArcWeldingController {

    @Autowired
    private S1ArcWeldingService service;

    @PostMapping("/save")
    public ResponseEntity<S1ArcWelding> saveOrUpdateS1ArcWelding(
            @RequestBody S1ArcWeldingForm form,
            @RequestParam Long loginId) {
        S1ArcWelding welding = service.saveOrUpdate(form, loginId);
        return ResponseEntity.ok(welding);
    }
    @GetMapping("/login/{loginId}")
    public ResponseEntity<List<S1ArcWelding>> getByLoginId(@PathVariable Long loginId) {
        List<S1ArcWelding> weldings = service.getAllByLoginId(loginId);
        return ResponseEntity.ok(weldings);
    }
    @PutMapping("/update")
    public ResponseEntity<List<S1ArcWelding>> updateS1ArcWeldingByLoginId(
            @RequestBody S1ArcWeldingForm form,
            @RequestParam Long loginId) {
        List<S1ArcWelding> updatedWeldings = service.updateS1ArcWeldingByLoginId(form, loginId);
        return ResponseEntity.ok(updatedWeldings);
    }
    @GetMapping("/find")
    public ResponseEntity<List<S1ArcWelding>> findByYearAndLoginId(
            @RequestParam String year,
            @RequestParam Long loginId) {
        List<S1ArcWelding> weldings = service.findByYearAndLoginId(year, loginId);
        return ResponseEntity.ok(weldings);
    }
}
