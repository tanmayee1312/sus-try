package com.tsl.service;

import com.tsl.pojo.BusinessTravelAir;
import com.tsl.form.BusinessTravelAirForm;
import java.util.List;

public interface BusinessTravelAirService {
    void saveBusinessTravelAir(BusinessTravelAirForm form);
    List<BusinessTravelAir> getBusinessTravelAirByLoginId(Long loginId);
    List<BusinessTravelAir> getBusinessTravelAirByLoginIdAndYear(Long loginId, String year);
}
