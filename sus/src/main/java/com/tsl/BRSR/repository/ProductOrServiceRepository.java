package com.tsl.BRSR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tsl.pojo.ProductOrService;

@Repository
public interface ProductOrServiceRepository extends JpaRepository<ProductOrService, Long>{
    List<ProductOrService> findByUserId(Long userId);

	List<ProductOrService> findByUserIdAndYear(Long userId, String year);

	ProductOrService findByIdAndUserId(Long id, Long userId);

}
