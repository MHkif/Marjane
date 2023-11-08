package com.marjane.DTOs.Responses;

import com.marjane.Entities.ProductPromotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductPromotionResponse {

    private Long id;
    private ProductPromotion promotion;
}
