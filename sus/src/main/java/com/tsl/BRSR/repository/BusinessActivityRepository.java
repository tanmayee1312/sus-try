package com.tsl.BRSR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsl.pojo.BusinessActivity;

@Repository
public interface BusinessActivityRepository extends JpaRepository<BusinessActivity, Long> {
	 List<BusinessActivity> findByUserId(Long userId);

	    List<BusinessActivity> findByUserIdAndYear(Long userId, String year);

	    BusinessActivity findByIdAndUserId(Long id, Long userId);
}
