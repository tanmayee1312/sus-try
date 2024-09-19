package com.tsl.controller;

import com.tsl.dto.S1CoalUsedForm;
import com.tsl.pojo.S1CoalUsed;
import com.tsl.service.S1CoalUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/s1-coal-used")
public class S1CoalUsedController {

    @Autowired
    private S1CoalUsedService s1CoalUsedService;

    @PostMapping("/save/{loginId}")
    public ResponseEntity<List<S1CoalUsed>> saveCoalUsedData(
            @PathVariable Long loginId, 
            @RequestBody S1CoalUsedForm form) {
        
        // Set the loginId in the form
        form.setUserId(loginId);
        
        // Save or update the data
        List<S1CoalUsed> savedData = s1CoalUsedService.saveOrUpdate(form);
        
        // Return the saved data as the response
        return ResponseEntity.ok(savedData);
    }


    @GetMapping("/get/{loginId}/{year}")
    public ResponseEntity<List<S1CoalUsed>> getCoalUsedData(@PathVariable Long loginId, @PathVariable String year) {
        List<S1CoalUsed> dataList = s1CoalUsedService.getCoalUsedByLoginIdAndYear(loginId, year);
        return ResponseEntity.ok(dataList);
    }
}
//@RestController
//@RequestMapping("/api/s1-coal-used")
//public class S1CoalUsedController {
//
//    @Autowired
//    private S1CoalUsedService s1CoalUsedService;
//
//    @PostMapping("/save/{loginId}")
//    public ResponseEntity<List<S1CoalUsed>> saveCoalUsedData(
//            @PathVariable Long loginId, 
//            @RequestBody S1CoalUsedForm form) {
//        
//        // Set the loginId in the form
//        form.setUserId(loginId);
//
//        // Get the financial year and calculate the month-year mappings
//        String financialYear = form.getYear();
//        Map<String, String> monthYearMapping = generateMonthYearMappings(financialYear);
//
//        // Update the form fields with the month-year mappings
//        S1CoalUsedForm updatedForm = updateFormWithMonthYear(form, monthYearMapping);
//
//        // Save or update the data
//        List<S1CoalUsed> savedData = s1CoalUsedService.saveOrUpdate(updatedForm);
//
//        // Return the saved data as the response
//        return ResponseEntity.ok(savedData);
//    }
//
//    @GetMapping("/get/{loginId}/{year}")
//    public ResponseEntity<List<S1CoalUsed>> getCoalUsedData(@PathVariable Long loginId, @PathVariable String year) {
//        List<S1CoalUsed> dataList = s1CoalUsedService.getCoalUsedByLoginIdAndYear(loginId, year);
//        return ResponseEntity.ok(dataList);
//    }
//
//    private Map<String, String> generateMonthYearMappings(String financialYear) {
//        // Assuming financialYear format is "2023-2024"
//        String[] parts = financialYear.split("-");
//        String startYear = parts[0];
//        String endYear = parts[1];
//        
//        // Convert year to 2-digit format
//        String startYearShort = startYear.substring(2);
//        String endYearShort = endYear.substring(2);
//        
//        Map<String, String> monthYearMapping = new HashMap<>();
//        String[] months = {"April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March"};
//        
//        for (int i = 0; i < months.length; i++) {
//            if (i < 8) { // Months from April to December
//                monthYearMapping.put(months[i], startYearShort);
//            } else { // Months from January to March
//                monthYearMapping.put(months[i], endYearShort);
//            }
//        }
//        
//        return monthYearMapping;
//    }
//
//    private S1CoalUsedForm updateFormWithMonthYear(S1CoalUsedForm form, Map<String, String> monthYearMapping) {
//        // Helper method to apply month-year mappings to the form
//        S1CoalUsedForm updatedForm = new S1CoalUsedForm();
//        updatedForm.setUserId(form.getUserId());
//        updatedForm.setYear(form.getYear());
//
//        for (Map.Entry<String, String> entry : monthYearMapping.entrySet()) {
//            String month = entry.getKey();
//            String year = entry.getValue();
//            
//            // Use reflection to set values dynamically
//            try {
//                String prefix = month.toLowerCase() + year;
//                for (Field field : S1CoalUsedForm.class.getDeclaredFields()) {
//                    if (field.getName().startsWith(prefix)) {
//                        field.setAccessible(true);
//                        field.set(updatedForm, field.get(form));
//                    }
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        
//        return updatedForm;
//    }
//}
