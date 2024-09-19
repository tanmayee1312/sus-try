package com.tsl.dto;

import com.tsl.pojo.DownstreamLeasedAssets;
import com.tsl.pojo.Login;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DownstreamLeasedAssetsForm {
    private Long userId;
    private String year;

    private Double aprAreaOfLeasedAssets;
    private String aprScope1DieselInDGSets;
    private String aprScope2ElectricityConsumption;
    private Double aprTotalBuiltUpAreaOfBuilding;
    private Double aprTotalBuildingOccupancyRate;

    private Double mayAreaOfLeasedAssets;
    private String mayScope1DieselInDGSets;
    private String mayScope2ElectricityConsumption;
    private Double mayTotalBuiltUpAreaOfBuilding;
    private Double mayTotalBuildingOccupancyRate;

    private Double junAreaOfLeasedAssets;
    private String junScope1DieselInDGSets;
    private String junScope2ElectricityConsumption;
    private Double junTotalBuiltUpAreaOfBuilding;
    private Double junTotalBuildingOccupancyRate;

    private Double julAreaOfLeasedAssets;
    private String julScope1DieselInDGSets;
    private String julScope2ElectricityConsumption;
    private Double julTotalBuiltUpAreaOfBuilding;
    private Double julTotalBuildingOccupancyRate;

    private Double augAreaOfLeasedAssets;
    private String augScope1DieselInDGSets;
    private String augScope2ElectricityConsumption;
    private Double augTotalBuiltUpAreaOfBuilding;
    private Double augTotalBuildingOccupancyRate;

    private Double sepAreaOfLeasedAssets;
    private String sepScope1DieselInDGSets;
    private String sepScope2ElectricityConsumption;
    private Double sepTotalBuiltUpAreaOfBuilding;
    private Double sepTotalBuildingOccupancyRate;

    private Double octAreaOfLeasedAssets;
    private String octScope1DieselInDGSets;
    private String octScope2ElectricityConsumption;
    private Double octTotalBuiltUpAreaOfBuilding;
    private Double octTotalBuildingOccupancyRate;

    private Double novAreaOfLeasedAssets;
    private String novScope1DieselInDGSets;
    private String novScope2ElectricityConsumption;
    private Double novTotalBuiltUpAreaOfBuilding;
    private Double novTotalBuildingOccupancyRate;

    private Double decAreaOfLeasedAssets;
    private String decScope1DieselInDGSets;
    private String decScope2ElectricityConsumption;
    private Double decTotalBuiltUpAreaOfBuilding;
    private Double decTotalBuildingOccupancyRate;

    private Double janAreaOfLeasedAssets;
    private String janScope1DieselInDGSets;
    private String janScope2ElectricityConsumption;
    private Double janTotalBuiltUpAreaOfBuilding;
    private Double janTotalBuildingOccupancyRate;

    private Double febAreaOfLeasedAssets;
    private String febScope1DieselInDGSets;
    private String febScope2ElectricityConsumption;
    private Double febTotalBuiltUpAreaOfBuilding;
    private Double febTotalBuildingOccupancyRate;

    private Double marAreaOfLeasedAssets;
    private String marScope1DieselInDGSets;
    private String marScope2ElectricityConsumption;
    private Double marTotalBuiltUpAreaOfBuilding;
    private Double marTotalBuildingOccupancyRate;

    public DownstreamLeasedAssets toDownstreamLeasedAssets(String month, Double areaOfLeasedAssets, String scope1DieselInDGSets, String scope2ElectricityConsumption, Double totalBuiltUpAreaOfBuilding, Double totalBuildingOccupancyRate, Long loginId) {
        DownstreamLeasedAssets assets = new DownstreamLeasedAssets();
        assets.setMonth(month);
        assets.setYear(this.year);
        assets.setAreaOfLeasedAssets(areaOfLeasedAssets);
        assets.setScope1DieselInDGSets(scope1DieselInDGSets);
        assets.setScope2ElectricityConsumption(scope2ElectricityConsumption);
        assets.setTotalBuiltUpAreaOfBuilding(totalBuiltUpAreaOfBuilding);
        assets.setTotalBuildingOccupancyRate(totalBuildingOccupancyRate);

        // Assuming you have a method to fetch Login by loginId
        Login login = new Login(); // Replace with actual fetching logic
        login.setId(loginId);
        assets.setLogin(login);

        return assets;
    }
}
