package com.tsl.service;

import com.tsl.dto.S1SpentWashForm;
import com.tsl.pojo.S1SpentWash;
import com.tsl.repository.S1SpentWashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S1SpentWashServiceImpl implements S1SpentWashService {

    @Autowired
    private S1SpentWashRepository s1SpentWashRepository;

    @Override
    public List<S1SpentWash> saveOrUpdate(S1SpentWashForm form, Long loginId) {
        List<S1SpentWash> spentWashList = new ArrayList<>();
        spentWashList.add(form.toS1SpentWash("Apr", form.getAprSpentWashGenerated(), form.getAprSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("May", form.getMaySpentWashGenerated(), form.getMaySpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Jun", form.getJunSpentWashGenerated(), form.getJunSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Jul", form.getJulSpentWashGenerated(), form.getJulSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Aug", form.getAugSpentWashGenerated(), form.getAugSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Sep", form.getSepSpentWashGenerated(), form.getSepSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Oct", form.getOctSpentWashGenerated(), form.getOctSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Nov", form.getNovSpentWashGenerated(), form.getNovSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Dec", form.getDecSpentWashGenerated(), form.getDecSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Jan", form.getJanSpentWashGenerated(), form.getJanSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Feb", form.getFebSpentWashGenerated(), form.getFebSpentWashUsedInComposting(), loginId));
        spentWashList.add(form.toS1SpentWash("Mar", form.getMarSpentWashGenerated(), form.getMarSpentWashUsedInComposting(), loginId));
        
        return s1SpentWashRepository.saveAll(spentWashList);
    }

    @Override
    public List<S1SpentWash> getByLoginId(Long loginId) {
        return s1SpentWashRepository.findByLoginId(loginId);
    }

    @Override
    public List<S1SpentWash> getByLoginIdAndYear(Long loginId, String year) {
        return s1SpentWashRepository.findByLoginIdAndYear(loginId, year);
    }
}
