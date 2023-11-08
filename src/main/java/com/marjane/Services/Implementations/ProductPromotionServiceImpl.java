package com.marjane.Services.Implementations;

import com.marjane.Entities.Abstracts.Promotion;
import com.marjane.Entities.ProductPromotion;
import com.marjane.DTOs.Responses.ProductPromotionResponse;
import com.marjane.Repositories.ProductPromotionRepository;
import com.marjane.Services.Interfaces.IProductPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPromotionServiceImpl implements IProductPromotionService<Optional<ProductPromotionResponse>> {

    private ProductPromotionRepository repository;

    @Autowired
    public ProductPromotionServiceImpl(ProductPromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ProductPromotionResponse> findById(Long id) {
        ProductPromotion promotion =  repository.findById(id).orElse(null);
        return Optional.of(new ProductPromotionResponse(promotion.getId(), promotion));
    }

    @Override
    public List<Optional<ProductPromotionResponse>> findAll() {
        return null;
    }

    @Override
    public Optional<ProductPromotionResponse> save(Promotion promotion) {
        if(promotion instanceof ProductPromotion ){
            repository.save((ProductPromotion) promotion);
            return Optional.of(new ProductPromotionResponse(2L, (ProductPromotion) promotion));
        }  else
            return Optional.empty();

    }

    @Override
    public void delete(Long id) {

    }
}
