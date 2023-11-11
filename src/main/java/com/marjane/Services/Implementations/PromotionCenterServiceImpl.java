package com.marjane.Services.Implementations;

import com.marjane.DTOs.ProductPromotionDTO;
import com.marjane.DTOs.PromotionCenterDTO;
import com.marjane.Entities.Center;
import com.marjane.Entities.Implementations.PromotionCenterId;
import com.marjane.Entities.ProductPromotion;
import com.marjane.Entities.PromotionCenter;
import com.marjane.Repositories.PromotionCenterRepository;
import com.marjane.Services.Interfaces.IPromotionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionCenterServiceImpl implements IPromotionCenterService {

    private PromotionCenterRepository repository;

    @Autowired
    public PromotionCenterServiceImpl(PromotionCenterRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<PromotionCenter> save(PromotionCenterDTO promotionDto) {
        PromotionCenter promotionCenter = repository.save(mapToEntity(promotionDto));
        return Optional.of(promotionCenter);
    }

    @Override
    public Optional<PromotionCenter>  findById(PromotionCenterId id) {

        return repository.findById(id);
    }

    @Override
    public List<PromotionCenter> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(PromotionCenterId id) {

    }

    @Override
    public PromotionCenterDTO mapToDTO(PromotionCenter promotion) {
        return PromotionCenterDTO.builder().
                id(promotion.getId())
                .productPromotion(promotion.getPromotion())
                .center(promotion.getCenter())
                .manager(promotion.getManager())
                .status(promotion.getStatus())
                .performedAt(promotion.getPerformedAt())
                .build();
    }

    @Override
    public PromotionCenter mapToEntity(PromotionCenterDTO promotion) {
        PromotionCenter promotionCenter = new PromotionCenter();
        promotionCenter.setId(promotion.getId());
        promotionCenter.setPromotion(promotion.getProductPromotion());
        promotionCenter.setCenter(promotion.getCenter());
        promotionCenter.setManager(promotion.getManager());
        promotionCenter.setStatus(promotion.getStatus());
        promotionCenter.setPerformedAt(promotion.getPerformedAt());
        return promotionCenter;
    }
}
