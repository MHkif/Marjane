package com.marjane.Entities;

import com.marjane.Entities.Abstracts.Promotion;
import com.marjane.Entities.Implementations.PromotionCenterId;
import com.marjane.Enums.PromotionStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "promotion_center")
public class PromotionCenter {

    @EmbeddedId
    private PromotionCenterId id;

    @MapsId("promotionId")
    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = false)
    private ProductPromotion promotion;

    @MapsId("centerId")
    @ManyToOne
    @JoinColumn(name = "center_id", nullable = false)
    private Center center;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Enumerated(EnumType.STRING)
    private PromotionStatus status;

    private LocalDateTime performedAt;

    public PromotionCenter() {
        this.status = PromotionStatus.PENDING;
    }

}