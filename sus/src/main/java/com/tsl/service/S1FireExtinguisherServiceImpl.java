package com.tsl.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tsl.dto.S1FireExtinguisherDTO;
import com.tsl.dto.TotalDTO;
import com.tsl.form.S1FireExtinguisherForm;
import com.tsl.pojo.S1FireExtinguisher;
import com.tsl.pojo.Login;
import com.tsl.repository.S1FireExtinguisherRepository;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class S1FireExtinguisherServiceImpl implements S1FireExtinguisherService {
    private final S1FireExtinguisherRepository repository;
    @Override
    @Transactional
    public List<S1FireExtinguisher> saveAll(S1FireExtinguisherForm form) {
        List<S1FireExtinguisher> extinguishers = form.getExtinguishers().stream()
            .map(dto -> {
                S1FireExtinguisher entity = createEntity(dto, form.getLoginId());
                if ("CO2".equalsIgnoreCase(entity.getType())) {
                    double totalKg = entity.getAnnualRefillingQuantity() + (entity.getCylindersPurchased() * entity.getCapacityOfCylinder());
                    entity.setTotalKg(totalKg);
                    entity.setTotalTonnes(totalKg / 1000); // Convert kg to tonnes
                } else {
                    entity.setTotalKg(0);
                    entity.setTotalTonnes(0);
                }
                return entity;
            })
            .collect(Collectors.toList());
        List<S1FireExtinguisher> savedExtinguishers = repository.saveAll(extinguishers);
        // Recalculate and update aggregate totals
        updateAggregateTotals(form.getLoginId());
        return savedExtinguishers;
    }
    @Override
    public List<S1FireExtinguisher> getByLoginId(Long loginId) {
        return repository.findByLoginId(loginId);
    }
    @Override
    public S1FireExtinguisher getTotalByLoginId(Long loginId) {
        List<S1FireExtinguisher> extinguishers = repository.findByLoginId(loginId);
        double totalKg = extinguishers.stream()
            .filter(e -> "CO2".equalsIgnoreCase(e.getType()))
            .mapToDouble(S1FireExtinguisher::getTotalKg)
            .sum();
        double totalTonnes = extinguishers.stream()
            .filter(e -> "CO2".equalsIgnoreCase(e.getType()))
            .mapToDouble(S1FireExtinguisher::getTotalTonnes)
            .sum();
        S1FireExtinguisher totalDTO = new S1FireExtinguisher();
        totalDTO.setTotalKg(totalKg);
        totalDTO.setTotalTonnes(totalTonnes);
        return totalDTO;
    }
    private S1FireExtinguisher createEntity(S1FireExtinguisherDTO dto, Long loginId) {
        S1FireExtinguisher entity = new S1FireExtinguisher();
        entity.setType(dto.getType());
        entity.setYear(dto.getYear());
        entity.setAnnualRefillingQuantity(dto.getAnnualRefillingQuantity());
        entity.setCylindersPurchased(dto.getCylindersPurchased());
        entity.setCapacityOfCylinder(dto.getCapacityOfCylinder());
        Login login = new Login();
        login.setId(loginId);
        entity.setLogin(login);
        return entity;
    }
    private void updateAggregateTotals(Long loginId) {
        List<S1FireExtinguisher> extinguishers = repository.findByLoginId(loginId);
        double aggregateTotalKg = extinguishers.stream()
            .filter(e -> "CO2".equalsIgnoreCase(e.getType()))
            .mapToDouble(S1FireExtinguisher::getTotalKg)
            .sum();
        double aggregateTotalTonnes = extinguishers.stream()
            .filter(e -> "CO2".equalsIgnoreCase(e.getType()))
            .mapToDouble(S1FireExtinguisher::getTotalTonnes)
            .sum();
        // Update the aggregate fields for each record
        extinguishers.forEach(e -> {
            if ("CO2".equalsIgnoreCase(e.getType())) {
                e.setAggregateTotalKg(aggregateTotalKg);
                e.setAggregateTotalTonnes(aggregateTotalTonnes);
                repository.save(e);
            }
        });
    }
    
    @Override
    public List<S1FireExtinguisher> findByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }
}