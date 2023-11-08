package com.marjane.DTOs.Requests;

import com.marjane.DTOs.Abstracts.PromotionDTO;
import com.marjane.Entities.ProductPromotion;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PromotionRequest<Promotion> extends PromotionDTO<Promotion> {
    private Promotion promotion;
    private String type;
}
