package com.tsl.BRSR.repository;

import com.tsl.pojo.GeneralInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneralInformationRepository extends JpaRepository<GeneralInformation, Long> {
	  List<GeneralInformation> findByLoginId(Long userId);
	    List<GeneralInformation> findByLoginIdAndYear(Long userId, String year);
	    Optional<GeneralInformation> findByIdAndLoginId(Long id, Long userId); 
}
