package com.marjane.Services.Interfaces;

import com.marjane.DTOs.ProductPromotionDTO;
import com.marjane.Entities.Abstracts.Promotion;
import java.util.List;
import java.util.Optional;

public interface IPromotionService<Entity, DTO> {
    Optional<Entity> findById(Long id);

    List<Entity> findAll();

    Optional<Entity> save(DTO promotion);
    Optional<Entity> update(DTO promotion);

    void delete(Long id);
}
