package com.tsl.service;

import com.tsl.pojo.WasteGenerated;
import com.tsl.form.WasteGeneratedForm;

import java.util.List;

public interface WasteGeneratedService {
    void saveWasteGenerated(WasteGeneratedForm form);
    List<WasteGenerated> getWasteGeneratedByLoginId(Long loginId);
    List<WasteGenerated> getWasteGeneratedByLoginIdAndYear(Long loginId, String year);
}
