package com.marjane.DTOs;

import com.marjane.Entities.Product;
import com.marjane.Entities.ProxyAdmin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductPromotionDTO {
    private Long id;
    private Product product;
    private ProxyAdmin admin;
    private BigDecimal percentage;
    private LocalDateTime createdAt;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
