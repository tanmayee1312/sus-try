package com.tsl.repository;

import com.tsl.pojo.S1ArcWelding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface S1ArcWeldingRepository extends JpaRepository<S1ArcWelding, Long> {
    List<S1ArcWelding> findByLoginId(Long loginId);
    List<S1ArcWelding> findByYearAndLoginId(String year, Long loginId);
}
