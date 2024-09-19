package com.tsl.service;

import com.tsl.pojo.S3PurchasedGoodsAndServices;
import com.tsl.form.S3PurchasedGoodsAndServicesForm;

import java.util.List;

public interface S3PurchasedGoodsAndServicesService {
    void saveS3PurchasedGoodsAndServices(S3PurchasedGoodsAndServicesForm form);
    List<S3PurchasedGoodsAndServices> getS3PurchasedGoodsAndServicesByLoginId(Long loginId);
    List<S3PurchasedGoodsAndServices> getS3PurchasedGoodsAndServicesByLoginIdAndYear(Long loginId, String year);
}
