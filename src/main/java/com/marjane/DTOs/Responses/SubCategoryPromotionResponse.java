package com.marjane.DTOs.Responses;

import com.marjane.Entities.SubCategoryPromotion;
import lombok.Data;


@Data
public class SubCategoryPromotionResponse {
    private Long id;
    private SubCategoryPromotion promotion;
}
