package com.tsl.service;

import com.tsl.pojo.BusinessTravelRail;
import com.tsl.pojo.Login;
import com.tsl.dto.BusinessTravelRailDTO;
import com.tsl.form.BusinessTravelRailForm;
import com.tsl.repository.BusinessTravelRailRepository;
import com.tsl.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessTravelRailServiceImpl implements BusinessTravelRailService {

    @Autowired
    private BusinessTravelRailRepository repository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    @Transactional
    public void saveBusinessTravelRail(BusinessTravelRailForm form) {
        List<BusinessTravelRail> entities = form.getBusinessTravelRails().stream()
            .map(dto -> createEntity(dto, form.getLoginId()))
            .collect(Collectors.toList());

        repository.saveAll(entities);
    }

    private BusinessTravelRail createEntity(BusinessTravelRailDTO dto, Long loginId) {
        BusinessTravelRail entity = new BusinessTravelRail();
        entity.setYear(dto.getYear());
        entity.setArrival(dto.getArrival());
        entity.setDeparture(dto.getDeparture());
        entity.setDistancePerTrip(dto.getDistancePerTrip());
        entity.setTrip(dto.getTrip());
        entity.setNumberOfPassengers(dto.getNumberOfPassengers());
        entity.setRailFare(dto.getRailFare());

        Login login = loginRepository.findById(loginId)
            .orElseThrow(() -> new RuntimeException("Login not found with ID: " + loginId));
        entity.setLogin(login);

        return entity;
    }

    @Override
    public List<BusinessTravelRail> getBusinessTravelRailByLoginId(Long loginId) {
        return repository.findByLoginId(loginId);
    }

    @Override
    public List<BusinessTravelRail> getBusinessTravelRailByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }
}
