package com.marjane.Services.Interfaces;

import com.marjane.DTOs.ProductPromotionDTO;
import com.marjane.DTOs.PromotionCenterDTO;
import com.marjane.Entities.Center;
import com.marjane.Entities.Implementations.PromotionCenterId;
import com.marjane.Entities.ProductPromotion;
import com.marjane.Entities.PromotionCenter;

import java.util.List;
import java.util.Optional;

public interface IPromotionCenterService {


    Optional<PromotionCenter> save(PromotionCenterDTO promotion);
    Optional<PromotionCenter>  findById(PromotionCenterId id);
    List<PromotionCenter> findAll();
    void delete(PromotionCenterId id);

    PromotionCenterDTO mapToDTO(PromotionCenter promotion);

    PromotionCenter mapToEntity(PromotionCenterDTO promotion);
}
