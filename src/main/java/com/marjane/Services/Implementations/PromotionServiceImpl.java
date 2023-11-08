package com.marjane.Services.Implementations;

import com.marjane.Entities.Abstracts.Promotion;
import com.marjane.Services.Interfaces.IPromotionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromotionServiceImpl<PromotionResponse> implements IPromotionService<PromotionResponse> {


    @Override
    public PromotionResponse findById(Long id) {
        return null;
    }

    @Override
    public List<PromotionResponse> findAll() {
        return null;
    }

    @Override
    public PromotionResponse save(Promotion promotion) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
