package com.tsl.form;

import lombok.Data;
import java.util.List;
import com.tsl.dto.S3PurchasedGoodsAndServicesDTO;

@Data
public class S3PurchasedGoodsAndServicesForm {
    private Long loginId;
    private List<S3PurchasedGoodsAndServicesDTO> purchasedGoodsAndServices;
}
