package com.tsl.controller;

import com.tsl.service.PdfGenerationServicePart2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class PdfGenerationController {

    @Autowired
    private PdfGenerationServicePart2 pdfGenerationService;

    
    @GetMapping("/api/pdf/generate")
    public HttpEntity<InputStreamResource> generatePdf(
            @RequestParam Long loginId,
            @RequestParam String year) {

        ByteArrayInputStream bis;
        try {
            bis = pdfGenerationService.generateCombinedPdf(loginId, year);
        } catch (IOException e) {
            // Handle exception and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Final Report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

//    @GetMapping("/api/pdf/generate")
//    public HttpEntity<InputStreamResource> generatePdf(
//            @RequestParam Long loginId,
//            @RequestParam String year) {
//
//        ByteArrayInputStream bis;
//        try {
//            bis = pdfGenerationService.generateCombinedPdf(loginId, year);
//        } catch (IOException e) {
//            // Handle exception and return an error response
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "attachment; filename=final_report.pdf");
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(bis));
//    }
}
