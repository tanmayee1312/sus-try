package com.tsl.form;

import lombok.Data;
import java.util.List;
import com.tsl.dto.EmployeeCommuteDTO;

@Data
public class EmployeeCommuteForm {
    private Long loginId;
    private List<EmployeeCommuteDTO> employeeCommutes;
}