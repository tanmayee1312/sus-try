package com.tsl.service;
import com.tsl.pojo.Login;
import com.tsl.pojo.EmployeeCommute;
import com.tsl.form.EmployeeCommuteForm;
import com.tsl.repository.EmployeeCommuteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeCommuteServiceImpl implements EmployeeCommuteService {

    @Autowired
    private EmployeeCommuteRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeCommute> saveOrUpdateEmployeeCommutes(EmployeeCommuteForm form) {
        Long loginId = form.getLoginId();
        List<EmployeeCommute> commutes = form.getEmployeeCommutes().stream()
            .map(dto -> {
                EmployeeCommute commute = modelMapper.map(dto, EmployeeCommute.class);
                Login login = new Login(); 
                login.setId(loginId);
                commute.setLogin(login);
                return commute;
            })
            .collect(Collectors.toList());
        return repository.saveAll(commutes);
    }

    @Override
    public List<EmployeeCommute> getEmployeeCommutesByLoginId(Long loginId) {
        return repository.findByLoginId(loginId);
    }

    @Override
    public List<EmployeeCommute> getEmployeeCommutesByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }
}
