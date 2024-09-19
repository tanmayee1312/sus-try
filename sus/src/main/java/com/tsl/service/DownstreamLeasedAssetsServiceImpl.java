package com.tsl.service;

import com.tsl.pojo.DownstreamLeasedAssets;
import com.tsl.pojo.Login;
import com.tsl.repository.DownstreamLeasedAssetsRepository;
import com.tsl.dto.DownstreamLeasedAssetsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownstreamLeasedAssetsServiceImpl implements DownstreamLeasedAssetsService {

    @Autowired
    private DownstreamLeasedAssetsRepository repository;

    @Override
    public List<DownstreamLeasedAssets> getAssetsByLoginIdAndYear(Long loginId, String year) {
        return repository.findByLoginIdAndYear(loginId, year);
    }

    @Override
    public void saveOrUpdateAssets(DownstreamLeasedAssetsForm form, Long loginId) {
        // Save or update for each month
        saveOrUpdateAsset(form, loginId, "Apr", form.getAprAreaOfLeasedAssets(), form.getAprScope1DieselInDGSets(), form.getAprScope2ElectricityConsumption(), form.getAprTotalBuiltUpAreaOfBuilding(), form.getAprTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "May", form.getMayAreaOfLeasedAssets(), form.getMayScope1DieselInDGSets(), form.getMayScope2ElectricityConsumption(), form.getMayTotalBuiltUpAreaOfBuilding(), form.getMayTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Jun", form.getJunAreaOfLeasedAssets(), form.getJunScope1DieselInDGSets(), form.getJunScope2ElectricityConsumption(), form.getJunTotalBuiltUpAreaOfBuilding(), form.getJunTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Jul", form.getJulAreaOfLeasedAssets(), form.getJulScope1DieselInDGSets(), form.getJulScope2ElectricityConsumption(), form.getJulTotalBuiltUpAreaOfBuilding(), form.getJulTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Aug", form.getAugAreaOfLeasedAssets(), form.getAugScope1DieselInDGSets(), form.getAugScope2ElectricityConsumption(), form.getAugTotalBuiltUpAreaOfBuilding(), form.getAugTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Sep", form.getSepAreaOfLeasedAssets(), form.getSepScope1DieselInDGSets(), form.getSepScope2ElectricityConsumption(), form.getSepTotalBuiltUpAreaOfBuilding(), form.getSepTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Oct", form.getOctAreaOfLeasedAssets(), form.getOctScope1DieselInDGSets(), form.getOctScope2ElectricityConsumption(), form.getOctTotalBuiltUpAreaOfBuilding(), form.getOctTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Nov", form.getNovAreaOfLeasedAssets(), form.getNovScope1DieselInDGSets(), form.getNovScope2ElectricityConsumption(), form.getNovTotalBuiltUpAreaOfBuilding(), form.getNovTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Dec", form.getDecAreaOfLeasedAssets(), form.getDecScope1DieselInDGSets(), form.getDecScope2ElectricityConsumption(), form.getDecTotalBuiltUpAreaOfBuilding(), form.getDecTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Jan", form.getJanAreaOfLeasedAssets(), form.getJanScope1DieselInDGSets(), form.getJanScope2ElectricityConsumption(), form.getJanTotalBuiltUpAreaOfBuilding(), form.getJanTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Feb", form.getFebAreaOfLeasedAssets(), form.getFebScope1DieselInDGSets(), form.getFebScope2ElectricityConsumption(), form.getFebTotalBuiltUpAreaOfBuilding(), form.getFebTotalBuildingOccupancyRate());
        saveOrUpdateAsset(form, loginId, "Mar", form.getMarAreaOfLeasedAssets(), form.getMarScope1DieselInDGSets(), form.getMarScope2ElectricityConsumption(), form.getMarTotalBuiltUpAreaOfBuilding(), form.getMarTotalBuildingOccupancyRate());
    }

    private void saveOrUpdateAsset(DownstreamLeasedAssetsForm form, Long loginId, String month, Double areaOfLeasedAssets, String scope1DieselInDGSets, String scope2ElectricityConsumption, Double totalBuiltUpAreaOfBuilding, Double totalBuildingOccupancyRate) {
        List<DownstreamLeasedAssets> existingAssets = repository.findByLoginIdAndYear(loginId, form.getYear());
        
        // Check if an entry already exists for the given month
        DownstreamLeasedAssets existingAsset = existingAssets.stream()
            .filter(asset -> month.equals(asset.getMonth()))
            .findFirst()
            .orElse(new DownstreamLeasedAssets());

        existingAsset.setMonth(month);
        existingAsset.setYear(form.getYear());
        existingAsset.setAreaOfLeasedAssets(areaOfLeasedAssets);
        existingAsset.setScope1DieselInDGSets(scope1DieselInDGSets);
        existingAsset.setScope2ElectricityConsumption(scope2ElectricityConsumption);
        existingAsset.setTotalBuiltUpAreaOfBuilding(totalBuiltUpAreaOfBuilding);
        existingAsset.setTotalBuildingOccupancyRate(totalBuildingOccupancyRate);

        // Assuming you have a method to fetch Login by loginId
        Login login = new Login(); // Replace with actual fetching logic
        login.setId(loginId);
        existingAsset.setLogin(login);

        repository.save(existingAsset);
    }
}
