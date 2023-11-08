package com.marjane.Entities;
import com.marjane.Entities.Abstracts.Promotion;
import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "categoryPromotions")
public class CategoryPromotion extends Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private Category category;

}
