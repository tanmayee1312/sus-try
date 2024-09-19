package com.tsl.service;

import com.tsl.pojo.BusinessTravelHotelStay;
import com.tsl.form.BusinessTravelHotelStayForm;

import java.util.List;

public interface BusinessTravelHotelStayService {
    void saveBusinessTravelHotelStays(BusinessTravelHotelStayForm form);
    List<BusinessTravelHotelStay> getBusinessTravelHotelStaysByLoginId(Long loginId);
    List<BusinessTravelHotelStay> getBusinessTravelHotelStaysByLoginIdAndYear(Long loginId, String year);
}
