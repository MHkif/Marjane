package com.marjane.Entities;
import com.marjane.Entities.Abstracts.Promotion;
import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "subCategoryPromotions")
public class SubCategoryPromotion  extends Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "subCat_id", nullable = false)
    private SubCategory subCategory;

}
