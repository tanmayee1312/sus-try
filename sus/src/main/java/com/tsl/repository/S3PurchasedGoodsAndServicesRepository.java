package com.tsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsl.pojo.S3PurchasedGoodsAndServices;

import java.util.List;

@Repository
public interface S3PurchasedGoodsAndServicesRepository extends JpaRepository<S3PurchasedGoodsAndServices, Long> {
    List<S3PurchasedGoodsAndServices> findByLoginId(Long loginId);
    List<S3PurchasedGoodsAndServices> findByLoginIdAndYear(Long loginId, String year);
}
