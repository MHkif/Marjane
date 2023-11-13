package com.marjane.Repositories;

import com.marjane.Entities.ProductPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductPromotionRepository extends JpaRepository<ProductPromotion, Long> {
}
