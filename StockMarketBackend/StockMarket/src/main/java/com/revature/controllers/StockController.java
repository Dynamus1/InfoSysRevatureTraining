package com.revature.controllers;

import com.revature.models.ClientMessage;
import com.revature.models.Stock;
import com.revature.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.revature.utils.ClientMessageUtils.*;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(value = "/stock", consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@GetMapping(value = "/stock")
    public @ResponseBody Stock getStockById(@RequestParam int id){
        return stockService.getStockById(id);
    }

    @GetMapping("/stocks")
    public @ResponseBody List<Stock> getAllStocks(){
        return stockService.getAllStocks();
    }

    @GetMapping("/stocksByMarketCap")
    public @ResponseBody List<Stock> getAllByMarketCap(@RequestParam long marketCapitalization){
        return stockService.getAllByMarketCap(marketCapitalization);
    }

    @PostMapping("/createStock")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createStock(@RequestBody Stock stock){
        return stockService.createStock(stock) ? CREATION_SUCCESSFUL:CREATION_FAILED;
    }

    @PutMapping("/updateStockPrice")
    public @ResponseBody ClientMessage updateStockPrice(@RequestBody Stock stock){
        return stockService.updateStockPriceById(stock) > 0 ? UPDATE_SUCCESSFUL:UPDATE_FAILED;
    }

    @PutMapping("/updateStockMarketCapitalization")
    public @ResponseBody ClientMessage updateStockMarketCapitalization(@RequestBody Stock stock){
        return stockService.updateMarketCapitalizationById(stock) > 0 ? UPDATE_SUCCESSFUL:UPDATE_FAILED;
    }

    @DeleteMapping("/deleteStock")
    public @ResponseBody ClientMessage deleteStock(@RequestBody Stock stock){
        return stockService.deleteStock(stock) ? DELETION_SUCCESSFUL:DELETION_FAILED;
    }
}
