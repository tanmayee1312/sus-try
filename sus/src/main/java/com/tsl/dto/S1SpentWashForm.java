package com.tsl.dto;

import com.tsl.pojo.S1SpentWash;
import com.tsl.pojo.Login;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class S1SpentWashForm {
    private Long userId;
    private String year;

    private Double aprSpentWashGenerated;
    private Double aprSpentWashUsedInComposting;

    private Double maySpentWashGenerated;
    private Double maySpentWashUsedInComposting;

    private Double junSpentWashGenerated;
    private Double junSpentWashUsedInComposting;

    private Double julSpentWashGenerated;
    private Double julSpentWashUsedInComposting;

    private Double augSpentWashGenerated;
    private Double augSpentWashUsedInComposting;

    private Double sepSpentWashGenerated;
    private Double sepSpentWashUsedInComposting;

    private Double octSpentWashGenerated;
    private Double octSpentWashUsedInComposting;

    private Double novSpentWashGenerated;
    private Double novSpentWashUsedInComposting;

    private Double decSpentWashGenerated;
    private Double decSpentWashUsedInComposting;

    private Double janSpentWashGenerated;
    private Double janSpentWashUsedInComposting;

    private Double febSpentWashGenerated;
    private Double febSpentWashUsedInComposting;

    private Double marSpentWashGenerated;
    private Double marSpentWashUsedInComposting;

    public S1SpentWash toS1SpentWash(String month, Double spentWashGenerated, Double spentWashUsedInComposting, Long loginId) {
        S1SpentWash data = new S1SpentWash();
        data.setYear(year);
        data.setMonth(month);
        data.setMonthlySpentWashGenerated(spentWashGenerated);
        data.setMonthlySpentWashUsedInComposting(spentWashUsedInComposting);

        // Assuming you have a method to fetch Login by loginId
        Login login = new Login(); // Replace with actual fetching logic
        login.setId(loginId);
        data.setLogin(login);

        return data;
    }
}
