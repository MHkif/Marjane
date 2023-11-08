package com.marjane.Entities.Implementations;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PromotionCenterId implements Serializable {
    private Long centerId;
    private Long promotionId;

    // Constructors, equals, and hashCode methods
}