package com.tsl.service;

import com.tsl.pojo.BusinessTravelHotelStay;
import com.tsl.pojo.Login;
import com.tsl.dto.BusinessTravelHotelStayDTO;
import com.tsl.form.BusinessTravelHotelStayForm;
import com.tsl.repository.BusinessTravelHotelStayRepository;
import com.tsl.repository.LoginRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//@Service
//public class BusinessTravelHotelStayServiceImpl implements BusinessTravelHotelStayService {
//
//    @Autowired
//    private BusinessTravelHotelStayRepository repository;
//
//    @Autowired
//    private LoginRepository loginRepository;
//
//    @Override
//    @Transactional
//    public void saveBusinessTravelHotelStays(BusinessTravelHotelStayForm form) {
//        List<BusinessTravelHotelStay> entities = form.getHotelStays().stream()
//            .map(dto -> createEntity(dto, form.getLoginId()))
//            .collect(Collectors.toList());
//
//        repository.saveAll(entities);
//    }
//
//    private BusinessTravelHotelStay createEntity(BusinessTravelHotelStayDTO dto, Long loginId) {
//        BusinessTravelHotelStay entity = new BusinessTravelHotelStay();
//        entity.setYear(dto.getYear());
//        entity.setNumberOfRoomsOccupied(dto.getNumberOfRoomsOccupied());
//        entity.setNumberOfNights(dto.getNumberOfNights());
//        entity.setLocationOfHotel(dto.getLocationOfHotel());
//        entity.setCost(dto.getCost());
//
//        Login login = loginRepository.findById(loginId)
//            .orElseThrow(() -> new RuntimeException("Login not found with ID: " + loginId));
//        entity.setLogin(login);
//
//        return entity;
//    }
//
//    @Override
//    public List<BusinessTravelHotelStay> getBusinessTravelHotelStaysByLoginId(Long loginId) {
//        return repository.findByLoginId(loginId);
//    }
//
//    @Override
//    public List<BusinessTravelHotelStay> getBusinessTravelHotelStaysByLoginIdAndYear(Long loginId, String year) {
//        return repository.findByLoginIdAndYear(loginId, year);
//    }
//}
@Service
public class BusinessTravelHotelStayServiceImpl implements BusinessTravelHotelStayService {

    @Autowired
    private BusinessTravelHotelStayRepository repository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void saveBusinessTravelHotelStays(BusinessTravelHotelStayForm form) {
        List<BusinessTravelHotelStay> entities = form.getHotelStays().stream()
            .map(dto -> createEntity(dto, form.getLoginId()))
            .collect(Collectors.toList());

        repository.saveAll(entities);
    }

    private BusinessTravelHotelStay createEntity(BusinessTravelHotelStayDTO dto, Long loginId) {
        BusinessTravelHotelStay entity = modelMapper.map(dto, BusinessTravelHotelStay.class);

        Login login = loginRepository.findById(loginId)
            .orElseThrow(() -> new RuntimeException("Login not found with ID: " + loginId));
        entity.setLogin(login);

        return entity;
    }

    @Override
    public List<BusinessTravelHotelStay> getBusinessTravelHotelStaysByLoginId(Long loginId) {
        return repository.findByLoginId(loginId);
    }

    @Override
    public List<BusinessTravelHotelStay> getBusinessTravelHotelStaysByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }
}
