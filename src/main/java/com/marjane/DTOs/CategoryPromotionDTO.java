package com.marjane.DTOs;

import com.marjane.Entities.Category;
import com.marjane.Entities.Product;
import com.marjane.Entities.ProxyAdmin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryPromotionDTO {
    private Long id;
    private Category category;
    private ProxyAdmin admin;
    private BigDecimal percentage;
    private LocalDateTime createdAt;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
