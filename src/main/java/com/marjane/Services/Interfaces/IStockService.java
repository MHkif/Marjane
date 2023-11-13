package com.marjane.Services.Interfaces;

import com.marjane.Entities.Product;
import com.marjane.Entities.Stock;

public interface IStockService {

    public Stock findByProduct(Product product);
}
