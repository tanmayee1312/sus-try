package com.tsl.form;

import lombok.Data;
import java.util.List;
import com.tsl.dto.BusinessTravelRailDTO;

@Data
public class BusinessTravelRailForm {
    private Long loginId;
    private List<BusinessTravelRailDTO> businessTravelRails;
}
