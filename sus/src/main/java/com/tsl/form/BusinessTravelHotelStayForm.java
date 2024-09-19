package com.tsl.form;

import lombok.Data;
import java.util.List;
import com.tsl.dto.BusinessTravelHotelStayDTO;

@Data
public class BusinessTravelHotelStayForm {
    private Long loginId;
    private List<BusinessTravelHotelStayDTO> hotelStays;
}
