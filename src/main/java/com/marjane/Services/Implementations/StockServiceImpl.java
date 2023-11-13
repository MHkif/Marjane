package com.marjane.Services.Implementations;

import com.marjane.Entities.Product;
import com.marjane.Entities.Stock;
import com.marjane.Repositories.StockRepository;
import com.marjane.Services.Interfaces.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements IStockService {

    private StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock findByProduct(Product product) {
        return stockRepository.findByProduct(product);
    }
}
