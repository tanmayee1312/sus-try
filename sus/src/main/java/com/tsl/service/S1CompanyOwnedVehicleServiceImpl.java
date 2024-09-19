package com.tsl.service;

import com.tsl.form.S1CompanyOwnedVehicleForm;
import com.tsl.pojo.S1CompanyOwnedVehicle;
import com.tsl.pojo.Login;
import com.tsl.repository.S1CompanyOwnedVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class S1CompanyOwnedVehicleServiceImpl implements S1CompanyOwnedVehicleService {

    @Autowired
    private S1CompanyOwnedVehicleRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<S1CompanyOwnedVehicle> saveOrUpdateCompanyOwnedVehicles(S1CompanyOwnedVehicleForm form) {
        Login login = new Login();
        login.setId(form.getLoginId());

        List<S1CompanyOwnedVehicle> vehicles = form.getCompanyOwnedVehicles().stream()
            .map(dto -> {
                S1CompanyOwnedVehicle vehicle = modelMapper.map(dto, S1CompanyOwnedVehicle.class);
                vehicle.setLogin(login); 
                return vehicle;
            })
            .collect(Collectors.toList());

        return repository.saveAll(vehicles);
    }
    
    @Override
    public List<S1CompanyOwnedVehicle> getCompanyOwnedVehiclesByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }

}
