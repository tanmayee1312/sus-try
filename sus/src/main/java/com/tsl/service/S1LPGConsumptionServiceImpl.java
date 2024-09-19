package com.tsl.service;
//import com.tsl.pojo.Login;
//import com.tsl.pojo.S1CompanyOwnedVehicles;
//import com.tsl.dto.S1CompanyOwnedVehiclesForm;
//import com.tsl.repository.S1CompanyOwnedVehiclesRepository;
//import com.tsl.service.S1CompanyOwnedVehiclesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Service
//public class S1CompanyOwnedVehiclesServiceImpl implements S1CompanyOwnedVehiclesService {
//
//    @Autowired
//    private S1CompanyOwnedVehiclesRepository repository;
//
//    @Override
//    public List<S1CompanyOwnedVehicles> createOrUpdateS1CompanyOwnedVehicles(S1CompanyOwnedVehiclesForm form, Long loginId) {
//        List<S1CompanyOwnedVehicles> vehicles = convertFormToEntities(form, loginId);
//        return repository.saveAll(vehicles);
//    }
//
//    @Override
//    public List<S1CompanyOwnedVehicles> getAllS1CompanyOwnedVehicles(Long loginId) {
//        return repository.findAll().stream()
//                .filter(v -> v.getLogin() != null && v.getLogin().getId().equals(loginId))
//                .collect(Collectors.toList());
//    }
//
//    private List<S1CompanyOwnedVehicles> convertFormToEntities(S1CompanyOwnedVehiclesForm form, Long loginId) {
//        return IntStream.range(0, 12)
//                .mapToObj(i -> {
//                    String month = getMonthByIndex(i);
//                    return createS1CompanyOwnedVehicles(form, month, loginId);
//                })
//                .collect(Collectors.toList());
//    }
//
//    private S1CompanyOwnedVehicles createS1CompanyOwnedVehicles(S1CompanyOwnedVehiclesForm form, String month, Long loginId) {
//        S1CompanyOwnedVehicles vehicle = new S1CompanyOwnedVehicles();
//        vehicle.setMonth(month);
//        vehicle.setYear(form.getYear());
//        vehicle.setConsumption(getFieldByMonth(form, month + "Consumption"));
//        vehicle.setCylindersPurchased(getFieldByMonth(form, month + "CylindersPurchased"));
//        vehicle.setCylinderCapacity(getFieldByMonth(form, month + "CylinderCapacity"));
//        
//        // Set login
//        Login login = new Login(); // Replace with actual logic to fetch Login
//        login.setId(loginId);
//        vehicle.setLogin(login);
//        
//        return vehicle;
//    }
//
//    private double getFieldByMonth(S1CompanyOwnedVehiclesForm form, String fieldName) {
//        // Use reflection or a switch-case to get field value based on fieldName
//        // For simplicity, assuming you have getters in the form
//        switch (fieldName) {
//            case "aprConsumption": return form.getAprConsumption();
//            case "aprCylindersPurchased": return form.getAprCylindersPurchased();
//            case "aprCylinderCapacity": return form.getAprCylinderCapacity();
//            // Add cases for other months
//            default: return 0;
//        }
//    }
//
//    private String getMonthByIndex(int index) {
//        return switch (index) {
//            case 0 -> "Jan";
//            case 1 -> "Feb";
//            case 2 -> "Mar";
//            case 3 -> "Apr";
//            case 4 -> "May";
//            case 5 -> "Jun";
//            case 6 -> "Jul";
//            case 7 -> "Aug";
//            case 8 -> "Sep";
//            case 9 -> "Oct";
//            case 10 -> "Nov";
//            case 11 -> "Dec";
//            default -> "";
//        };
//    }
//}


//import com.tsl.pojo.Login;
//import com.tsl.pojo.S1CompanyOwnedVehicles;
//import com.tsl.dto.S1CompanyOwnedVehiclesForm;
//import com.tsl.repository.S1CompanyOwnedVehiclesRepository;
//import com.tsl.service.S1CompanyOwnedVehiclesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class S1CompanyOwnedVehiclesServiceImpl implements S1CompanyOwnedVehiclesService {
//
//    @Autowired
//    private S1CompanyOwnedVehiclesRepository repository;
//
//    @Override
//    public List<S1CompanyOwnedVehicles> createOrUpdateS1CompanyOwnedVehicles(S1CompanyOwnedVehiclesForm form, Long loginId) {
//        List<S1CompanyOwnedVehicles> vehicles = new ArrayList<>();
//
//        // Creating entities for each month
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Jan", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Feb", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Mar", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Apr", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "May", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Jun", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Jul", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Aug", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Sep", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Oct", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Nov", loginId));
//        vehicles.add(createS1CompanyOwnedVehicles(form, "Dec", loginId));
//
//        // Save all entities to the database
//        return repository.saveAll(vehicles);
//    }
//
//    @Override
//    public List<S1CompanyOwnedVehicles> getAllS1CompanyOwnedVehicles(Long loginId) {
//        // Retrieve all entities and filter by loginId
//        return repository.findAll().stream()
//                .filter(vehicle -> vehicle.getLogin() != null && vehicle.getLogin().getId().equals(loginId))
//                .toList();
//    }
//
//
//    private S1CompanyOwnedVehicles createS1CompanyOwnedVehicles(S1CompanyOwnedVehiclesForm form, String month, Long loginId) {
//        S1CompanyOwnedVehicles vehicle = new S1CompanyOwnedVehicles();
//        vehicle.setMonth(month);
//        vehicle.setYear(form.getYear());
//
//        // Set fields based on the month
//        switch (month) {
//            case "Jan":
//                vehicle.setConsumption(form.getJanConsumption());
//                vehicle.setCylindersPurchased(form.getJanCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getJanCylinderCapacity());
//                break;
//            case "Feb":
//                vehicle.setConsumption(form.getFebConsumption());
//                vehicle.setCylindersPurchased(form.getFebCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getFebCylinderCapacity());
//                break;
//            case "Mar":
//                vehicle.setConsumption(form.getMarConsumption());
//                vehicle.setCylindersPurchased(form.getMarCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getMarCylinderCapacity());
//                break;
//            case "Apr":
//                vehicle.setConsumption(form.getAprConsumption());
//                vehicle.setCylindersPurchased(form.getAprCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getAprCylinderCapacity());
//                break;
//            case "May":
//                vehicle.setConsumption(form.getMayConsumption());
//                vehicle.setCylindersPurchased(form.getMayCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getMayCylinderCapacity());
//                break;
//            case "Jun":
//                vehicle.setConsumption(form.getJunConsumption());
//                vehicle.setCylindersPurchased(form.getJunCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getJunCylinderCapacity());
//                break;
//            case "Jul":
//                vehicle.setConsumption(form.getJulConsumption());
//                vehicle.setCylindersPurchased(form.getJulCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getJulCylinderCapacity());
//                break;
//            case "Aug":
//                vehicle.setConsumption(form.getAugConsumption());
//                vehicle.setCylindersPurchased(form.getAugCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getAugCylinderCapacity());
//                break;
//            case "Sep":
//                vehicle.setConsumption(form.getSepConsumption());
//                vehicle.setCylindersPurchased(form.getSepCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getSepCylinderCapacity());
//                break;
//            case "Oct":
//                vehicle.setConsumption(form.getOctConsumption());
//                vehicle.setCylindersPurchased(form.getOctCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getOctCylinderCapacity());
//                break;
//            case "Nov":
//                vehicle.setConsumption(form.getNovConsumption());
//                vehicle.setCylindersPurchased(form.getNovCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getNovCylinderCapacity());
//                break;
//            case "Dec":
//                vehicle.setConsumption(form.getDecConsumption());
//                vehicle.setCylindersPurchased(form.getDecCylindersPurchased());
//                vehicle.setCylinderCapacity(form.getDecCylinderCapacity());
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid month: " + month);
//        }
//
//        // Set login
//        Login login = new Login(); // Replace with actual logic to fetch Login
//        login.setId(loginId);
//        vehicle.setLogin(login);
//
//        return vehicle;
//    }
//}



import com.tsl.pojo.S1LPGConsumption;
import com.tsl.dto.S1LPGConsumptionForm;
import com.tsl.repository.S1LPGConsumptionRepository;
import com.tsl.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/*
@Service
public class S1LPGConsumptionServiceImpl implements S1LPGConsumptionService {

    @Autowired
    private S1LPGConsumptionRepository repository;

    @Override
    public List<S1LPGConsumption> createOrUpdateS1CompanyOwnedVehicles(S1LPGConsumptionForm form, Long loginId) {
        List<S1LPGConsumption> vehicles = new ArrayList<>();

        // Creating entities for each month starting from April
        vehicles.add(createS1CompanyOwnedVehicles(form, "Apr", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "May", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Jun", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Jul", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Aug", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Sep", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Oct", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Nov", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Dec", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Jan", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Feb", loginId));
        vehicles.add(createS1CompanyOwnedVehicles(form, "Mar", loginId));

        return repository.saveAll(vehicles);
    }


    @Override
    public List<S1LPGConsumption> getAllS1CompanyOwnedVehicles(Long loginId) {
        // Retrieve all entities and filter by loginId
        return repository.findAll().stream()
                .filter(vehicle -> vehicle.getLogin() != null && vehicle.getLogin().getId().equals(loginId))
                .toList();
    }

    @Override
    public List<S1LPGConsumption> getS1CompanyOwnedVehiclesByYear(Long loginId, String year) {
        // Fetch data based on loginId and year
        return repository.findByLoginIdAndYear(loginId, year);
    }

    private S1LPGConsumption createS1CompanyOwnedVehicles(S1LPGConsumptionForm form, String month, Long loginId) {
        S1LPGConsumption vehicle = new S1LPGConsumption();
        vehicle.setMonth(month);
        vehicle.setYear(form.getYear());

        // Set fields based on the month
        switch (month) {
            case "Jan":
                vehicle.setConsumption(form.getJanConsumption());
                vehicle.setCylindersPurchased(form.getJanCylindersPurchased());
                vehicle.setCylinderCapacity(form.getJanCylinderCapacity());
                break;
            case "Feb":
                vehicle.setConsumption(form.getFebConsumption());
                vehicle.setCylindersPurchased(form.getFebCylindersPurchased());
                vehicle.setCylinderCapacity(form.getFebCylinderCapacity());
                break;
            case "Mar":
                vehicle.setConsumption(form.getMarConsumption());
                vehicle.setCylindersPurchased(form.getMarCylindersPurchased());
                vehicle.setCylinderCapacity(form.getMarCylinderCapacity());
                break;
            case "Apr":
                vehicle.setConsumption(form.getAprConsumption());
                vehicle.setCylindersPurchased(form.getAprCylindersPurchased());
                vehicle.setCylinderCapacity(form.getAprCylinderCapacity());
                break;
            case "May":
                vehicle.setConsumption(form.getMayConsumption());
                vehicle.setCylindersPurchased(form.getMayCylindersPurchased());
                vehicle.setCylinderCapacity(form.getMayCylinderCapacity());
                break;
            case "Jun":
                vehicle.setConsumption(form.getJunConsumption());
                vehicle.setCylindersPurchased(form.getJunCylindersPurchased());
                vehicle.setCylinderCapacity(form.getJunCylinderCapacity());
                break;
            case "Jul":
                vehicle.setConsumption(form.getJulConsumption());
                vehicle.setCylindersPurchased(form.getJulCylindersPurchased());
                vehicle.setCylinderCapacity(form.getJulCylinderCapacity());
                break;
            case "Aug":
                vehicle.setConsumption(form.getAugConsumption());
                vehicle.setCylindersPurchased(form.getAugCylindersPurchased());
                vehicle.setCylinderCapacity(form.getAugCylinderCapacity());
                break;
            case "Sep":
                vehicle.setConsumption(form.getSepConsumption());
                vehicle.setCylindersPurchased(form.getSepCylindersPurchased());
                vehicle.setCylinderCapacity(form.getSepCylinderCapacity());
                break;
            case "Oct":
                vehicle.setConsumption(form.getOctConsumption());
                vehicle.setCylindersPurchased(form.getOctCylindersPurchased());
                vehicle.setCylinderCapacity(form.getOctCylinderCapacity());
                break;
            case "Nov":
                vehicle.setConsumption(form.getNovConsumption());
                vehicle.setCylindersPurchased(form.getNovCylindersPurchased());
                vehicle.setCylinderCapacity(form.getNovCylinderCapacity());
                break;
            case "Dec":
                vehicle.setConsumption(form.getDecConsumption());
                vehicle.setCylindersPurchased(form.getDecCylindersPurchased());
                vehicle.setCylinderCapacity(form.getDecCylinderCapacity());
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }

        // Set login
        Login login = new Login(); // Replace with actual logic to fetch Login
        login.setId(loginId);
        vehicle.setLogin(login);

        return vehicle;
    }
}
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/*
@Service
public class S1LPGConsumptionServiceImpl implements S1LPGConsumptionService {

    @Autowired
    private S1LPGConsumptionRepository lpgConsumptionRepository;

    // Save a single LPG consumption entry
    @Override
    public S1LPGConsumption saveLPGConsumption(S1LPGConsumption lpgConsumption) {
        return lpgConsumptionRepository.save(lpgConsumption);
    }

    // Retrieve all consumption data for a given year and loginId
    @Override
    public List<S1LPGConsumption> getLPGConsumptionByYearAndLoginId(String year, Long loginId) {
        return lpgConsumptionRepository.findByYearAndLoginId(year, loginId);
    }

    // Update existing LPG consumption records
    @Override
    @Transactional
    public void updateLPGConsumption(List<S1LPGConsumption> lpgConsumptionList) {
        for (S1LPGConsumption lpgConsumption : lpgConsumptionList) {
            S1LPGConsumption existingRecord = lpgConsumptionRepository
                .findByMonthAndYearAndLoginId(lpgConsumption.getMonth(), lpgConsumption.getYear(), lpgConsumption.getLogin().getId())
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Record not found"));

            existingRecord.setConsumption(lpgConsumption.getConsumption());
            existingRecord.setCylindersPurchased(lpgConsumption.getCylindersPurchased());
            existingRecord.setCylinderCapacity(lpgConsumption.getCylinderCapacity());
            existingRecord.setConsumptionUOM(lpgConsumption.getConsumptionUOM());
            existingRecord.setCylinderCapacityUOM(lpgConsumption.getCylinderCapacityUOM());
            existingRecord.setCo2Emission(lpgConsumption.getCo2Emission());

            lpgConsumptionRepository.save(existingRecord);
        }
    }

    // Get LPG consumption data for a specific month, year, and loginId
    @Override
    public S1LPGConsumption getLPGConsumptionByMonthAndYearAndLoginId(String month, String year, Long loginId) {
        return lpgConsumptionRepository
                .findByMonthAndYearAndLoginId(month, year, loginId)
                .stream()
                .findFirst()
                .orElse(null);
    }

	@Override
	public List<S1LPGConsumption> getLPGConsumptionByYearAndLoginId(Long loginId, String year) {
		// TODO Auto-generated method stub
		return null;
	}
}
*/


@Service
public class S1LPGConsumptionServiceImpl implements S1LPGConsumptionService {

    @Autowired
    private S1LPGConsumptionRepository lpgConsumptionRepository;

    // Save a single LPG consumption entry
    @Override
    public S1LPGConsumption saveLPGConsumption(S1LPGConsumption lpgConsumption) {
        return lpgConsumptionRepository.save(lpgConsumption);
    }


    @Override
    public List<S1LPGConsumption> getLPGConsumptionByYearAndLoginId(Long loginId, String year) {
        return lpgConsumptionRepository.findByLoginIdAndYear(loginId, year);
    }
}

