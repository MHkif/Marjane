package com.marjane.DTOs.Responses;

import com.marjane.Entities.CategoryPromotion;
import lombok.Data;

@Data
public class CategoryPromotionResponse {
    private Long id;
    private CategoryPromotion promotion;
}
