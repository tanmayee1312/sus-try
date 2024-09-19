package com.tsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsl.pojo.BusinessTravelAir;

import java.util.List;

/**
 * @author Aditya Wakle
 * @version 1.0
 * @since 2024-08-30
 *
 */
@Repository
public interface BusinessTravelAirRepository extends JpaRepository<BusinessTravelAir, Long> {
    List<BusinessTravelAir> findByLoginId(Long loginId);
    List<BusinessTravelAir> findByLoginIdAndYear(Long loginId, String year);
}
	