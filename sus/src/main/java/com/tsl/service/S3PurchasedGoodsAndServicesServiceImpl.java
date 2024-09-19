package com.tsl.service;

import com.tsl.pojo.S3PurchasedGoodsAndServices;
import com.tsl.pojo.Login;
import com.tsl.dto.S3PurchasedGoodsAndServicesDTO;
import com.tsl.form.S3PurchasedGoodsAndServicesForm;
import com.tsl.repository.S3PurchasedGoodsAndServicesRepository;
import com.tsl.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class S3PurchasedGoodsAndServicesServiceImpl implements S3PurchasedGoodsAndServicesService {

    @Autowired
    private S3PurchasedGoodsAndServicesRepository repository;

    @Autowired
    private LoginRepository loginRepository;

    @Override
    @Transactional
    public void saveS3PurchasedGoodsAndServices(S3PurchasedGoodsAndServicesForm form) {
        List<S3PurchasedGoodsAndServices> entities = form.getPurchasedGoodsAndServices().stream()
            .map(dto -> createEntity(dto, form.getLoginId()))
            .collect(Collectors.toList());

        repository.saveAll(entities);
    }

    private S3PurchasedGoodsAndServices createEntity(S3PurchasedGoodsAndServicesDTO dto, Long loginId) {
        S3PurchasedGoodsAndServices entity = new S3PurchasedGoodsAndServices();
        entity.setNameOfGoodsServices(dto.getNameOfGoodsServices());
        entity.setYear(dto.getYear());
        entity.setClassificationOfGoodsServices(dto.getClassificationOfGoodsServices());
        entity.setQuantityUnitPurchasedAnnually(dto.getQuantityUnitPurchasedAnnually());
        entity.setUnitOfMeasurement(dto.getUnitOfMeasurement());

        Login login = loginRepository.findById(loginId)
            .orElseThrow(() -> new RuntimeException("Login not found with ID: " + loginId));
        entity.setLogin(login);

        return entity;
    }

    @Override
    public List<S3PurchasedGoodsAndServices> getS3PurchasedGoodsAndServicesByLoginId(Long loginId) {
        return repository.findByLoginId(loginId);
    }

    @Override
    public List<S3PurchasedGoodsAndServices> getS3PurchasedGoodsAndServicesByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }
}
