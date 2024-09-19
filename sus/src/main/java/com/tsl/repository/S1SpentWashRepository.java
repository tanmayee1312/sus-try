package com.tsl.repository;

import com.tsl.pojo.S1SpentWash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface S1SpentWashRepository extends JpaRepository<S1SpentWash, Long> {
    List<S1SpentWash> findByLoginId(Long loginId);
    List<S1SpentWash> findByLoginIdAndYear(Long loginId, String year);
}
