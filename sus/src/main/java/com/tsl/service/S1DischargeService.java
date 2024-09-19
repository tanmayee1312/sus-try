package com.tsl.service;

import com.tsl.dto.S1DischargeForm;
import com.tsl.pojo.S1Discharge;

import java.util.List;

public interface S1DischargeService {
//    List<S1Discharge> getAllDischargeDataByLoginId(Long loginId);
//    void saveOrUpdateDischargeData(S1DischargeForm s1DischargeForm, Long loginId);
//	List<S1Discharge> getDischargeDataByLoginIdAndYear(Long loginId, String year);
//    void updateDischargeDataByLoginIdAndYear(S1DischargeForm s1DischargeForm, Long loginId, String year);
    void saveDischargeData(S1DischargeForm form);
    void updateDischargeData(Long loginId, String year, S1DischargeForm form);
    List<S1Discharge> findDischargesByLoginIdAndYear(Long loginId, String year);


}
