package com.tsl.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "s3_purchased_goods_services")
public class S3PurchasedGoodsAndServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOfGoodsServices;

    private String year;

    private String classificationOfGoodsServices;

    private double quantityUnitPurchasedAnnually;

    private String unitOfMeasurement;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;
}
