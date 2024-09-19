package com.tsl.service;

import com.tsl.pojo.BusinessTravelRoad;
import com.tsl.form.BusinessTravelRoadForm;

import java.util.List;

public interface BusinessTravelRoadService {
    void saveBusinessTravelRoad(BusinessTravelRoadForm form);
    List<BusinessTravelRoad> getBusinessTravelRoadByLoginId(Long loginId);
    List<BusinessTravelRoad> getBusinessTravelRoadByLoginIdAndYear(Long loginId, String year);
}
