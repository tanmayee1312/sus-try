package com.tsl.form;

import lombok.Data;
import java.util.List;
import com.tsl.dto.BusinessTravelAirDTO;

@Data
public class BusinessTravelAirForm {
    private Long loginId;
    private List<BusinessTravelAirDTO> businessTravelAirList;
}
