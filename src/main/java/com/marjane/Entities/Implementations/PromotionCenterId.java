package com.marjane.Entities.Implementations;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PromotionCenterId implements Serializable {
    private Long centerId;
    private Long promotionId;


}