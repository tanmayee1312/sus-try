package com.tsl.BRSR.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsl.pojo.GeneralDiscloser;

@Repository
public interface GeneralDiscloserRepository extends JpaRepository<GeneralDiscloser, Long>{
    
	 List<GeneralDiscloser> findByUserId(Long userId);

	    List<GeneralDiscloser> findByUserIdAndYear(Long userId, String year);

	    GeneralDiscloser findByIdAndUserId(Long id, Long userId);  // Find specific GeneralDiscloser by id and userId
	

}
