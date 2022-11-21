package com.revature.services;

import com.revature.models.Stock;
import com.revature.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    public StockServiceImpl(StockRepo stockRepo){
        this.stockRepo = stockRepo;
    }

    @Override
    public boolean createStock(Stock stock){
        int stockCreated = stockRepo.save(stock).getCompanyId();
        return (stockCreated > 0) ? true:false;
    }

    @Override
    public Stock getStockById(int id){
        try {
            Optional<Stock> optionalStock = stockRepo.findById(id);
            Stock stock = optionalStock.get();
            return stock;
        } catch(NoSuchElementException e){
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Stock> getAllStocks(){
        return stockRepo.findAll();
    }

    @Override
    public int updateStockPriceById(Stock stock){
        return stockRepo.updateStockPriceById(stock.getStockPrice(), stock.getCompanyId());
    }

    @Override
    public int updateMarketCapitalizationById(Stock stock){
        return stockRepo.updateMarketCapitalizationById(stock.getMarketCapitalization(), stock.getCompanyId());
    }

    @Override
    public boolean deleteStock(Stock stock){
        stockRepo.delete(stock);
        return true;
    }
}



