package com.tsl.BRSR.service;

import com.tsl.BRSR.dto.GeneralDiscloserRequest;
import com.tsl.pojo.GeneralDiscloser;
import com.tsl.pojo.Login;
import com.tsl.BRSR.repository.GeneralDiscloserRepository;
import com.tsl.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralDiscloserService {

    @Autowired
    private GeneralDiscloserRepository generalDiscloserRepository;

    @Autowired
    private LoginRepository loginRepository;

    // Save operation for creating new entries
    public List<GeneralDiscloser> saveAll(Long userId, List<GeneralDiscloserRequest> generalDiscloserRequestList) {
        // Fetch the user by userId
        Login user = loginRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Convert DTOs to Entities
        List<GeneralDiscloser> generalDiscloserList = generalDiscloserRequestList.stream().map(dto -> {
            GeneralDiscloser generalDiscloser = new GeneralDiscloser();
            generalDiscloser.setCin(dto.getCin());
            generalDiscloser.setName(dto.getName());
            generalDiscloser.setYearOfIncorporation(dto.getYearOfIncorporation());
            generalDiscloser.setRegisteredOfficeAddress(dto.getRegisteredOfficeAddress());
            generalDiscloser.setCorporateAddress(dto.getCorporateAddress());
            generalDiscloser.setEmail(dto.getEmail());
            generalDiscloser.setTelephone(dto.getTelephone());
            generalDiscloser.setWebsite(dto.getWebsite());
            generalDiscloser.setFinancialYear(dto.getFinancialYear());
            generalDiscloser.setStockExchanges(dto.getStockExchanges());
            generalDiscloser.setPaidUpCapital(dto.getPaidUpCapital());
            generalDiscloser.setContactName(dto.getContactName());
            generalDiscloser.setContactTelephone(dto.getContactTelephone());
            generalDiscloser.setContactEmail(dto.getContactEmail());
            generalDiscloser.setReportingBoundary(dto.getReportingBoundary());
            generalDiscloser.setAssuranceProvider(dto.getAssuranceProvider());
            generalDiscloser.setTypeOfAssurance(dto.getTypeOfAssurance());
            generalDiscloser.setYear(dto.getYear());
            generalDiscloser.setUser(user);
            return generalDiscloser;
        }).collect(Collectors.toList());

        // Save all GeneralDiscloser entries
        return generalDiscloserRepository.saveAll(generalDiscloserList);
    }

    // Update operation for editing existing entries
    public List<GeneralDiscloser> updateGeneralDisclosers(Long userId, List<GeneralDiscloserRequest> generalDiscloserRequestList) {
        return generalDiscloserRequestList.stream().map(dto -> {
            // Fetch the GeneralDiscloser by id and userId
            GeneralDiscloser generalDiscloser = generalDiscloserRepository.findByIdAndUserId(dto.getId(), userId);
            if (generalDiscloser != null) {
                generalDiscloser.setCin(dto.getCin());
                generalDiscloser.setName(dto.getName());
                generalDiscloser.setYearOfIncorporation(dto.getYearOfIncorporation());
                generalDiscloser.setRegisteredOfficeAddress(dto.getRegisteredOfficeAddress());
                generalDiscloser.setCorporateAddress(dto.getCorporateAddress());
                generalDiscloser.setEmail(dto.getEmail());
                generalDiscloser.setTelephone(dto.getTelephone());
                generalDiscloser.setWebsite(dto.getWebsite());
                generalDiscloser.setFinancialYear(dto.getFinancialYear());
                generalDiscloser.setStockExchanges(dto.getStockExchanges());
                generalDiscloser.setPaidUpCapital(dto.getPaidUpCapital());
                generalDiscloser.setContactName(dto.getContactName());
                generalDiscloser.setContactTelephone(dto.getContactTelephone());
                generalDiscloser.setContactEmail(dto.getContactEmail());
                generalDiscloser.setReportingBoundary(dto.getReportingBoundary());
                generalDiscloser.setAssuranceProvider(dto.getAssuranceProvider());
                generalDiscloser.setTypeOfAssurance(dto.getTypeOfAssurance());
                generalDiscloser.setYear(dto.getYear());
                return generalDiscloserRepository.save(generalDiscloser);
            } else {
                throw new RuntimeException("GeneralDiscloser not found for id: " + dto.getId() + " and userId: " + userId);
            }
        }).collect(Collectors.toList());
    }

    // Fetch GeneralDiscloser by userId and year
    public List<GeneralDiscloser> getGeneralDisclosersByUserIdAndYear(Long userId, String year) {
        return generalDiscloserRepository.findByUserIdAndYear(userId, year);
    }

    // Fetch GeneralDiscloser by userId
    public List<GeneralDiscloser> getGeneralDisclosersByUserId(Long userId) {
        return generalDiscloserRepository.findByUserId(userId);
    }

    // Fetch all GeneralDiscloser entries
    public List<GeneralDiscloser> getAllGeneralDisclosers() {
        return generalDiscloserRepository.findAll();
    }

    // Fetch GeneralDiscloser by id
    public GeneralDiscloser getGeneralDiscloserById(Long id) {
        return generalDiscloserRepository.findById(id).orElse(null);
    }
}
