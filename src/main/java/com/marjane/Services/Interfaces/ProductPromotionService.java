package com.marjane.Services.Interfaces;

import com.marjane.DTOs.ProductPromotionDTO;
import com.marjane.Entities.Abstracts.Promotion;
import com.marjane.Entities.ProductPromotion;

import java.util.List;

public interface ProductPromotionService {
    ProductPromotionDTO findById(Long id);

    List<ProductPromotionDTO> findAll();

    ProductPromotionDTO save(ProductPromotionDTO promotion);

    void delete(Long id);
}
