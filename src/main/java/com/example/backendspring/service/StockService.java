package com.example.backendspring.service;

import com.example.backendspring.Repository.StockRepository;
import com.example.backendspring.model.Stock;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StockService {
    StockRepository stockRepository;
    public List<Stock> getStockList() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Integer id) {
        return stockRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Couldn't find Stock with id " + id));
    }
    public Stock addStock(Stock stock) {
        stock.setStockLabel(stock.getStockLabel());
        return stockRepository.save(stock);
    }
    public ResponseEntity<Stock> removeStock(Integer id) {
        stockRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    public String updateStock(Stock stock , Integer id) {
        Stock updatedStock = getStockById(id);
        updatedStock.setStockLabel(stock.getStockLabel());
        return "Update done";
    }
}
