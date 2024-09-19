package com.tsl.service;

import com.tsl.pojo.BusinessTravelRoad;
import com.tsl.pojo.Login;
import com.tsl.dto.BusinessTravelRoadDTO;
import com.tsl.form.BusinessTravelRoadForm;
import com.tsl.repository.BusinessTravelRoadRepository;
import com.tsl.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessTravelRoadServiceImpl implements BusinessTravelRoadService {

    @Autowired
    private BusinessTravelRoadRepository repository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    @Transactional
    public void saveBusinessTravelRoad(BusinessTravelRoadForm form) {
        List<BusinessTravelRoad> entities = form.getBusinessTravelRoads().stream()
            .map(dto -> createEntity(dto, form.getLoginId()))
            .collect(Collectors.toList());

        repository.saveAll(entities);
    }

    private BusinessTravelRoad createEntity(BusinessTravelRoadDTO dto, Long loginId) {
        BusinessTravelRoad entity = new BusinessTravelRoad();
        entity.setYear(dto.getYear());
        entity.setTypeOfVehicle(dto.getTypeOfVehicle());
        entity.setTypeOfFuel(dto.getTypeOfFuel());
        entity.setDistanceTravelledPerTrip(dto.getDistanceTravelledPerTrip());
        entity.setTrip(dto.getTrip());
        entity.setNumberOfPassengers(dto.getNumberOfPassengers());
        entity.setFare(dto.getFare());

        Login login = loginRepository.findById(loginId)
            .orElseThrow(() -> new RuntimeException("Login not found with ID: " + loginId));
        entity.setLogin(login);

        return entity;
    }

    @Override
    public List<BusinessTravelRoad> getBusinessTravelRoadByLoginId(Long loginId) {
        return repository.findByLoginId(loginId);
    }

    @Override
    public List<BusinessTravelRoad> getBusinessTravelRoadByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }
}
