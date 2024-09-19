package com.tsl.dto;

import com.tsl.pojo.Login;
import com.tsl.pojo.S1CoalUsed;
import lombok.Getter;
import lombok.Setter;


/*
@Getter
@Setter
public class S1CoalUsedForm {
    private Long userId;
    private String year;

    // Monthly data fields
    private double aprMonthlyCoalPurchased;
    private String aprTypeOfCoal;
    private double aprMonthlyCoalUsed;
    private double aprCoalCost;

    private double mayMonthlyCoalPurchased;
    private String mayTypeOfCoal;
    private double mayMonthlyCoalUsed;
    private double mayCoalCost;

    private double junMonthlyCoalPurchased;
    private String junTypeOfCoal;
    private double junMonthlyCoalUsed;
    private double junCoalCost;

    private double julMonthlyCoalPurchased;
    private String julTypeOfCoal;
    private double julMonthlyCoalUsed;
    private double julCoalCost;

    private double augMonthlyCoalPurchased;
    private String augTypeOfCoal;
    private double augMonthlyCoalUsed;
    private double augCoalCost;

    private double sepMonthlyCoalPurchased;
    private String sepTypeOfCoal;
    private double sepMonthlyCoalUsed;
    private double sepCoalCost;

    private double octMonthlyCoalPurchased;
    private String octTypeOfCoal;
    private double octMonthlyCoalUsed;
    private double octCoalCost;

    private double novMonthlyCoalPurchased;
    private String novTypeOfCoal;
    private double novMonthlyCoalUsed;
    private double novCoalCost;

    private double decMonthlyCoalPurchased;
    private String decTypeOfCoal;
    private double decMonthlyCoalUsed;
    private double decCoalCost;

    private double janMonthlyCoalPurchased;
    private String janTypeOfCoal;
    private double janMonthlyCoalUsed;
    private double janCoalCost;

    private double febMonthlyCoalPurchased;
    private String febTypeOfCoal;
    private double febMonthlyCoalUsed;
    private double febCoalCost;

    private double marMonthlyCoalPurchased;
    private String marTypeOfCoal;
    private double marMonthlyCoalUsed;
    private double marCoalCost;

    // Total yearly emissions field
    private double yearlyEmissions;

    public S1CoalUsed toS1CoalUsed(String month, double monthlyCoalPurchased, String typeOfCoal, double monthlyCoalUsed, double coalCost, Long loginId) {
        double emissionFactor = 2396.47994362416; // Ensure this is consistently set
        double totalEmissions = calculateEmissionsForMonth(monthlyCoalUsed);

        S1CoalUsed data = new S1CoalUsed();
        data.setYear(this.year);
        data.setMonth(month);
        data.setMonthlyCoalPurchased(monthlyCoalPurchased);
        data.setTypeOfCoal(typeOfCoal);
        data.setMonthlyCoalUsed(monthlyCoalUsed);
        data.setCoalCost(coalCost);
        data.setTotalEmissions(totalEmissions);

        // Set the login object
        Login login = new Login(); // Replace with actual fetching logic
        login.setId(loginId);
        data.setLogin(login);

        return data;
    }

    // Helper method to calculate emissions for a month
    private double calculateEmissionsForMonth(double monthlyCoalUsed) {
        double emissionFactor = 2396.47994362416; // Ensure this is consistently set
        return (emissionFactor * monthlyCoalUsed) / 1000;
    }

    // Method to calculate total yearly emissions by summing monthly emissions
    public double calculateYearlyEmissions() {
        return calculateEmissionsForMonth(aprMonthlyCoalUsed) +
               calculateEmissionsForMonth(mayMonthlyCoalUsed) +
               calculateEmissionsForMonth(junMonthlyCoalUsed) +
               calculateEmissionsForMonth(julMonthlyCoalUsed) +
               calculateEmissionsForMonth(augMonthlyCoalUsed) +
               calculateEmissionsForMonth(sepMonthlyCoalUsed) +
               calculateEmissionsForMonth(octMonthlyCoalUsed) +
               calculateEmissionsForMonth(novMonthlyCoalUsed) +
               calculateEmissionsForMonth(decMonthlyCoalUsed) +
               calculateEmissionsForMonth(janMonthlyCoalUsed) +
               calculateEmissionsForMonth(febMonthlyCoalUsed) +
               calculateEmissionsForMonth(marMonthlyCoalUsed);
    }
}
*/

@Getter
@Setter
public class S1CoalUsedForm {
    private Long userId;
    private String year;

    private double aprilMonthlyCoalPurchased;
    private String aprilTypeOfCoal;
    private double aprilMonthlyCoalUsed;
    private double aprilCoalCost;

    private double mayMonthlyCoalPurchased;
    private String mayTypeOfCoal;
    private double mayMonthlyCoalUsed;
    private double mayCoalCost;

    private double juneMonthlyCoalPurchased;
    private String juneTypeOfCoal;
    private double juneMonthlyCoalUsed;
    private double juneCoalCost;

    private double julyMonthlyCoalPurchased;
    private String julyTypeOfCoal;
    private double julyMonthlyCoalUsed;
    private double julyCoalCost;

    private double augustMonthlyCoalPurchased;
    private String augustTypeOfCoal;
    private double augustMonthlyCoalUsed;
    private double augustCoalCost;

    private double septemberMonthlyCoalPurchased;
    private String septemberTypeOfCoal;
    private double septemberMonthlyCoalUsed;
    private double septemberCoalCost;

    private double octoberMonthlyCoalPurchased;
    private String octoberTypeOfCoal;
    private double octoberMonthlyCoalUsed;
    private double octoberCoalCost;

    private double novemberMonthlyCoalPurchased;
    private String novemberTypeOfCoal;
    private double novemberMonthlyCoalUsed;
    private double novemberCoalCost;

    private double decemberMonthlyCoalPurchased;
    private String decemberTypeOfCoal;
    private double decemberMonthlyCoalUsed;
    private double decemberCoalCost;

    private double januaryMonthlyCoalPurchased;
    private String januaryTypeOfCoal;
    private double januaryMonthlyCoalUsed;
    private double januaryCoalCost;

    private double februaryMonthlyCoalPurchased;
    private String februaryTypeOfCoal;
    private double februaryMonthlyCoalUsed;
    private double februaryCoalCost;

    private double marchMonthlyCoalPurchased;
    private String marchTypeOfCoal;
    private double marchMonthlyCoalUsed;
    private double marchCoalCost;

    private double calculateEmissionsForMonth(double monthlyCoalUsed) {
        double emissionFactor = 2396.47994362416; // Use constant emission factor
        return (emissionFactor * monthlyCoalUsed) / 1000;
    }

    public double calculateYearlyEmissions() {
        return calculateEmissionsForMonth(aprilMonthlyCoalUsed) +
               calculateEmissionsForMonth(mayMonthlyCoalUsed) +
               calculateEmissionsForMonth(juneMonthlyCoalUsed) +
               calculateEmissionsForMonth(julyMonthlyCoalUsed) +
               calculateEmissionsForMonth(augustMonthlyCoalUsed) +
               calculateEmissionsForMonth(septemberMonthlyCoalUsed) +
               calculateEmissionsForMonth(octoberMonthlyCoalUsed) +
               calculateEmissionsForMonth(novemberMonthlyCoalUsed) +
               calculateEmissionsForMonth(decemberMonthlyCoalUsed) +
               calculateEmissionsForMonth(januaryMonthlyCoalUsed) +
               calculateEmissionsForMonth(februaryMonthlyCoalUsed) +
               calculateEmissionsForMonth(marchMonthlyCoalUsed);
    }

    public S1CoalUsed toS1CoalUsed(String month, double monthlyCoalPurchased, String typeOfCoal, double monthlyCoalUsed, double coalCost, Long loginId) {
        double emissionFactor = 2396.47994362416; 
        double totalEmissions = calculateEmissionsForMonth(monthlyCoalUsed);

        S1CoalUsed data = new S1CoalUsed();
        data.setYear(this.year);
        data.setMonth(month);
        data.setMonthlyCoalPurchased(monthlyCoalPurchased);
        data.setTypeOfCoal(typeOfCoal);
        data.setMonthlyCoalUsed(monthlyCoalUsed);
        data.setCoalCost(coalCost);
        data.setTotalEmissions(totalEmissions);

        Login login = new Login(); 
        login.setId(loginId);
        data.setLogin(login);

        return data;
    }
}
