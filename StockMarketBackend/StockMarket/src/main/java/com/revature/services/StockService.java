package com.revature.services;

import com.revature.models.Stock;

import java.util.List;

public interface StockService {

    boolean createStock(Stock stock);

    Stock getStockById(int id);

    List<Stock> getAllStocks();

    List<Stock> getAllByMarketCap(long marketCapitalization);

    int updateStockPriceById(Stock stock);

    int updateMarketCapitalizationById(Stock stock);

    boolean deleteStock(Stock stock);
}
