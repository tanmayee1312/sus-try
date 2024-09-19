package com.tsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsl.pojo.WasteGenerated;

import java.util.List;

@Repository
public interface WasteGeneratedRepository extends JpaRepository<WasteGenerated, Long> {
    // Method to find by login ID
    List<WasteGenerated> findByLogin_Id(Long loginId);

    // Method to find by login ID and year
    List<WasteGenerated> findByLogin_IdAndYear(Long loginId, String year);
}
