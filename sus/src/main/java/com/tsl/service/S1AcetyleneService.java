package com.tsl.service;

import com.tsl.dto.S1AcetyleneForm;
import com.tsl.pojo.S1Acetylene;

import java.util.List;

public interface S1AcetyleneService {
    void saveS1Acetylene(S1AcetyleneForm form);
    
    List<S1Acetylene> getS1AcetyleneByLoginIdAndYear(Long loginId, String year);
    
    // Added for batch update
    void updateS1Acetylene(S1AcetyleneForm form, Long loginId, String year);

	void saveOrUpdateS1Acetylene(S1AcetyleneForm form);

}
