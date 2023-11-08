package com.marjane.DTOs.Responses;
import com.marjane.DTOs.Abstracts.PromotionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PromotionResponse<Promotion> extends PromotionDTO<Promotion> {
   // private Long id;
    private Promotion promotion;
}
