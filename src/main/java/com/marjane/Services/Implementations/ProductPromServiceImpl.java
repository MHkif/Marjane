package com.marjane.Services.Implementations;

import com.marjane.DTOs.ProductPromotionDTO;
import com.marjane.Entities.ProductPromotion;
import com.marjane.Repositories.ProductPromotionRepository;
import com.marjane.Services.Interfaces.ProductPromotionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductPromServiceImpl implements ProductPromotionService {

    private ProductPromotionRepository repository;

    @Autowired
    public ProductPromServiceImpl(ProductPromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductPromotionDTO findById(Long id) {
        return null;
    }

    @Override
    public List<ProductPromotionDTO> findAll() {
        return null;
    }

    @Override
    public ProductPromotionDTO save(ProductPromotionDTO promotion) {
        ProductPromotion productPromotion = repository.save(mapToProductPromotion(promotion));
        return mapToProductPromotionDTO(productPromotion);
    }

    @Override
    public void delete(Long id) {

    }

    private ProductPromotionDTO mapToProductPromotionDTO(ProductPromotion promotion){
        return ProductPromotionDTO.builder()
                .id(promotion.getId())
                .admin(promotion.getAdmin())
                .product(promotion.getProduct())
                .percentage(promotion.getPercentage())
                .createdAt(promotion.getCreatedAt())
                .startAt(promotion.getStartAt())
                .endAt(promotion.getEndAt())
                .build();
    }

    private ProductPromotion mapToProductPromotion(ProductPromotionDTO promotion){
        ProductPromotion productPromotion =  new ProductPromotion();
        productPromotion.setId(promotion.getId());
        productPromotion.setAdmin(promotion.getAdmin());
        productPromotion.setProduct(promotion.getProduct());
        productPromotion.setPercentage(promotion.getPercentage());
        productPromotion.setCreatedAt(promotion.getCreatedAt());
        productPromotion.setStartAt(promotion.getStartAt());
        productPromotion.setEndAt(promotion.getEndAt());

        return productPromotion;
    }
}
