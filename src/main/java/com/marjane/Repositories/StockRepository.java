package com.marjane.Repositories;

import com.marjane.Entities.Product;
import com.marjane.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock , Long> {
    Stock findByProduct(Product product);
}
