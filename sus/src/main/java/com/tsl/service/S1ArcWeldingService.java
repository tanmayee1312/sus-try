package com.tsl.service;

import com.tsl.pojo.S1ArcWelding;
import com.tsl.dto.S1ArcWeldingForm;

import java.util.List;

public interface S1ArcWeldingService {
    List<S1ArcWelding> getAllByLoginId(Long loginId);
    S1ArcWelding saveOrUpdate(S1ArcWeldingForm form, Long loginId);
    List<S1ArcWelding> updateS1ArcWeldingByLoginId(S1ArcWeldingForm form, Long loginId);
    List<S1ArcWelding> findByYearAndLoginId(String year, Long loginId);
}
