package com.tsl.repository;

import com.tsl.pojo.S1CoalUsed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface S1CoalUsedRepository extends JpaRepository<S1CoalUsed, Long> {
    List<S1CoalUsed> findByLoginIdAndYear(Long loginId, String year);
}
