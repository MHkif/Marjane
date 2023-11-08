package com.marjane.Services.Interfaces;

import com.marjane.Entities.Abstracts.Promotion;
import java.util.List;

public interface IPromotionService<DTO> {
    DTO findById(Long id);

    List<DTO> findAll();

    DTO save(Promotion promotion);

    void delete(Long id);
}
