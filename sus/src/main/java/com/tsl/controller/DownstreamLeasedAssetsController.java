package com.tsl.controller;

import com.tsl.pojo.DownstreamLeasedAssets;
import com.tsl.dto.DownstreamLeasedAssetsForm;
import com.tsl.service.DownstreamLeasedAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/downstream-leased-assets")
public class DownstreamLeasedAssetsController {

    @Autowired
    private DownstreamLeasedAssetsService service;

    // Updated endpoint to use RequestParam for loginId and year
    @GetMapping("/by-login")
    public ResponseEntity<List<DownstreamLeasedAssets>> getAssetsByLoginIdAndYear(
            @RequestParam Long loginId,
            @RequestParam String year) {
        List<DownstreamLeasedAssets> assets = service.getAssetsByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(assets);
    }

    @PostMapping("/save/{loginId}")
    public ResponseEntity<String> saveOrUpdateAssets(
            @PathVariable Long loginId,
            @RequestBody DownstreamLeasedAssetsForm form) {
        service.saveOrUpdateAssets(form, loginId);
        return ResponseEntity.ok("Assets saved/updated successfully.");
    }
}
