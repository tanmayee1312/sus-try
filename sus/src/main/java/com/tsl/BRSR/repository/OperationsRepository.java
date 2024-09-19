package com.tsl.BRSR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsl.pojo.BusinessActivity;
import com.tsl.pojo.Operations;

@Repository
public interface OperationsRepository extends JpaRepository<Operations, Long> {
	 List<Operations> findByUserId(Long userId);

	    List<Operations> findByUserIdAndYear(Long userId, String year);

	    Operations findByIdAndUserId(Long id, Long userId);  // Find specific operation by id and user
}
