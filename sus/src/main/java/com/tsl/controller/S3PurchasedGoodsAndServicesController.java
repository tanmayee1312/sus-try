package com.tsl.controller;

import com.tsl.pojo.S3PurchasedGoodsAndServices;
import com.tsl.form.S3PurchasedGoodsAndServicesForm;
import com.tsl.service.S3PurchasedGoodsAndServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/s3-purchased-goods-services")
public class S3PurchasedGoodsAndServicesController {

    @Autowired
    private S3PurchasedGoodsAndServicesService service;

    @PostMapping("/save")
    public ResponseEntity<Void> saveS3PurchasedGoodsAndServices(
            @RequestParam Long loginId,
            @RequestBody S3PurchasedGoodsAndServicesForm form) {
        form.setLoginId(loginId);
        service.saveS3PurchasedGoodsAndServices(form);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/by-login/{loginId}")
    public ResponseEntity<List<S3PurchasedGoodsAndServices>> getS3PurchasedGoodsAndServicesByLoginId(
            @PathVariable Long loginId) {
        List<S3PurchasedGoodsAndServices> result = service.getS3PurchasedGoodsAndServicesByLoginId(loginId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/by-login/{loginId}/year/{year}")
    public ResponseEntity<List<S3PurchasedGoodsAndServices>> getS3PurchasedGoodsAndServicesByLoginIdAndYear(
            @PathVariable Long loginId,
            @PathVariable String year) {
        List<S3PurchasedGoodsAndServices> result = service.getS3PurchasedGoodsAndServicesByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(result);
    }
}
