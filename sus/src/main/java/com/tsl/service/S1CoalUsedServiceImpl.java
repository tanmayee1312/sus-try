package com.tsl.service;

import com.tsl.dto.S1CoalUsedForm;
import com.tsl.pojo.S1CoalUsed;
import com.tsl.repository.S1CoalUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//@Service
//public class S1CoalUsedServiceImpl implements S1CoalUsedService {
//
//    @Autowired
//    private S1CoalUsedRepository s1CoalUsedRepository;
//
//    @Override
//    public List<S1CoalUsed> saveOrUpdate(S1CoalUsedForm form) {
//        Long loginId = form.getUserId();
//        String year = form.getYear();
//        List<S1CoalUsed> dataList = new ArrayList<>();
//
//        // Calculate total yearly emissions based on monthly data
//        double yearlyEmissions = form.calculateYearlyEmissions();
//
//        // Save data for each month individually using full month names
//        dataList.add(form.toS1CoalUsed("April", form.getAprilMonthlyCoalPurchased(), form.getAprilTypeOfCoal(), form.getAprilMonthlyCoalUsed(), form.getAprilCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("May", form.getMayMonthlyCoalPurchased(), form.getMayTypeOfCoal(), form.getMayMonthlyCoalUsed(), form.getMayCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("June", form.getJuneMonthlyCoalPurchased(), form.getJuneTypeOfCoal(), form.getJuneMonthlyCoalUsed(), form.getJuneCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("July", form.getJulyMonthlyCoalPurchased(), form.getJulyTypeOfCoal(), form.getJulyMonthlyCoalUsed(), form.getJulyCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("August", form.getAugustMonthlyCoalPurchased(), form.getAugustTypeOfCoal(), form.getAugustMonthlyCoalUsed(), form.getAugustCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("September", form.getSeptemberMonthlyCoalPurchased(), form.getSeptemberTypeOfCoal(), form.getSeptemberMonthlyCoalUsed(), form.getSeptemberCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("October", form.getOctoberMonthlyCoalPurchased(), form.getOctoberTypeOfCoal(), form.getOctoberMonthlyCoalUsed(), form.getOctoberCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("November", form.getNovemberMonthlyCoalPurchased(), form.getNovemberTypeOfCoal(), form.getNovemberMonthlyCoalUsed(), form.getNovemberCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("December", form.getDecemberMonthlyCoalPurchased(), form.getDecemberTypeOfCoal(), form.getDecemberMonthlyCoalUsed(), form.getDecemberCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("January", form.getJanuaryMonthlyCoalPurchased(), form.getJanuaryTypeOfCoal(), form.getJanuaryMonthlyCoalUsed(), form.getJanuaryCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("February", form.getFebruaryMonthlyCoalPurchased(), form.getFebruaryTypeOfCoal(), form.getFebruaryMonthlyCoalUsed(), form.getFebruaryCoalCost(), loginId));
//        dataList.add(form.toS1CoalUsed("March", form.getMarchMonthlyCoalPurchased(), form.getMarchTypeOfCoal(), form.getMarchMonthlyCoalUsed(), form.getMarchCoalCost(), loginId));
//
//        // Save all the data in the repository
//        List<S1CoalUsed> savedData = s1CoalUsedRepository.saveAll(dataList);
//
//        // Update yearly emissions for each record (not in JSON)
//        for (S1CoalUsed data : savedData) {
//            data.setYearlyEmissions(yearlyEmissions);
//        }
//
//        // Save again with updated yearly emissions
//        s1CoalUsedRepository.saveAll(savedData);
//
//        return savedData;
//    }
//
//    @Override
//    public List<S1CoalUsed> getCoalUsedByLoginIdAndYear(Long loginId, String year) {
//        return s1CoalUsedRepository.findByLoginIdAndYear(loginId, year);
//    }
//}



@Service
public class S1CoalUsedServiceImpl implements S1CoalUsedService {

    @Autowired
    private S1CoalUsedRepository s1CoalUsedRepository;

    @Override
    public List<S1CoalUsed> saveOrUpdate(S1CoalUsedForm form) {
        Long loginId = form.getUserId();
        String financialYear = form.getYear();
        
        // Split the financial year into start and end year
        String[] years = financialYear.split("-");
        String startYear = years[0];
        String endYear = years[1];

        List<S1CoalUsed> dataList = new ArrayList<>();

        // Calculate total yearly emissions based on monthly data
        double yearlyEmissions = form.calculateYearlyEmissions();

        // Save data for each month individually using formatted months
        dataList.add(form.toS1CoalUsed(formatMonth("April", startYear, endYear), form.getAprilMonthlyCoalPurchased(), form.getAprilTypeOfCoal(), form.getAprilMonthlyCoalUsed(), form.getAprilCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("May", startYear, endYear), form.getMayMonthlyCoalPurchased(), form.getMayTypeOfCoal(), form.getMayMonthlyCoalUsed(), form.getMayCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("June", startYear, endYear), form.getJuneMonthlyCoalPurchased(), form.getJuneTypeOfCoal(), form.getJuneMonthlyCoalUsed(), form.getJuneCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("July", startYear, endYear), form.getJulyMonthlyCoalPurchased(), form.getJulyTypeOfCoal(), form.getJulyMonthlyCoalUsed(), form.getJulyCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("August", startYear, endYear), form.getAugustMonthlyCoalPurchased(), form.getAugustTypeOfCoal(), form.getAugustMonthlyCoalUsed(), form.getAugustCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("September", startYear, endYear), form.getSeptemberMonthlyCoalPurchased(), form.getSeptemberTypeOfCoal(), form.getSeptemberMonthlyCoalUsed(), form.getSeptemberCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("October", startYear, endYear), form.getOctoberMonthlyCoalPurchased(), form.getOctoberTypeOfCoal(), form.getOctoberMonthlyCoalUsed(), form.getOctoberCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("November", startYear, endYear), form.getNovemberMonthlyCoalPurchased(), form.getNovemberTypeOfCoal(), form.getNovemberMonthlyCoalUsed(), form.getNovemberCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("December", startYear, endYear), form.getDecemberMonthlyCoalPurchased(), form.getDecemberTypeOfCoal(), form.getDecemberMonthlyCoalUsed(), form.getDecemberCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("January", startYear, endYear), form.getJanuaryMonthlyCoalPurchased(), form.getJanuaryTypeOfCoal(), form.getJanuaryMonthlyCoalUsed(), form.getJanuaryCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("February", startYear, endYear), form.getFebruaryMonthlyCoalPurchased(), form.getFebruaryTypeOfCoal(), form.getFebruaryMonthlyCoalUsed(), form.getFebruaryCoalCost(), loginId));
        dataList.add(form.toS1CoalUsed(formatMonth("March", startYear, endYear), form.getMarchMonthlyCoalPurchased(), form.getMarchTypeOfCoal(), form.getMarchMonthlyCoalUsed(), form.getMarchCoalCost(), loginId));

        // Save all the data in the repository
        List<S1CoalUsed> savedData = s1CoalUsedRepository.saveAll(dataList);

        // Update yearly emissions for each record (not in JSON)
        for (S1CoalUsed data : savedData) {
            data.setYearlyEmissions(yearlyEmissions);
        }

        // Save again with updated yearly emissions
        s1CoalUsedRepository.saveAll(savedData);

        return savedData;
    }

    @Override
    public List<S1CoalUsed> getCoalUsedByLoginIdAndYear(Long loginId, String year) {
        return s1CoalUsedRepository.findByLoginIdAndYear(loginId, year);
    }

    private String formatMonth(String monthName, String startYear, String endYear) {
        // Determine the year suffix for the month
        if (monthName.equals("April") || monthName.equals("May") || monthName.equals("June") ||
            monthName.equals("July") || monthName.equals("August") || monthName.equals("September") ||
            monthName.equals("October") || monthName.equals("November") || monthName.equals("December")) {
            return monthName + "-" + startYear.substring(2); // Use the start year for these months
        } else {
            return monthName + "-" + endYear.substring(2); // Use the end year for these months
        }
    }
}
