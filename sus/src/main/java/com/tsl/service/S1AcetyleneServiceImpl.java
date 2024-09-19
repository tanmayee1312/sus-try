package com.tsl.service;

import com.tsl.pojo.S1Acetylene;
import com.tsl.dto.S1AcetyleneForm;
import com.tsl.exception.DataAlreadyExistsException;
import com.tsl.exception.CustomException;

import com.tsl.repository.S1AcetyleneRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
@Service
public class S1AcetyleneServiceImpl implements S1AcetyleneService {

    @Autowired
    private S1AcetyleneRepository repository;

    private static final double EMISSION_FACTOR = 3.38044396651048;

    @Override
    public void saveS1Acetylene(S1AcetyleneForm form) {
        List<S1Acetylene> records = new ArrayList<>();
        double totalYearlyEmission = 0.0;

        // Process each month
        for (String month : List.of("April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March")) {
            try {
                // Use reflection to get the values for the current month
                String methodNamePrefix = month.substring(0, 3).toLowerCase(); // e.g., "apr", "may"
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM();

                // Validate UOM and calculate emission only if UOM is valid
                if (isValidUOM(uom)) {
                    // Convert cylinder capacity to kg if necessary
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    // Calculate monthly emission
                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);

                    // Add to total yearly emission
                    totalYearlyEmission += monthlyEmission;

                    // Convert DTO to Entity and add to the list
                    S1Acetylene record = form.toS1Acetylene(month, acetyleneCylinderPurchased, cylinderCapacity, materialCost, monthlyEmission, form.getUserId());
                    records.add(record);
                } else {
                    System.err.println("Invalid UOM for month: " + month + ". Skipping calculations.");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        // Set the yearly emission for all records
        for (S1Acetylene record : records) {
            record.setYearlyEmission(totalYearlyEmission);
        }

        // Save all records to the repository
        repository.saveAll(records);
    }

    

    @Override
    @Transactional  // Ensure this is transactional
    public void updateS1Acetylene(S1AcetyleneForm form, Long loginId, String year) {
        List<S1Acetylene> existingRecords = repository.findByLoginIdAndYear(loginId, year);
        if (existingRecords.isEmpty()) {
            throw new IllegalArgumentException("No records found for the given loginId and year.");
        }

        double totalYearlyEmission = 0.0;

        for (S1Acetylene record : existingRecords) {
            String methodNamePrefix = record.getMonth().substring(0, 3).toLowerCase();

            try {
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM(); // Extract the UOM

                if (isValidUOM(uom)) {
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);
                    totalYearlyEmission += monthlyEmission;

                    // Now pass the UOM when updating the record
                    repository.updateS1AcetyleneByMonth(loginId, year, record.getMonth(), acetyleneCylinderPurchased, cylinderCapacity, materialCost, monthlyEmission, totalYearlyEmission, uom);

                } else {
                    System.err.println("Invalid UOM for month: " + record.getMonth() + ". Skipping calculations.");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + record.getMonth());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + record.getMonth());
                e.printStackTrace();
            }
        }
    }

    
    @Override
    public List<S1Acetylene> getS1AcetyleneByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }

    // Helper method to calculate monthly emission
    private double calculateMonthlyEmission(Double acetyleneCylinderPurchased, Double cylinderCapacity) {
        if (acetyleneCylinderPurchased == null || cylinderCapacity == null) {
            return 0.0;
        }
        return acetyleneCylinderPurchased * cylinderCapacity * EMISSION_FACTOR;
    }

    // Helper method to capitalize the first letter of a string
    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    // Helper method to validate UOM
    private boolean isValidUOM(String uom) {
        return "kg".equalsIgnoreCase(uom) || "tonne".equalsIgnoreCase(uom);
    }
}
*/
@Service
public class S1AcetyleneServiceImpl implements S1AcetyleneService {

    @Autowired
    private S1AcetyleneRepository repository;

    private static final double EMISSION_FACTOR = 3.38044396651048;

    @Override
    @Transactional
    public void saveOrUpdateS1Acetylene(S1AcetyleneForm form) {
        List<S1Acetylene> existingRecords = repository.findByLoginIdAndYear(form.getUserId(), form.getYear());
        
        if (existingRecords.isEmpty()) {
            // No existing records, save new records
            saveS1Acetylene(form);
        } else {
            // Existing records found, throw exception
            throw new DataAlreadyExistsException("Records already exist for the given loginId and year.");
        }
    }
//----------------------uom exception done-----------------------------------------
    @Override
    public void saveS1Acetylene(S1AcetyleneForm form) {
        List<S1Acetylene> records = new ArrayList<>();
        double totalYearlyEmission = 0.0;

        StringBuilder errorMessages = new StringBuilder();

        // Process each month
        for (String month : List.of("April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March")) {
            try {
                String methodNamePrefix = month.substring(0, 3).toLowerCase(); // e.g., "apr", "may"
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM();

                if (isValidUOM(uom)) {
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);
                    totalYearlyEmission += monthlyEmission;

                    S1Acetylene record = form.toS1Acetylene(month, acetyleneCylinderPurchased, cylinderCapacity, materialCost, monthlyEmission, form.getUserId());
                    records.add(record);
                } else {
                    // Collect error messages
                    errorMessages.append("Invalid UOM for month: ").append(month).append(". ");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        if (errorMessages.length() > 0) {
            throw new CustomException(errorMessages.toString());
        }

        for (S1Acetylene record : records) {
            record.setYearlyEmission(totalYearlyEmission);
        }

        repository.saveAll(records);
    }


    
    //-----------------------------------------best working ---------------------------------
    /*
    @Override
    public void saveS1Acetylene(S1AcetyleneForm form) {
        List<S1Acetylene> records = new ArrayList<>();
        double totalYearlyEmission = 0.0;

        // Process each month
        for (String month : List.of("April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March")) {
            try {
                String methodNamePrefix = month.substring(0, 3).toLowerCase(); // e.g., "apr", "may"
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM();

                if (isValidUOM(uom)) {
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);
                    totalYearlyEmission += monthlyEmission;

                    S1Acetylene record = form.toS1Acetylene(month, acetyleneCylinderPurchased, cylinderCapacity, materialCost, monthlyEmission, form.getUserId());
                    records.add(record);
                } else {
                    System.err.println("Invalid UOM for month: " + month + ". Skipping calculations.");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        for (S1Acetylene record : records) {
            record.setYearlyEmission(totalYearlyEmission);
        }

        repository.saveAll(records);
    }
*/
    
    
    //------------------------update first code ------------------------------------
    /*
    @Override
    @Transactional
    public void updateS1Acetylene(S1AcetyleneForm form, Long loginId, String year) {
        List<S1Acetylene> existingRecords = repository.findByLoginIdAndYear(loginId, year);
        if (existingRecords.isEmpty()) {
            throw new IllegalArgumentException("No records found for the given loginId and year.");
        }

        double totalYearlyEmission = 0.0;

        for (S1Acetylene record : existingRecords) {
            String methodNamePrefix = record.getMonth().substring(0, 3).toLowerCase();

            try {
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM();

                if (isValidUOM(uom)) {
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);
                    totalYearlyEmission += monthlyEmission;

                    repository.updateS1AcetyleneByMonth(loginId, year, record.getMonth(), acetyleneCylinderPurchased, cylinderCapacity, materialCost, monthlyEmission, totalYearlyEmission, uom);

                } else {
                    System.err.println("Invalid UOM for month: " + record.getMonth() + ". Skipping calculations.");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + record.getMonth());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + record.getMonth());
                e.printStackTrace();
            }
        }
    }
*/
    
    //------------------------update second code working------------------------
/*
    @Override
    @Transactional
    public void updateS1Acetylene(S1AcetyleneForm form, Long loginId, String year) {
        List<S1Acetylene> existingRecords = repository.findByLoginIdAndYear(loginId, year);
        if (existingRecords.isEmpty()) {
            throw new IllegalArgumentException("No records found for the given loginId and year.");
        }

        // Calculate total yearly emission first
        double totalYearlyEmission = 0.0;
        for (String month : List.of("April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March")) {
            String methodNamePrefix = month.substring(0, 3).toLowerCase();
            try {
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM();

                if (isValidUOM(uom)) {
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);
                    totalYearlyEmission += monthlyEmission;
                } else {
                    System.err.println("Invalid UOM for month: " + month + ". Skipping calculations.");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        // Update records with the accumulated totalYearlyEmission
        for (S1Acetylene record : existingRecords) {
            String month = record.getMonth();
            String methodNamePrefix = month.substring(0, 3).toLowerCase();

            try {
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM();

                if (isValidUOM(uom)) {
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);
                    record.setAcetyleneCylinderPurchased(acetyleneCylinderPurchased);
                    record.setCylinderCapacity(cylinderCapacity);
                    record.setMaterialCost(materialCost);
                    record.setMonthlyEmission(monthlyEmission);
                    record.setYearlyEmission(totalYearlyEmission);
                    record.setCylinderCapacityUOM(uom);
                } else {
                    System.err.println("Invalid UOM for month: " + month + ". Skipping calculations.");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        repository.saveAll(existingRecords);
    }
*/
    
    //-------------------done add validation of uom in update -------------------------------
    @Override
    @Transactional
    public void updateS1Acetylene(S1AcetyleneForm form, Long loginId, String year) {
        List<S1Acetylene> existingRecords = repository.findByLoginIdAndYear(loginId, year);
        if (existingRecords.isEmpty()) {
            throw new IllegalArgumentException("No records found for the given loginId and year.");
        }

        // Calculate total yearly emission first
        double totalYearlyEmission = 0.0;
        StringBuilder errorMessages = new StringBuilder();

        for (String month : List.of("April", "May", "June", "July", "August", "September", "October", "November", "December", "January", "February", "March")) {
            String methodNamePrefix = month.substring(0, 3).toLowerCase();
            try {
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM();

                if (isValidUOM(uom)) {
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);
                    totalYearlyEmission += monthlyEmission;
                } else {
                    errorMessages.append("Invalid UOM for month: ").append(month).append(". ");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        if (errorMessages.length() > 0) {
            throw new CustomException(errorMessages.toString());
        }

        // Update records with the accumulated totalYearlyEmission
        for (S1Acetylene record : existingRecords) {
            String month = record.getMonth();
            String methodNamePrefix = month.substring(0, 3).toLowerCase();

            try {
                Double acetyleneCylinderPurchased = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "AcetyleneCylinderPurchased").invoke(form);
                Double cylinderCapacity = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "CylinderCapacity").invoke(form);
                Double materialCost = (Double) S1AcetyleneForm.class.getMethod("get" + capitalize(methodNamePrefix) + "MaterialCost").invoke(form);
                String uom = form.getCylinderCapacityUOM();

                if (isValidUOM(uom)) {
                    if ("tonne".equalsIgnoreCase(uom)) {
                        cylinderCapacity *= 1000;
                    }

                    double monthlyEmission = calculateMonthlyEmission(acetyleneCylinderPurchased, cylinderCapacity);
                    record.setAcetyleneCylinderPurchased(acetyleneCylinderPurchased);
                    record.setCylinderCapacity(cylinderCapacity);
                    record.setMaterialCost(materialCost);
                    record.setMonthlyEmission(monthlyEmission);
                    record.setYearlyEmission(totalYearlyEmission);
                    record.setCylinderCapacityUOM(uom);
                } else {
                    errorMessages.append("Invalid UOM for month: ").append(month).append(". ");
                }
            } catch (NoSuchMethodException e) {
                System.err.println("Method not found for month: " + month);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error processing month: " + month);
                e.printStackTrace();
            }
        }

        if (errorMessages.length() > 0) {
            throw new CustomException(errorMessages.toString());
        }

        repository.saveAll(existingRecords);
    }

    @Override
    public List<S1Acetylene> getS1AcetyleneByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }

    private double calculateMonthlyEmission(Double acetyleneCylinderPurchased, Double cylinderCapacity) {
        if (acetyleneCylinderPurchased == null || cylinderCapacity == null) {
            return 0.0;
        }
        return acetyleneCylinderPurchased * cylinderCapacity * EMISSION_FACTOR;
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private boolean isValidUOM(String uom) {
        return "kg".equalsIgnoreCase(uom) || "tonne".equalsIgnoreCase(uom);
    }
}
