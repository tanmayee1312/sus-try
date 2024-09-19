package com.tsl.service;

import com.tsl.dto.S1CoalUsedForm;
import com.tsl.pojo.S1CoalUsed;

import java.util.List;

public interface S1CoalUsedService {
    List<S1CoalUsed> saveOrUpdate(S1CoalUsedForm form);
    List<S1CoalUsed> getCoalUsedByLoginIdAndYear(Long loginId, String year);
}
