package com.tsl.controller;

import com.tsl.dto.S1SpentWashForm;
import com.tsl.pojo.S1SpentWash;
import com.tsl.service.S1SpentWashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/s1-spent-wash")
public class S1SpentWashController {

    @Autowired
    private S1SpentWashService s1SpentWashService;

    @PostMapping("/save/{loginId}")
    public ResponseEntity<List<S1SpentWash>> saveCoalUsedData(@PathVariable Long loginId, @RequestBody S1SpentWashForm form) {
        List<S1SpentWash> savedData = s1SpentWashService.saveOrUpdate(form, loginId);
        return ResponseEntity.ok(savedData);
    }

    @GetMapping("/by-login/{loginId}")
    public ResponseEntity<List<S1SpentWash>> getCoalUsedDataByLoginId(@PathVariable Long loginId) {
        List<S1SpentWash> spentWashData = s1SpentWashService.getByLoginId(loginId);
        return ResponseEntity.ok(spentWashData);
    }

    @GetMapping("/by-login/{loginId}/year/{year}")
    public ResponseEntity<List<S1SpentWash>> getCoalUsedDataByLoginIdAndYear(@PathVariable Long loginId, @PathVariable String year) {
        List<S1SpentWash> spentWashData = s1SpentWashService.getByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(spentWashData);
    }
}
