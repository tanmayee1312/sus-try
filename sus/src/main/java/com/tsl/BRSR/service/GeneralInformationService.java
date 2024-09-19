package com.tsl.BRSR.service;

import com.tsl.BRSR.dto.GeneralInformationDTO;
import com.tsl.pojo.GeneralInformation;
import com.tsl.pojo.Login;
import com.tsl.BRSR.repository.GeneralInformationRepository;
import com.tsl.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeneralInformationService {

    @Autowired
    private GeneralInformationRepository generalInformationRepository;

    @Autowired
    private LoginRepository loginRepository;

    // Save new GeneralInformation entries
    public List<GeneralInformationDTO> createGeneralInformation(List<GeneralInformationDTO> dtoList) {
        return dtoList.stream().map(dto -> {
            Login user = loginRepository.findById(dto.getUser_id())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            GeneralInformation generalInformation = new GeneralInformation();
            generalInformation.setLocation(dto.getLocation());
            generalInformation.setTotalOfficeFootprintArea(dto.getTotalOfficeFootprintArea());
            generalInformation.setNoOfEmployeeContractual(dto.getNoOfEmployeeContractual());
            generalInformation.setNoOfEmployeePermanent(dto.getNoOfEmployeePermanent());
            generalInformation.setYear(dto.getYear());
            generalInformation.setLogin(user);

            GeneralInformation savedInfo = generalInformationRepository.save(generalInformation);
            dto.setId(savedInfo.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    // Update existing GeneralInformation entries
    public List<GeneralInformationDTO> updateGeneralInformation(Long userId, List<GeneralInformationDTO> dtoList) {
        return dtoList.stream().map(dto -> {
            GeneralInformation existingInfo = generalInformationRepository.findById(dto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("GeneralInformation not found for id: " + dto.getId()));

            if (!existingInfo.getLogin().getId().equals(userId)) {
                throw new IllegalArgumentException("User does not have permission to update this GeneralInformation.");
            }

            existingInfo.setLocation(dto.getLocation());
            existingInfo.setTotalOfficeFootprintArea(dto.getTotalOfficeFootprintArea());
            existingInfo.setNoOfEmployeeContractual(dto.getNoOfEmployeeContractual());
            existingInfo.setNoOfEmployeePermanent(dto.getNoOfEmployeePermanent());
            existingInfo.setYear(dto.getYear());

            GeneralInformation updatedInfo = generalInformationRepository.save(existingInfo);
            return new GeneralInformationDTO(updatedInfo.getId(), updatedInfo.getLocation(),
                    updatedInfo.getTotalOfficeFootprintArea(), updatedInfo.getNoOfEmployeeContractual(),
                    updatedInfo.getNoOfEmployeePermanent(), updatedInfo.getYear(), updatedInfo.getLogin().getId());
        }).collect(Collectors.toList());
    }

    // Fetch GeneralInformation by userId and year
    public List<GeneralInformationDTO> getGeneralInformationByUserIdAndYear(Long userId, String year) {
        return generalInformationRepository.findByLoginIdAndYear(userId, year).stream()
                .map(info -> new GeneralInformationDTO(info.getId(), info.getLocation(),
                        info.getTotalOfficeFootprintArea(), info.getNoOfEmployeeContractual(),
                        info.getNoOfEmployeePermanent(), info.getYear(), info.getLogin().getId()))
                .collect(Collectors.toList());
    }

    // Fetch GeneralInformation by userId
    public List<GeneralInformationDTO> getGeneralInformationByUserId(Long userId) {
        return generalInformationRepository.findByLoginId(userId).stream()
                .map(info -> new GeneralInformationDTO(info.getId(), info.getLocation(),
                        info.getTotalOfficeFootprintArea(), info.getNoOfEmployeeContractual(),
                        info.getNoOfEmployeePermanent(), info.getYear(), info.getLogin().getId()))
                .collect(Collectors.toList());
    }

    // Fetch all GeneralInformation entries
    public List<GeneralInformationDTO> getAllGeneralInformation() {
        return generalInformationRepository.findAll().stream()
                .map(info -> new GeneralInformationDTO(info.getId(), info.getLocation(),
                        info.getTotalOfficeFootprintArea(), info.getNoOfEmployeeContractual(),
                        info.getNoOfEmployeePermanent(), info.getYear(), info.getLogin().getId()))
                .collect(Collectors.toList());
    }

    // Fetch GeneralInformation by id
    public GeneralInformationDTO getGeneralInformationById(Long id) {
        GeneralInformation info = generalInformationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GeneralInformation not found for id: " + id));
        return new GeneralInformationDTO(info.getId(), info.getLocation(),
                info.getTotalOfficeFootprintArea(), info.getNoOfEmployeeContractual(),
                info.getNoOfEmployeePermanent(), info.getYear(), info.getLogin().getId());
    }

    // Fetch GeneralInformation by id and userId
    public GeneralInformationDTO getGeneralInformationByIdAndUserId(Long id, Long userId) {
        Optional<GeneralInformation> infoOpt = generalInformationRepository.findByIdAndLoginId(id, userId);
        GeneralInformation info = infoOpt
                .orElseThrow(() -> new IllegalArgumentException("GeneralInformation not found for id: " + id + " and userId: " + userId));
        return new GeneralInformationDTO(info.getId(), info.getLocation(),
                info.getTotalOfficeFootprintArea(), info.getNoOfEmployeeContractual(),
                info.getNoOfEmployeePermanent(), info.getYear(), info.getLogin().getId());
    }
}
