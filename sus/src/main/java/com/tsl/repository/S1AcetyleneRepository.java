package com.tsl.repository;

import com.tsl.pojo.S1Acetylene;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface S1AcetyleneRepository extends JpaRepository<S1Acetylene, Long> {
    
    // Custom method to find records by loginId and year
    List<S1Acetylene> findByLoginIdAndYear(Long loginId, String year);
    
    // Added for batch update
    @Modifying
    @Query("UPDATE S1Acetylene s SET s.acetyleneCylinderPurchased = :acetyleneCylinderPurchased, s.cylinderCapacity = :cylinderCapacity, s.materialCost = :materialCost, s.monthlyEmission = :monthlyEmission, s.yearlyEmission = :yearlyEmission, s.cylinderCapacityUOM = :cylinderCapacityUOM WHERE s.login.id = :loginId AND s.year = :year AND s.month = :month")
    int updateS1AcetyleneByMonth(@Param("loginId") Long loginId, @Param("year") String year, @Param("month") String month, @Param("acetyleneCylinderPurchased") Double acetyleneCylinderPurchased, @Param("cylinderCapacity") Double cylinderCapacity, @Param("materialCost") Double materialCost, @Param("monthlyEmission") Double monthlyEmission, @Param("yearlyEmission") Double yearlyEmission, @Param("cylinderCapacityUOM") String cylinderCapacityUOM);

}
