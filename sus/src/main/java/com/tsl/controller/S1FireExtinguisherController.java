package com.tsl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tsl.form.S1FireExtinguisherForm;
import com.tsl.pojo.S1FireExtinguisher;
import com.tsl.service.S1FireExtinguisherService;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/s1-fire-extinguisher")
@RequiredArgsConstructor
public class S1FireExtinguisherController {

    private final S1FireExtinguisherService service;

    @PostMapping("/save/{loginId}")
    public ResponseEntity<List<S1FireExtinguisher>> saveOrUpdate(
            @PathVariable Long loginId,
            @RequestBody S1FireExtinguisherForm form) {
        form.setLoginId(loginId);
        List<S1FireExtinguisher> savedExtinguishers = service.saveAll(form);
        return ResponseEntity.ok(savedExtinguishers);
    }
    
    @GetMapping("/get/{loginId}")
    public ResponseEntity<List<S1FireExtinguisher>> getByLoginId(@PathVariable Long loginId) {
        List<S1FireExtinguisher> extinguishers = service.getByLoginId(loginId);
        return ResponseEntity.ok(extinguishers);
    }
    
    @GetMapping("/{loginId}/{year}")
    public List<S1FireExtinguisher> getFireExtinguishersByLoginIdAndYear(
            @PathVariable Long loginId,
            @PathVariable String year) {
        return service.findByLoginIdAndYear(loginId, year);
    }
}
