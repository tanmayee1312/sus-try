package com.tsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsl.pojo.BusinessTravelRoad;

import java.util.List;

@Repository
public interface BusinessTravelRoadRepository extends JpaRepository<BusinessTravelRoad, Long> {
    List<BusinessTravelRoad> findByLoginId(Long loginId);
    List<BusinessTravelRoad> findByLoginIdAndYear(Long loginId, String year);
}
