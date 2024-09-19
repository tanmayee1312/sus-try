package com.tsl.repository;

import com.tsl.pojo.DownstreamLeasedAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownstreamLeasedAssetsRepository extends JpaRepository<DownstreamLeasedAssets, Long> {
    List<DownstreamLeasedAssets> findByLoginIdAndYear(Long loginId, String year);
}
