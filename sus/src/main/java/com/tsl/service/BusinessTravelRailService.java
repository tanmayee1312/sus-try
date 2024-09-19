package com.tsl.service;

import com.tsl.pojo.BusinessTravelRail;
import com.tsl.form.BusinessTravelRailForm;

import java.util.List;

public interface BusinessTravelRailService {
    void saveBusinessTravelRail(BusinessTravelRailForm form);
    List<BusinessTravelRail> getBusinessTravelRailByLoginId(Long loginId);
    List<BusinessTravelRail> getBusinessTravelRailByLoginIdAndYear(Long loginId, String year);
}
