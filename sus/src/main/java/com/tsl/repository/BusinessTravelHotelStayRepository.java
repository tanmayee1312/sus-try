package com.tsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsl.pojo.BusinessTravelHotelStay;

import java.util.List;

@Repository
public interface BusinessTravelHotelStayRepository extends JpaRepository<BusinessTravelHotelStay, Long> {
    List<BusinessTravelHotelStay> findByLoginId(Long loginId);
    List<BusinessTravelHotelStay> findByLoginIdAndYear(Long loginId, String year);
}
