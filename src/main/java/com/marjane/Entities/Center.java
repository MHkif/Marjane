package com.marjane.Entities;

import com.marjane.Entities.Abstracts.Promotion;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "centers")
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private ProxyAdmin admin;
/*
    @ManyToMany(mappedBy = "centers")
    private List<CategoryPromotion> categoryPromotions;

    @ManyToMany(mappedBy = "centers")
    private List<ProductPromotion> productPromotions;

    @ManyToMany(mappedBy = "centers")
    private List<SubCategoryPromotion> subCategoryPromotions;



 */
    @OneToMany(mappedBy = "center")
    private List<PromotionCenter> centerPromotions = new ArrayList<>();

}