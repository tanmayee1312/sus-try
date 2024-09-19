package com.tsl.service;

import com.tsl.pojo.BusinessTravelAir;
import com.tsl.pojo.Login;
import com.tsl.dto.BusinessTravelAirDTO;
import com.tsl.form.BusinessTravelAirForm;
import com.tsl.repository.BusinessTravelAirRepository;
import com.tsl.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessTravelAirServiceImpl implements BusinessTravelAirService {

    @Autowired
    private BusinessTravelAirRepository repository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    @Transactional
    public void saveBusinessTravelAir(BusinessTravelAirForm form) {
        List<BusinessTravelAir> entities = form.getBusinessTravelAirList().stream()
            .map(dto -> createEntity(dto, form.getLoginId()))
            .collect(Collectors.toList());

        repository.saveAll(entities);
    }

    private BusinessTravelAir createEntity(BusinessTravelAirDTO dto, Long loginId) {
        BusinessTravelAir entity = new BusinessTravelAir();
        entity.setYear(dto.getYear());
        entity.setArrival(dto.getArrival());
        entity.setDeparture(dto.getDeparture());
        entity.setTravelClass(dto.getTravelClass());
        entity.setTrip(dto.getTrip());
        entity.setNumberOfPassengers(dto.getNumberOfPassengers());
        entity.setAirFare(dto.getAirFare());

        Login login = loginRepository.findById(loginId)
            .orElseThrow(() -> new RuntimeException("Login not found with ID: " + loginId));
        entity.setLogin(login);

        return entity;
    }

    @Override
    public List<BusinessTravelAir> getBusinessTravelAirByLoginId(Long loginId) {
        return repository.findByLoginId(loginId);
    }

    @Override
    public List<BusinessTravelAir> getBusinessTravelAirByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }
}
