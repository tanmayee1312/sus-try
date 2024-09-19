package com.tsl.repository;

import com.tsl.pojo.EmployeeCommute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCommuteRepository extends JpaRepository<EmployeeCommute, Long> {
    List<EmployeeCommute> findByLoginId(Long loginId);
    List<EmployeeCommute> findByLoginIdAndYear(Long loginId, String year);
}
