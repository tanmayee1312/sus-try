package com.tsl.form;

import lombok.Data;
import java.util.List;

import com.tsl.dto.S1CompanyOwnedVehicleDTO;

@Data
public class S1CompanyOwnedVehicleForm {
    private Long loginId;
    private List<S1CompanyOwnedVehicleDTO> companyOwnedVehicles;
}
