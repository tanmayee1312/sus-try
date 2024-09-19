//package com.tsl.service;
//
//import com.tsl.pojo.S1ArcWelding;
//import com.tsl.pojo.Login;
//import com.tsl.dto.S1ArcWeldingForm;
//import com.tsl.repository.S1ArcWeldingRepository;
//import com.tsl.service.S1ArcWeldingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class S1ArcWeldingServiceImpl implements S1ArcWeldingService {
//
//    @Autowired
//    private S1ArcWeldingRepository repository;
//
//    @Override
//    public List<S1ArcWelding> getAllByLoginId(Long loginId) {
//        return repository.findByLoginId(loginId);
//    }
//    @Override
//    public List<S1ArcWelding> findByYearAndLoginId(String year, Long loginId) {
//        return repository.findByYearAndLoginId(year, loginId);
//    }
//    @Override
//    public S1ArcWelding saveOrUpdate(S1ArcWeldingForm form, Long loginId) {
//        List<S1ArcWelding> weldings = List.of(
//            createS1ArcWelding(form, "Jan", loginId),
//            createS1ArcWelding(form, "Feb", loginId),
//            createS1ArcWelding(form, "Mar", loginId),
//            createS1ArcWelding(form, "Apr", loginId),
//            createS1ArcWelding(form, "May", loginId),
//            createS1ArcWelding(form, "Jun", loginId),
//            createS1ArcWelding(form, "Jul", loginId),
//            createS1ArcWelding(form, "Aug", loginId),
//            createS1ArcWelding(form, "Sep", loginId),
//            createS1ArcWelding(form, "Oct", loginId),
//            createS1ArcWelding(form, "Nov", loginId),
//            createS1ArcWelding(form, "Dec", loginId)
//        );
//
//        return repository.saveAll(weldings).stream().findFirst().orElse(null);
//    }
//    @Override
//    public List<S1ArcWelding> updateS1ArcWeldingByLoginId(S1ArcWeldingForm form, Long loginId) {
//        // Fetch existing weldings for the given loginId
//        List<S1ArcWelding> weldings = repository.findByLoginId(loginId);
//
//        // Update each welding record based on the month
//        for (S1ArcWelding welding : weldings) {
//            String month = welding.getMonth();
//            switch (month) {
//                case "Jan":
//                    welding.setElectrodesPurchased(form.getJanElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getJanElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getJanOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getJanCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getJanElectrodesCost());
//                    break;
//                case "Feb":
//                    welding.setElectrodesPurchased(form.getFebElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getFebElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getFebOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getFebCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getFebElectrodesCost());
//                    break;
//                case "Mar":
//                    welding.setElectrodesPurchased(form.getMarElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getMarElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getMarOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getMarCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getMarElectrodesCost());
//                    break;
//                case "Apr":
//                    welding.setElectrodesPurchased(form.getAprElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getAprElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getAprOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getAprCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getAprElectrodesCost());
//                    break;
//                case "May":
//                    welding.setElectrodesPurchased(form.getMayElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getMayElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getMayOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getMayCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getMayElectrodesCost());
//                    break;
//                case "Jun":
//                    welding.setElectrodesPurchased(form.getJunElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getJunElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getJunOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getJunCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getJunElectrodesCost());
//                    break;
//                case "Jul":
//                    welding.setElectrodesPurchased(form.getJulElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getJulElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getJulOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getJulCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getJulElectrodesCost());
//                    break;
//                case "Aug":
//                    welding.setElectrodesPurchased(form.getAugElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getAugElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getAugOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getAugCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getAugElectrodesCost());
//                    break;
//                case "Sep":
//                    welding.setElectrodesPurchased(form.getSepElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getSepElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getSepOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getSepCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getSepElectrodesCost());
//                    break;
//                case "Oct":
//                    welding.setElectrodesPurchased(form.getOctElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getOctElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getOctOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getOctCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getOctElectrodesCost());
//                    break;
//                case "Nov":
//                    welding.setElectrodesPurchased(form.getNovElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getNovElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getNovOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getNovCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getNovElectrodesCost());
//                    break;
//                case "Dec":
//                    welding.setElectrodesPurchased(form.getDecElectrodesPurchased());
//                    welding.setElectrodePurpose(form.getDecElectrodePurpose());
//                    welding.setOpenCircuitVoltage(form.getDecOpenCircuitVoltage());
//                    welding.setCloseCircuitVoltage(form.getDecCloseCircuitVoltage());
//                    welding.setElectrodesCost(form.getDecElectrodesCost());
//                    break;
//                default:
//                    throw new IllegalArgumentException("Invalid month: " + month);
//            }
//            welding.setYear(form.getYear());
//            Login login = new Login();
//            login.setId(loginId);
//            welding.setLogin(login);
//        }
//
//        // Save all updated weldings
//        return repository.saveAll(weldings);
//    }
//
//    private S1ArcWelding createS1ArcWelding(S1ArcWeldingForm form, String month, Long loginId) {
//        S1ArcWelding welding = new S1ArcWelding();
//        welding.setMonth(month);
//        welding.setYear(form.getYear());
//
//        // Set fields based on the month
//        switch (month) {
//            case "Jan":
//                welding.setElectrodesPurchased(form.getJanElectrodesPurchased());
//                welding.setElectrodePurpose(form.getJanElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getJanOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getJanCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getJanElectrodesCost());
//                break;
//            case "Feb":
//                welding.setElectrodesPurchased(form.getFebElectrodesPurchased());
//                welding.setElectrodePurpose(form.getFebElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getFebOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getFebCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getFebElectrodesCost());
//                break;
//            case "Mar":
//                welding.setElectrodesPurchased(form.getMarElectrodesPurchased());
//                welding.setElectrodePurpose(form.getMarElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getMarOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getMarCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getMarElectrodesCost());
//                break;
//            case "Apr":
//                welding.setElectrodesPurchased(form.getAprElectrodesPurchased());
//                welding.setElectrodePurpose(form.getAprElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getAprOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getAprCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getAprElectrodesCost());
//                break;
//            case "May":
//                welding.setElectrodesPurchased(form.getMayElectrodesPurchased());
//                welding.setElectrodePurpose(form.getMayElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getMayOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getMayCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getMayElectrodesCost());
//                break;
//            case "Jun":
//                welding.setElectrodesPurchased(form.getJunElectrodesPurchased());
//                welding.setElectrodePurpose(form.getJunElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getJunOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getJunCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getJunElectrodesCost());
//                break;
//            case "Jul":
//                welding.setElectrodesPurchased(form.getJulElectrodesPurchased());
//                welding.setElectrodePurpose(form.getJulElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getJulOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getJulCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getJulElectrodesCost());
//                break;
//            case "Aug":
//                welding.setElectrodesPurchased(form.getAugElectrodesPurchased());
//                welding.setElectrodePurpose(form.getAugElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getAugOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getAugCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getAugElectrodesCost());
//                break;
//            case "Sep":
//                welding.setElectrodesPurchased(form.getSepElectrodesPurchased());
//                welding.setElectrodePurpose(form.getSepElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getSepOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getSepCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getSepElectrodesCost());
//                break;
//            case "Oct":
//                welding.setElectrodesPurchased(form.getOctElectrodesPurchased());
//                welding.setElectrodePurpose(form.getOctElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getOctOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getOctCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getOctElectrodesCost());
//                break;
//            case "Nov":
//                welding.setElectrodesPurchased(form.getNovElectrodesPurchased());
//                welding.setElectrodePurpose(form.getNovElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getNovOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getNovCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getNovElectrodesCost());
//                break;
//            case "Dec":
//                welding.setElectrodesPurchased(form.getDecElectrodesPurchased());
//                welding.setElectrodePurpose(form.getDecElectrodePurpose());
//                welding.setOpenCircuitVoltage(form.getDecOpenCircuitVoltage());
//                welding.setCloseCircuitVoltage(form.getDecCloseCircuitVoltage());
//                welding.setElectrodesCost(form.getDecElectrodesCost());
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid month: " + month);
//        }
//
//        // Set login
//        Login login = new Login(); // Replace with actual logic to fetch Login
//        login.setId(loginId);
//        welding.setLogin(login);
//
//        return welding;
//    }
//}
package com.tsl.service;

import com.tsl.pojo.S1ArcWelding;
import com.tsl.pojo.Login;
import com.tsl.dto.S1ArcWeldingForm;
import com.tsl.repository.S1ArcWeldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class S1ArcWeldingServiceImpl implements S1ArcWeldingService {

    @Autowired
    private S1ArcWeldingRepository repository;

    private static final Map<String, String> MONTH_MAPPER = new HashMap<>();
    static {
        MONTH_MAPPER.put("Apr", "April");
        MONTH_MAPPER.put("May", "May");
        MONTH_MAPPER.put("Jun", "June");
        MONTH_MAPPER.put("Jul", "July");
        MONTH_MAPPER.put("Aug", "August");
        MONTH_MAPPER.put("Sep", "September");
        MONTH_MAPPER.put("Oct", "October");
        MONTH_MAPPER.put("Nov", "November");
        MONTH_MAPPER.put("Dec", "December");
        MONTH_MAPPER.put("Jan", "January");
        MONTH_MAPPER.put("Feb", "February");
        MONTH_MAPPER.put("Mar", "March");
    }

    @Override
    public List<S1ArcWelding> getAllByLoginId(Long loginId) {
        return repository.findByLoginId(loginId);
    }

    @Override
    public List<S1ArcWelding> findByYearAndLoginId(String year, Long loginId) {
        return repository.findByYearAndLoginId(year, loginId);
    }

    @Override
    public S1ArcWelding saveOrUpdate(S1ArcWeldingForm form, Long loginId) {
        List<S1ArcWelding> weldings = List.of(
            createS1ArcWelding(form, "Apr", loginId),
            createS1ArcWelding(form, "May", loginId),
            createS1ArcWelding(form, "Jun", loginId),
            createS1ArcWelding(form, "Jul", loginId),
            createS1ArcWelding(form, "Aug", loginId),
            createS1ArcWelding(form, "Sep", loginId),
            createS1ArcWelding(form, "Oct", loginId),
            createS1ArcWelding(form, "Nov", loginId),
            createS1ArcWelding(form, "Dec", loginId),
            createS1ArcWelding(form, "Jan", loginId),
            createS1ArcWelding(form, "Feb", loginId),
            createS1ArcWelding(form, "Mar", loginId)
        );

        return repository.saveAll(weldings).stream().findFirst().orElse(null);
    }

    @Override
    public List<S1ArcWelding> updateS1ArcWeldingByLoginId(S1ArcWeldingForm form, Long loginId) {
        List<S1ArcWelding> weldings = repository.findByLoginId(loginId);

        for (S1ArcWelding welding : weldings) {
            String month = welding.getMonth();
            switch (month) {
                case "Apr":
                    welding.setElectrodesPurchased(form.getAprElectrodesPurchased());
                    welding.setElectrodePurpose(form.getAprElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getAprOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getAprCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getAprElectrodesCost());
                    break;
                case "May":
                    welding.setElectrodesPurchased(form.getMayElectrodesPurchased());
                    welding.setElectrodePurpose(form.getMayElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getMayOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getMayCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getMayElectrodesCost());
                    break;
                case "Jun":
                    welding.setElectrodesPurchased(form.getJunElectrodesPurchased());
                    welding.setElectrodePurpose(form.getJunElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getJunOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getJunCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getJunElectrodesCost());
                    break;
                case "Jul":
                    welding.setElectrodesPurchased(form.getJulElectrodesPurchased());
                    welding.setElectrodePurpose(form.getJulElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getJulOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getJulCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getJulElectrodesCost());
                    break;
                case "Aug":
                    welding.setElectrodesPurchased(form.getAugElectrodesPurchased());
                    welding.setElectrodePurpose(form.getAugElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getAugOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getAugCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getAugElectrodesCost());
                    break;
                case "Sep":
                    welding.setElectrodesPurchased(form.getSepElectrodesPurchased());
                    welding.setElectrodePurpose(form.getSepElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getSepOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getSepCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getSepElectrodesCost());
                    break;
                case "Oct":
                    welding.setElectrodesPurchased(form.getOctElectrodesPurchased());
                    welding.setElectrodePurpose(form.getOctElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getOctOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getOctCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getOctElectrodesCost());
                    break;
                case "Nov":
                    welding.setElectrodesPurchased(form.getNovElectrodesPurchased());
                    welding.setElectrodePurpose(form.getNovElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getNovOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getNovCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getNovElectrodesCost());
                    break;
                case "Dec":
                    welding.setElectrodesPurchased(form.getDecElectrodesPurchased());
                    welding.setElectrodePurpose(form.getDecElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getDecOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getDecCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getDecElectrodesCost());
                    break;
                case "Jan":
                    welding.setElectrodesPurchased(form.getJanElectrodesPurchased());
                    welding.setElectrodePurpose(form.getJanElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getJanOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getJanCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getJanElectrodesCost());
                    break;
                case "Feb":
                    welding.setElectrodesPurchased(form.getFebElectrodesPurchased());
                    welding.setElectrodePurpose(form.getFebElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getFebOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getFebCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getFebElectrodesCost());
                    break;
                case "Mar":
                    welding.setElectrodesPurchased(form.getMarElectrodesPurchased());
                    welding.setElectrodePurpose(form.getMarElectrodePurpose());
                    welding.setOpenCircuitVoltage(form.getMarOpenCircuitVoltage());
                    welding.setCloseCircuitVoltage(form.getMarCloseCircuitVoltage());
                    welding.setElectrodesCost(form.getMarElectrodesCost());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid month: " + month);
            }
            welding.setYear(form.getYear());
            Login login = new Login();
            login.setId(loginId);
            welding.setLogin(login);
        }

        return repository.saveAll(weldings);
    }

    private S1ArcWelding createS1ArcWelding(S1ArcWeldingForm form, String month, Long loginId) {
        S1ArcWelding welding = new S1ArcWelding();
        welding.setMonth(month);
        welding.setYear(form.getYear());

        switch (month) {
            case "Apr":
                welding.setElectrodesPurchased(form.getAprElectrodesPurchased());
                welding.setElectrodePurpose(form.getAprElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getAprOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getAprCloseCircuitVoltage());
                welding.setElectrodesCost(form.getAprElectrodesCost());
                break;
            case "May":
                welding.setElectrodesPurchased(form.getMayElectrodesPurchased());
                welding.setElectrodePurpose(form.getMayElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getMayOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getMayCloseCircuitVoltage());
                welding.setElectrodesCost(form.getMayElectrodesCost());
                break;
            case "Jun":
                welding.setElectrodesPurchased(form.getJunElectrodesPurchased());
                welding.setElectrodePurpose(form.getJunElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getJunOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getJunCloseCircuitVoltage());
                welding.setElectrodesCost(form.getJunElectrodesCost());
                break;
            case "Jul":
                welding.setElectrodesPurchased(form.getJulElectrodesPurchased());
                welding.setElectrodePurpose(form.getJulElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getJulOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getJulCloseCircuitVoltage());
                welding.setElectrodesCost(form.getJulElectrodesCost());
                break;
            case "Aug":
                welding.setElectrodesPurchased(form.getAugElectrodesPurchased());
                welding.setElectrodePurpose(form.getAugElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getAugOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getAugCloseCircuitVoltage());
                welding.setElectrodesCost(form.getAugElectrodesCost());
                break;
            case "Sep":
                welding.setElectrodesPurchased(form.getSepElectrodesPurchased());
                welding.setElectrodePurpose(form.getSepElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getSepOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getSepCloseCircuitVoltage());
                welding.setElectrodesCost(form.getSepElectrodesCost());
                break;
            case "Oct":
                welding.setElectrodesPurchased(form.getOctElectrodesPurchased());
                welding.setElectrodePurpose(form.getOctElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getOctOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getOctCloseCircuitVoltage());
                welding.setElectrodesCost(form.getOctElectrodesCost());
                break;
            case "Nov":
                welding.setElectrodesPurchased(form.getNovElectrodesPurchased());
                welding.setElectrodePurpose(form.getNovElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getNovOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getNovCloseCircuitVoltage());
                welding.setElectrodesCost(form.getNovElectrodesCost());
                break;
            case "Dec":
                welding.setElectrodesPurchased(form.getDecElectrodesPurchased());
                welding.setElectrodePurpose(form.getDecElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getDecOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getDecCloseCircuitVoltage());
                welding.setElectrodesCost(form.getDecElectrodesCost());
                break;
            case "Jan":
                welding.setElectrodesPurchased(form.getJanElectrodesPurchased());
                welding.setElectrodePurpose(form.getJanElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getJanOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getJanCloseCircuitVoltage());
                welding.setElectrodesCost(form.getJanElectrodesCost());
                break;
            case "Feb":
                welding.setElectrodesPurchased(form.getFebElectrodesPurchased());
                welding.setElectrodePurpose(form.getFebElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getFebOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getFebCloseCircuitVoltage());
                welding.setElectrodesCost(form.getFebElectrodesCost());
                break;
            case "Mar":
                welding.setElectrodesPurchased(form.getMarElectrodesPurchased());
                welding.setElectrodePurpose(form.getMarElectrodePurpose());
                welding.setOpenCircuitVoltage(form.getMarOpenCircuitVoltage());
                welding.setCloseCircuitVoltage(form.getMarCloseCircuitVoltage());
                welding.setElectrodesCost(form.getMarElectrodesCost());
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }

        Login login = new Login();
        login.setId(loginId);
        welding.setLogin(login);

        return welding;
    }
}
