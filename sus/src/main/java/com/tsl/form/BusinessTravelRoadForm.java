package com.tsl.form;

import lombok.Data;
import com.tsl.dto.BusinessTravelRoadDTO;
import java.util.List;

@Data
public class BusinessTravelRoadForm {
    private Long loginId;
    private List<BusinessTravelRoadDTO> businessTravelRoads;
}
