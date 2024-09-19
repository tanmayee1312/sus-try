package com.tsl.BRSR.service;

import com.tsl.BRSR.dto.BusinessActivityDTO;
import com.tsl.BRSR.repository.BusinessActivityRepository;
import com.tsl.pojo.BusinessActivity;
import com.tsl.pojo.Login;
import com.tsl.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessActivityService {

    @Autowired
    private BusinessActivityRepository businessActivityRepository;

    @Autowired
    private LoginRepository loginRepository;

    public List<BusinessActivityDTO> createBusinessActivities(List<BusinessActivityDTO> dtoList) {
        return dtoList.stream().map(dto -> {
            Login user = loginRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            BusinessActivity businessActivity = new BusinessActivity();
            businessActivity.setMainActivityDescription(dto.getMainActivityDescription());
            businessActivity.setBusinessActivityDescription(dto.getBusinessActivityDescription());
            businessActivity.setTotalRevenue(dto.getTotalRevenue());
            businessActivity.setRevenueFromMainActivity(dto.getRevenueFromMainActivity());
            businessActivity.setTurnoverPercentage(dto.getTurnoverPercentage());
            businessActivity.setYear(dto.getYear());
            businessActivity.setUser(user);

            BusinessActivity savedActivity = businessActivityRepository.save(businessActivity);
            dto.setId(savedActivity.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public List<BusinessActivityDTO> getBusinessActivitiesByUserId(Long userId) {
        return businessActivityRepository.findByUserId(userId).stream()
                .map(activity -> new BusinessActivityDTO(activity.getId(), activity.getMainActivityDescription(),
                        activity.getBusinessActivityDescription(), activity.getTotalRevenue(),
                        activity.getRevenueFromMainActivity(), activity.getTurnoverPercentage(),
                        activity.getYear(), activity.getUser().getId()))
                .collect(Collectors.toList());
    }

    public List<BusinessActivityDTO> getBusinessActivitiesByUserIdAndYear(Long userId, String year) {
        return businessActivityRepository.findByUserIdAndYear(userId, year).stream()
                .map(activity -> new BusinessActivityDTO(activity.getId(), activity.getMainActivityDescription(),
                        activity.getBusinessActivityDescription(), activity.getTotalRevenue(),
                        activity.getRevenueFromMainActivity(), activity.getTurnoverPercentage(),
                        activity.getYear(), activity.getUser().getId()))
                .collect(Collectors.toList());
    }

    public BusinessActivityDTO updateBusinessActivity(Long id, Long userId, BusinessActivityDTO dto) {
        BusinessActivity businessActivity = businessActivityRepository.findByIdAndUserId(id, userId);
        if (businessActivity == null) {
            throw new IllegalArgumentException("Business Activity not found with id: " + id + " and userId: " + userId);
        }

        businessActivity.setMainActivityDescription(dto.getMainActivityDescription());
        businessActivity.setBusinessActivityDescription(dto.getBusinessActivityDescription());
        businessActivity.setTotalRevenue(dto.getTotalRevenue());
        businessActivity.setRevenueFromMainActivity(dto.getRevenueFromMainActivity());
        businessActivity.setTurnoverPercentage(dto.getTurnoverPercentage());
        businessActivity.setYear(dto.getYear());

        BusinessActivity updatedActivity = businessActivityRepository.save(businessActivity);
        return new BusinessActivityDTO(updatedActivity.getId(), updatedActivity.getMainActivityDescription(),
                updatedActivity.getBusinessActivityDescription(), updatedActivity.getTotalRevenue(),
                updatedActivity.getRevenueFromMainActivity(), updatedActivity.getTurnoverPercentage(),
                updatedActivity.getYear(), updatedActivity.getUser().getId());
    }

    public BusinessActivityDTO getBusinessActivityByIdAndUserId(Long id, Long userId) {
        BusinessActivity businessActivity = businessActivityRepository.findByIdAndUserId(id, userId);
        if (businessActivity == null) {
            return null;
        }
        return new BusinessActivityDTO(businessActivity.getId(), businessActivity.getMainActivityDescription(),
                businessActivity.getBusinessActivityDescription(), businessActivity.getTotalRevenue(),
                businessActivity.getRevenueFromMainActivity(), businessActivity.getTurnoverPercentage(),
                businessActivity.getYear(), businessActivity.getUser().getId());
    }
}
