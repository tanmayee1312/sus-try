package com.tsl.repository;

import com.tsl.pojo.S2PurchasedElectricity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface S2PurchasedElectricityRepository extends JpaRepository<S2PurchasedElectricity, Long> {
    List<S2PurchasedElectricity> findByLoginId(Long loginId);
    List<S2PurchasedElectricity> findByLoginIdAndYear(Long loginId, String year);
}
