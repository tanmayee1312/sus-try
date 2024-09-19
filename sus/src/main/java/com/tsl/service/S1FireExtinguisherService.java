package com.tsl.service;

import java.util.List;

import com.tsl.form.S1FireExtinguisherForm;
import com.tsl.pojo.S1FireExtinguisher;

public interface S1FireExtinguisherService {
    List<S1FireExtinguisher> saveAll(S1FireExtinguisherForm form);
    List<S1FireExtinguisher> getByLoginId(Long loginId);
	S1FireExtinguisher getTotalByLoginId(Long loginId);
    List<S1FireExtinguisher> findByLoginIdAndYear(Long loginId, String year);

}
