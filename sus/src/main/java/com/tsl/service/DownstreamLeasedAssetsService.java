package com.tsl.service;

import com.tsl.pojo.DownstreamLeasedAssets;
import com.tsl.dto.DownstreamLeasedAssetsForm;

import java.util.List;

public interface DownstreamLeasedAssetsService {
    List<DownstreamLeasedAssets> getAssetsByLoginIdAndYear(Long loginId, String year);
    void saveOrUpdateAssets(DownstreamLeasedAssetsForm form, Long loginId);
}
