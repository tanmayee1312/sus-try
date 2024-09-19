package com.tsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsl.pojo.BusinessTravelRail;

import java.util.List;

@Repository
public interface BusinessTravelRailRepository extends JpaRepository<BusinessTravelRail, Long> {
    List<BusinessTravelRail> findByLoginId(Long loginId);
    List<BusinessTravelRail> findByLoginIdAndYear(Long loginId, String year);
}
