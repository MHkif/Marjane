package com.marjane.DTOs;

import com.marjane.Entities.Center;
import com.marjane.Entities.Implementations.PromotionCenterId;
import com.marjane.Entities.Manager;
import com.marjane.Entities.ProductPromotion;
import com.marjane.Enums.PromotionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionCenterDTO {
    private PromotionCenterId id;
    private ProductPromotion productPromotion;
    private Center center;
    private Manager manager;
    private PromotionStatus status;
    private LocalDateTime performedAt;
}
