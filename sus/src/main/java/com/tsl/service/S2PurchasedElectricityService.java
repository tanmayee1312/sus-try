package com.tsl.service;

import com.tsl.pojo.S2PurchasedElectricity;
import com.tsl.dto.S2PurchasedElectricityForm;
import java.util.List;

public interface S2PurchasedElectricityService {
    void saveS2PurchasedElectricity(S2PurchasedElectricityForm form);
    List<S2PurchasedElectricity> getS2PurchasedElectricityByLoginIdAndYear(Long loginId, String year);
}
