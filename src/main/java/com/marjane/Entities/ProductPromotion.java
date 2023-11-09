package com.marjane.Entities;
import com.marjane.Entities.Abstracts.Promotion;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "productPromotions")
public class ProductPromotion extends Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "promotion")
    private List<PromotionCenter> promotionCenters = new ArrayList<>();
}



