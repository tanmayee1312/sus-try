package com.tsl.service;

import com.tsl.pojo.WasteGenerated;
import com.tsl.pojo.Login;
import com.tsl.dto.WasteGeneratedDTO;
import com.tsl.form.WasteGeneratedForm;
import com.tsl.repository.WasteGeneratedRepository;
import com.tsl.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WasteGeneratedServiceImpl implements WasteGeneratedService {

    @Autowired
    private WasteGeneratedRepository repository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    @Transactional
    public void saveWasteGenerated(WasteGeneratedForm form) {
        List<WasteGenerated> entities = form.getWasteGeneratedList().stream()
            .map(dto -> createEntity(dto, form.getLoginId()))
            .collect(Collectors.toList());

        repository.saveAll(entities);
    }

    private WasteGenerated createEntity(WasteGeneratedDTO dto, Long loginId) {
        WasteGenerated entity = new WasteGenerated();
        entity.setYear(dto.getYear());
        entity.setTypeOfWaste(dto.getTypeOfWaste());
        entity.setUnitOfMeasurement(dto.getUnitOfMeasurement());
        entity.setAnnualQuantity(dto.getAnnualQuantity());
        entity.setWasteDisposalMethod(dto.getWasteDisposalMethod());
        entity.setAmountSpentForWasteDisposal(dto.getAmountSpentForWasteDisposal());
        entity.setAmountReceived(dto.getAmountReceived());

        Login login = loginRepository.findById(loginId)
            .orElseThrow(() -> new RuntimeException("Login not found with ID: " + loginId));
        entity.setLogin(login);

        return entity;
    }

    @Override
    public List<WasteGenerated> getWasteGeneratedByLoginId(Long loginId) {
        return repository.findByLogin_Id(loginId);
    }

    @Override
    public List<WasteGenerated> getWasteGeneratedByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLogin_IdAndYear(loginId, year);
    }
}
