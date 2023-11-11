package com.marjane.Repositories;

import com.marjane.Entities.Implementations.PromotionCenterId;
import com.marjane.Entities.PromotionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionCenterRepository extends JpaRepository<PromotionCenter, PromotionCenterId> {
}
