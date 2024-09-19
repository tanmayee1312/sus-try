package com.tsl.service;

import com.tsl.dto.S1SpentWashForm;
import com.tsl.pojo.S1SpentWash;

import java.util.List;

public interface S1SpentWashService {
    List<S1SpentWash> saveOrUpdate(S1SpentWashForm form, Long loginId);
    List<S1SpentWash> getByLoginId(Long loginId);
    List<S1SpentWash> getByLoginIdAndYear(Long loginId, String year);
}
