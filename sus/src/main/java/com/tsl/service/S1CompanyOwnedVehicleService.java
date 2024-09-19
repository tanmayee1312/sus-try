package com.tsl.service;

import com.tsl.form.S1CompanyOwnedVehicleForm;
import com.tsl.pojo.S1CompanyOwnedVehicle;

import java.util.List;

public interface S1CompanyOwnedVehicleService {
    List<S1CompanyOwnedVehicle> saveOrUpdateCompanyOwnedVehicles(S1CompanyOwnedVehicleForm form);
    List<S1CompanyOwnedVehicle> getCompanyOwnedVehiclesByLoginIdAndYear(Long loginId, String year);

}
