package com.tsl.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsl.pojo.S1FireExtinguisher;
@Repository
public interface S1FireExtinguisherRepository extends JpaRepository<S1FireExtinguisher, Long> {
	
    List<S1FireExtinguisher> findByLoginId(Long loginId);
    List<S1FireExtinguisher> findByLoginIdAndYear(Long loginId, String year);
    List<S1FireExtinguisher> findByLoginIdAndType(Long loginId, String type);
}	