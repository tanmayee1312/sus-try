package com.tsl.service;

import com.tsl.pojo.EmployeeCommute;
import com.tsl.form.EmployeeCommuteForm;

import java.util.List;

public interface EmployeeCommuteService {
    List<EmployeeCommute> saveOrUpdateEmployeeCommutes(EmployeeCommuteForm form);
    List<EmployeeCommute> getEmployeeCommutesByLoginId(Long loginId);
    List<EmployeeCommute> getEmployeeCommutesByLoginIdAndYear(Long loginId, String year);
}