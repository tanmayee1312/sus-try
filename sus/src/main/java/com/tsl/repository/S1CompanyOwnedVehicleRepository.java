package com.tsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsl.pojo.S1CompanyOwnedVehicle;

@Repository
public interface S1CompanyOwnedVehicleRepository extends JpaRepository<S1CompanyOwnedVehicle, Long> {

	List<S1CompanyOwnedVehicle> findByLoginIdAndYear(Long loginId, String year);
}
