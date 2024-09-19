package com.tsl.repository;
/*
import com.tsl.pojo.S1LPGConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface S1LPGConsumptionRepository extends JpaRepository<S1LPGConsumption, Long> {
    List<S1LPGConsumption> findByLoginId(Long loginId);
    
    List<S1LPGConsumption> findByLoginIdAndYear(Long loginId, String year);
}
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsl.pojo.S1LPGConsumption;

import java.util.List;

public interface S1LPGConsumptionRepository extends JpaRepository<S1LPGConsumption, Long> {

    // Find all consumption data for a specific loginId and year
    List<S1LPGConsumption> findByLoginIdAndYear(Long loginId, String year);

    // Find specific consumption data by month, year, and loginId
    List<S1LPGConsumption> findByMonthAndYearAndLoginId(String month, String year, Long loginId);

}
