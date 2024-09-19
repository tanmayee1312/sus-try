package com.tsl.repository;

import com.tsl.pojo.S1Discharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface S1DischargeRepository extends JpaRepository<S1Discharge, Long> {
    List<S1Discharge> findByLoginId(Long loginId);
    
    List<S1Discharge> findByLogin_IdAndYear(Long loginId, String year);
    

    @Modifying
    @Query("UPDATE S1Discharge d SET d.molasisUsed = :molasisUsed, d.co2ReleasedFermentation = :co2ReleasedFermentation, d.ethanolProduced = :ethanolProduced, d.molasisUsedUOM = :molasisUsedUOM, d.co2ReleasedFermentationUOM = :co2ReleasedFermentationUOM, d.ethanolProducedUOM = :ethanolProducedUOM WHERE d.login.id = :loginId AND d.month = :month AND d.year = :year")
    void updateDischargeDataForMonth(Long loginId, String year, String month, double molasisUsed, double co2ReleasedFermentation, double ethanolProduced, String molasisUsedUOM, String co2ReleasedFermentationUOM, String ethanolProducedUOM);

    Optional<S1Discharge> findByLogin_IdAndYearAndMonth(Long loginId, String year, String month);

}
